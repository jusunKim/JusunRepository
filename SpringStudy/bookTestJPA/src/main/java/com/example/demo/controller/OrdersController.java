package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BookService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrdersService;
import com.example.demo.vo.OrdersVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrdersController {

	@Autowired
	private BookService bs;
	
	@Autowired
	private CustomerService cs;

	@Autowired
	private OrdersService os;
	
	@GetMapping("/orders/insert")
	public void insertForm(HttpSession session,Model model) {
//		model.addAttribute("bList",bs.findAll());
		model.addAttribute("bList",bs.findAll(null));//findAll을 바꿔가지구..
		model.addAttribute("cList",cs.listCust());
		model.addAttribute("orderid",os.getNextNo());
	}
	
	@PostMapping("/orders/save")
	public String insert(OrdersVO o) {
		String view = "redirect:/orders/insert";
		os.insert(o);
		return view;
	}
	
	@GetMapping("/orders/list")
	public void list(Model model, String search) {
		model.addAttribute("list",os.findAll(search));
	}
}
