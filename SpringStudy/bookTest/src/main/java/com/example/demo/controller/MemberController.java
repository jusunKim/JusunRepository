package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public void loginForm() {
		
	}
	
	@GetMapping("/join")
	public void joinForm() {
		
	}
	
	@PostMapping("/join")
	public String joinSubmit(MemberVO m) {
		String view = "redirect:/";
		m.setPwd(passwordEncoder.encode(m.getPwd())); //암호화해서 암호를 설정하기
		m.setRole("user");
		dao.insert(m);
		return view;
	}
}
