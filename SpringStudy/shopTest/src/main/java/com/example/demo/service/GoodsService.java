package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.entity.Goods;

@Service
public class GoodsService {

	@Autowired
	private GoodsDAO dao;
	
	public Goods insertGoods(Goods g) {
		return dao.save(g);
	}
	
	public List<Goods> listGoods(){
		return dao.findAll();
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public Goods getGoods(int no) {
		return dao.findById(no).get();
	}
}
