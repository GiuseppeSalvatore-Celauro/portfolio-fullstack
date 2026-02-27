package it.backend.portfolio.config;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import it.backend.portfolio.model.User;
import it.backend.portfolio.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Component
public class UserInitializer {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostConstruct
	public void init() {
		Optional<User> user = userRepository.findByUsername("user83729");
		
		if(user.isEmpty()) {
			User newUser = new User();
			newUser.setUsername("user83729");
			newUser.setEmail("admin@prova.it");
			newUser.setPassword(passwordEncoder.encode("12345678"));
			newUser.setRole("ROLE_ADMIN");
			
			userRepository.save(newUser);
		}
	}
	
	
}
