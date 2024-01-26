package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

		@GetMapping("/") //포트번호까지만 써도~
		public String main(HttpServletRequest request) {
			return "index"; //index.jsp로 감
		}
}
