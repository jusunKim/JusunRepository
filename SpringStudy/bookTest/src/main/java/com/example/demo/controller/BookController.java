package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	//로그인에 성공하면 listBook으로 오기로 설정을 해놧삼.(SecurityConfig에서)
	@GetMapping("/listBook") 
	public void list(HttpSession session) {
		
		//인증된(로그인된)회원의 정보 갖고 오기 위해 먼저 시큐리티의 인증 객체가 필요함.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//이 인증객체를 통해 인증된(로그인한) User객체 받아오기
		User user = (User)authentication.getPrincipal();
		
		//인증된 User 통해서 로그인한 회원의 아이디를 갖고 온다
		String id = user.getUsername();
		
		//세션에 이 유저에 대한 정보를 상태유지하자.(만약 id만 상태유지하고싶으면그렇게해두되구.. 이것저것하고싶으면 dao.findByID로 하믄댐)
		session.setAttribute("id", id);
	}
}
