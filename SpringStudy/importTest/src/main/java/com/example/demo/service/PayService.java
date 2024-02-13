package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PayDAO;
import com.example.demo.entity.Payment;

@Service
public class PayService {

	@Autowired
	private PayDAO dao;
	
	public void insert(Payment p) {
		dao.save(p);
	}
	
}
