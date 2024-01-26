package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BoardVO;

@Repository
public class BoardDAO {

	public List<BoardVO> listBoard(HashMap<String, Integer> map){
		System.out.println("listBoard동작함!");
		return DBManager.listBoard(map);
	}
	
	public BoardVO detailBoard(int no) {
		return DBManager.detailBoard(no);
	}
	
	public int getNextNo() {
		return DBManager.getNextNo();
	}

	public int insertBoard(BoardVO b) {
		return DBManager.insertBoard(b);
	}
	
	public int updateStep(int b_ref, int b_step) {
		return DBManager.updateStep(b_ref, b_step);
	}
	
	public int countTotalRecord() {
		System.out.println("countTotalRecord동작함!");
		return DBManager.countTotalRecord();
	}
}
