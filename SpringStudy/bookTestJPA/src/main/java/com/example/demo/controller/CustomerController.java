package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.CustomerService;
import com.example.demo.vo.CustomerVO;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	@GetMapping("/customer/delete")
	public String delete(int custid) {
		String view = "redirect:/customer/list";
		cs.delete(custid);
		return view;
	}
	
	@GetMapping("/customer/update")
	public void update(int custid, Model model) {
		model.addAttribute("c",cs.getCustomer(custid));
	}
	
	@PostMapping("/customer/save")
	public String save(CustomerVO c) {
		String view = "redirect:/customer/list";
		cs.save(c);
		return view;
	}
	
	@GetMapping("/customer/list")
	public void listCust(Model model) {
		model.addAttribute("list",cs.listCust());
	}
	
	@GetMapping("/customer/insert")
	public void insert(Model model) {
		model.addAttribute("custid",cs.getNextNo());		
	}
}
