package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {

	@Autowired
	private BookService bs;
	
	@GetMapping("/book/delete")
	public String deleteById(int bookid) {
		String view = "redirect:/book/listBook";
		bs.delete(bookid);
		return view;
	}
	
	@GetMapping("/book/detail")
		public void detail(int bookid, Model model) {
			model.addAttribute("b", bs.findById(bookid));
		}	
	
	
	@GetMapping("/book/listBook")
	public void listBookSearch(HttpSession session, Model model, String category, String search, String ordering) {
		HashMap<String, String> map = new HashMap<String, String>();
		String category2 = null;
		String search2 = null;
		if(session.getAttribute("search")!=null) {
			search2 = (String)session.getAttribute("search");
			category2 = (String)session.getAttribute("category");
		}
		if(search!=null) {
			search2 = search;
			category2 = category;
			session.setAttribute("search", search2);
			session.setAttribute("category", category2);
		}
		map.put("category", category2);
		map.put("search", search2);
		map.put("ordering", ordering);
		
		model.addAttribute("list",bs.findAll( map));
	}
	
	@PostMapping("/book/save")
	public String save(BookVO b) {
		String view = "redirect:/book/listBook";
		bs.save(b);
		return view;
	}
	
	@GetMapping("/book/update")
	public void updateForm(int bookid, Model model) {
		model.addAttribute("b", bs.findById(bookid));
	}
}
