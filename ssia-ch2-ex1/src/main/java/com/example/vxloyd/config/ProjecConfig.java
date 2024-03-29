
package com.example.vxloyd.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.vxloyd.model.User;
import com.example.vxloyd.service.InMemoryUserDetailsService;

@Configuration
public class ProjecConfig {

	@Bean
	UserDetailsService userDetailsService() {
		UserDetails u = new User("randomGuy", "randomText", "read");
		
		List<UserDetails> users = List.of(u);
		
		return new InMemoryUserDetailsService(users);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
