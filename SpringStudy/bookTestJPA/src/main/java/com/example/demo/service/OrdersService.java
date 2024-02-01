package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.OrdersDAO;
import com.example.demo.vo.CustomerVO;
import com.example.demo.vo.OrdersVO;

@Service
public class OrdersService {

	@Autowired
	private OrdersDAO dao;
	
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public void insert(OrdersVO o) {
		dao.insert(o);
	}
	
	public List<OrdersVO> findAll(String search) {
		if(search!=null && !search.equals("")) {
			return dao.findByCustomer_Name(search);
		}
		return dao.findAll();
	}
}

