package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

@Controller
public class DeptController {

	@Autowired
	DeptDAO dao = new DeptDAO();
	
	@GetMapping("/listDept")
	public void list(Model model) {
		model.addAttribute("list",dao.findAll());
	}
	
	@GetMapping("/insertDept")
	public void insertForm() {
		
	}
	
	@PostMapping("/insertDept")
	public String insertSubmit(DeptVO d, Model model) { //이 메소드 이름은 사실 중요하진 않은듯? 실행만 할 거니까
		String view = "redirect:/listDept";
		int re = dao.insert(d);
		if(re!=1) {
			view = "error";
			model.addAttribute("msg","인서트 실패");
		}
		return view;
	}
	
	@GetMapping("/updateDept")
	public void updateForm(int dno, Model model) {
		model.addAttribute("d", dao.findByDno(dno)) ;
	}
	
	@PostMapping("/updateDept")
	public String updateSubmit(DeptVO d, Model model) {
		String view = "redirect:/listDept";
		int re = dao.update(d);
		if(re!=1) {
			view="error";
			model.addAttribute("msg", "부서 수정 실패");
		}
		return view;
	}
}
