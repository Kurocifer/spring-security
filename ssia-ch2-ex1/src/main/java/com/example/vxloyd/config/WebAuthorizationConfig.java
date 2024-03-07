
package com.example.vxloyd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.vxloyd.security.CustomAuthenticationProvider;

@Configuration
public class WebAuthorizationConfig {
	
	private final CustomAuthenticationProvider authenticationProvider;
	
	
	public WebAuthorizationConfig(CustomAuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	@Bean
	SecurityFilterChain configure(HttpSecurity http) 
		throws Exception {
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authenticationProvider(authenticationProvider);
		
		http.authorizeHttpRequests(
				c -> c.anyRequest().authenticated()
				);
		
		return http.build();
	}

}
