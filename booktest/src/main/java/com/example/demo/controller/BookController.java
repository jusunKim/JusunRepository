package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookDAO;

@Controller //컨트롤러예요~
public class BookController {
	
	@Autowired //의존관계 자동으로 설정
	private BookDAO dao;

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("/listBook") //listBook 갯방식으로 요청하면 이 메소드를 실행할 거야. Model로 상태 유지
	public void list(Model model) {
		model.addAttribute("list",dao.findAll());
	}
}
