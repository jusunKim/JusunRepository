package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.service.PayService;

@Controller
public class PayController {

	
	@Autowired
	private PayService ps;
	
	@GetMapping("/goods/payment")
	@ResponseBody //ajax통신으로 요청하는 거라 이렇게 해야된다는데?...
	public String payOK(Payment p) {
		p.setNo(ps.getNextNo());
		ps.insert(p);
		return "OK";
	}
}