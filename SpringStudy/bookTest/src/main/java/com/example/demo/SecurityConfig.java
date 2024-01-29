package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		
		http.authorizeHttpRequests()
		.mvcMatchers("/","/join", "/all/**", "/error").permitAll()//모두에게오픈
		.mvcMatchers("/admin/**").hasRole("admin")//관리자롤이있어야돼
		.anyRequest().authenticated();//인증만 거치면 돼(로그인만 하면돼)
		
		//로그인폼 내가만들거 설정
		http.formLogin().loginPage("/login").permitAll()//서비스 이름은 login으로 할거고 모두에게오픈
		.defaultSuccessUrl("/listBook");//로그인 성공했을 때 어디로 보낼까?listBook
		
		//로그아웃 설정은 이것만 하면 땡임.
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true)//세션 파기할까
		.logoutSuccessUrl("/login"); //로그아웃하면어디로보낼까
		
		http.httpBasic();
	}
}
