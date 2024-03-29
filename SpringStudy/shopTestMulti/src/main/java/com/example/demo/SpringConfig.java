package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringConfig {

	   @Bean
	   public PasswordEncoder passwordEncoder() {
		   System.out.println("passwordEncoder 동작함.");
	      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	   }
}
