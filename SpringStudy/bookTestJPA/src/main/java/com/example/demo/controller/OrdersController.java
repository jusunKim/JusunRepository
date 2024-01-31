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

@Controller
public class OrdersController {

	@Autowired
	private BookService bs;
	
	@Autowired
	private CustomerService cs;

	@Autowired
	private OrdersService os;
	
	@GetMapping("/orders/insert")
	public void insertForm(Model model) {
		model.addAttribute("bList",bs.findAll());
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
	public void list(Model model) {
		model.addAttribute("list",os.findAll());
	}
}
