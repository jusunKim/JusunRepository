package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

import lombok.Setter;

@Controller
@Setter
public class DeptController {
	
	@Autowired
	private DeptDAO dao;
	
	@GetMapping("/listDept")
	@ResponseBody //일케 하면 지가 알아서 json으로 만들어줌. gson필요없삼
	public List<DeptVO> listDept(){
		return dao.findAll();
	}
	
	@GetMapping("/insertDept")
	@ResponseBody
	public int insert(DeptVO d) {
		return dao.insert(d);
	}
	
	@GetMapping("/updateDept")
	@ResponseBody
	public int update(DeptVO d) {
		return dao.update(d);
	}
	@GetMapping("/deleteDept")
	@ResponseBody
	public int delete(int dno) {
		return dao.delete(dno);
	}
}
