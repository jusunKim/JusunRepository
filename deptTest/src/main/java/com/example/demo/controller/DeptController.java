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
	
	@Autowired //알아서 의존관계를 자동으로 설정해줘
	private DeptDAO dao;
	
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}


	@GetMapping("/listDept")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@GetMapping("/insertDept")
	public void insertForm() {
		System.out.println("insertDept get방식 동작함");
	}
	
	@PostMapping("/insertDept")
	public String insertSubmit(DeptVO d, Model model) {
		String view="redirect:/listDept"; //다시 주소표시줄에 이걸 요청해라 라는 거. 그래야 컨트롤러 거쳐서 상태유지가 된 채로 감
		int re = dao.insertDept(d);
		if(re!=1) {
			model.addAttribute("msg","부서등록에 실패했습니다");
			view="error"; //views폴더에서 error.jsp를 찾음
		}
		return view;
	}
	
	@GetMapping("/updateDept")
	public void updateForm(int dno, Model model) {
		model.addAttribute("d",dao.findByDno(dno)); //다오 객체 이미 있으니까 걍 쓰면 됨
	}
	
	@PostMapping("/updateDept")
	public String updateSubmit(DeptVO d, Model model) {
		String view="redirect:/listDept";
		int re = dao.updateDept(d);
		if(re!=1) {
			model.addAttribute("msg","부서 수정 실패");
			view="error";
		}
		return view;
	}
	
	@GetMapping("/deleteDept")
	public String deleteSubmit(int dno, Model model) {
		String view = "redirect:/listDept";
		int re = dao.deleteDept(dno);
		if(re!=1) {
			model.addAttribute("msg", "부서 삭제 실패");
			view="error";
		}
		return view;
	}
}