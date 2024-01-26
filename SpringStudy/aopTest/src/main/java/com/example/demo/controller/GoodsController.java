package com.example.demo.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GoodsController {
   
	
	@Autowired
	GoodsDAO dao = new GoodsDAO();
	
	@GetMapping("/listGoods")
	public void list(HttpServletRequest request, Model model){
		model.addAttribute("list",dao.findAll());
	}
	
	@GetMapping("/detailGoods")
	public void detail(HttpServletRequest request, int no, Model model) {
		model.addAttribute("g", dao.findByNo(no));
	}
	
	@GetMapping("/deleteGoods")
	public String delete(HttpServletRequest request, int no) {
		String view = "redirect:/listGoods";
		GoodsVO g = dao.findByNo(no);
		String fname = g.getFname();
		String path = request.getServletContext().getRealPath("images");
		int re = dao.delete(no);
		
		if(re==1) {
			File file = new File(path+"/"+fname);
			file.delete();
		}
		
		return view;
	}
}