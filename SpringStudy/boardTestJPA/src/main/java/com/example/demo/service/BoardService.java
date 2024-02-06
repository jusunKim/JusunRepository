package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.entity.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public void insert(Board b) {
		dao.insert(b);
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public List<Board> findAll(int start, int end){
//		return dao.findAll();
		return dao.selectAll(start, end);
	}
	
	public Board findByNo(int no) {
		return dao.getById(no);
	}
	
	public int updateStep(int b_ref, int b_step) {
		return dao.updateStep(b_ref, b_step);
	}
	
	public int getTotalRecord() {
		return (int)dao.count();
	}
}
