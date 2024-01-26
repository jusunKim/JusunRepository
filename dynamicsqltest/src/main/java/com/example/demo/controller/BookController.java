package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {

	@Autowired
	private BookDAO dao;
	
	@GetMapping("/listBook")
	public void listBook(HttpServletRequest request, Model model, String sColumn, String category, String search ){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("search")!=null) {
			search = (String)session.getAttribute("search");
			category = (String)session.getAttribute("category");
		}
		if(request.getParameter("search")!=null) {
			search = request.getParameter("search");
			session.setAttribute("search", search);
			session.setAttribute("category", category);
		}
		
		map.put("sColumn", sColumn);
		map.put("category", category);
		map.put("search", search);
		model.addAttribute("list",dao.listBook(map));
	}
	
	
}
