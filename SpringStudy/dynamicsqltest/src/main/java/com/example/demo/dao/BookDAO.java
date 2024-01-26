package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BookVO;

@Repository
public class BookDAO {
	
	public List<BookVO> listBook(HashMap<String, Object> map){
		return DBManager.listBook(map);
	}
}
