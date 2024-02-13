package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.requestMatchers("/", "/member/login", "/member/join").permitAll()
		.requestMatchers("/admin/**", "/goods/insert").hasRole("admin")
		.anyRequest().authenticated();//나머지는 로그인 해야 볼 수 있는 거
		
		http.formLogin().loginPage("/member/login").permitAll()
		.defaultSuccessUrl("/goods/list");
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/member/login");
		
		http.httpBasic();
		
		return http.build();
	}
}
















