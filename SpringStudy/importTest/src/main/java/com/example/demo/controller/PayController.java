package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.service.PayService;

@RestController
public class PayController {

	
	@Autowired
	private PayService ps;
	
	@PostMapping("/payok")
	public String payOK(Payment p) {
		System.out.println("결제번호:"+p.getImp_uid());
		System.out.println("주문번호:"+p.getMerchant_uid());
		System.out.println("결제금액:"+p.getPaid_amount());
		System.out.println("승인번호:"+p.getApply_num());
		ps.insert(p);
		return "OK";
	}
}