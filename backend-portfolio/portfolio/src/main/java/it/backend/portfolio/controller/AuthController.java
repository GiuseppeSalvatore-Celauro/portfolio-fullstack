package it.backend.portfolio.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.backend.portfolio.model.LoginRequest;
import it.backend.portfolio.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	private final UserDetailsService userDetailsService;
	
	public AuthController(AuthenticationManager authenticationManager, JwtService jwtService,
			UserDetailsService userDetailsService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
	    try {
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.getUsername(),
	                        request.getPassword()
	                )
	        );
	    } catch (BadCredentialsException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                             .body(Map.of("error", "Username o password errati"));
	    }

	    UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
	    String token = jwtService.generateToken(user);

	    return ResponseEntity.ok(Map.of("token", token));
	}
}
