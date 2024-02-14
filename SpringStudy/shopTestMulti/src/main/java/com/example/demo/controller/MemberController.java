package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
   @GetMapping("/member/join")
   public void joinForm() {
   }

   @PostMapping("/member/join")
   @ResponseBody
   public String joinSubmit(Member m) {
	   ms.insert(m);
	   return "OK";
   }

   @GetMapping("/member/login")
   public void loginForm() {
   }

}