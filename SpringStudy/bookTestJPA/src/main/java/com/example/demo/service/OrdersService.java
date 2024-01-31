package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersDAO;
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
	
	public List<OrdersVO> findAll() {
		return dao.findAll();
	}
}
