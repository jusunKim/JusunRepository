package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

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
	public void listBook(Model model) {
		model.addAttribute("list",bs.findAll());
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
