package it.backend.portfolio.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.lang.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		if ("user".equals(username)) {
			return User.builder()
					.username("user")
					.password("$2a$10$kEhOqGkG3Xa6pVg6r2Zx5uyhZcHbdQ6dQ47g0Qk.dU.7I8xYj87ve")
					.authorities(Collections.emptyList())
					.build();
		}
		throw new UsernameNotFoundException("User not found");
	}
}
