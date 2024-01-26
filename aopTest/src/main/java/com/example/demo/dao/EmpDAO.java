package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.EmpVO;

@Repository
public class EmpDAO {
	
	public EmpVO findByEno(int eno) {
		return DBManager.findByEno(eno);
	}
	
	public List<Integer> listEno(){
		return DBManager.listEno();
	}
}
