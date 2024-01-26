package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.SistLogVO;

@Repository
public class SistLogDAO {

	public int insert(SistLogVO a) {
		return DBManager.insertLog(a);
	}
}
