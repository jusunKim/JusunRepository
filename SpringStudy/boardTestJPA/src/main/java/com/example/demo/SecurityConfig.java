package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.Setter;

@Configuration
@EnableWebSecurity
@Setter
public class SecurityConfig {
   
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		System.out.println("filterChain동작함");
		System.out.println("passwordEncoder:"+passwordEncoder);
		http.authorizeHttpRequests()
		.requestMatchers("/", "/member/login").permitAll()
		.requestMatchers("/admin/**").hasRole("admin")
		.anyRequest().authenticated();
		
		http.formLogin().loginPage("/member/login").permitAll()
		.defaultSuccessUrl("/board/list/1/null");		
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/member/login");		
		
		http.httpBasic();	
		
		return http.build();
	}
   
}