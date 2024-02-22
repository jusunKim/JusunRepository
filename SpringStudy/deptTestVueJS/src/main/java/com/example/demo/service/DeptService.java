package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeptDAO;
import com.example.demo.entity.Dept;

@Service
public class DeptService {
	
	@Autowired
	private DeptDAO dao;
	
	public List<Dept> listDept() {
		return dao.findAll();
	}
	
	public void insertDept(Dept d) {
		dao.save(d);
	}
}
