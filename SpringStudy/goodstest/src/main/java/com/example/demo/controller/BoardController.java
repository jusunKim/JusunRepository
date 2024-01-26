package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BoardDAO;

@Controller
public class BoardController {

	@Autowired
	BoardDAO dao = new BoardDAO();
	
	@GetMapping("/listBoard")
	public void listBoard(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo, Model model) {
		//페이지번호를 받아 근데 그 값이 없으면 1이야
		
		int totalRecord = dao.countTotalRecord();
		int pageSize = 10;
		int totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
		
		int end = pageNo*pageSize;
		int start = end-pageSize+1;
//		if(end>totalRecord) { 엥 이거 없어도 되네...
//			end=totalRecord; 이걸 하면 63까지밖에 없을 때 61~63이 뽑힘. 안쓰면 61~70인거임 어차피똑같은듯..
//		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("list",dao.listBoard(map));
		model.addAttribute("totalPage",totalPage );
	}
	
	@GetMapping("/detailBoard")
	public void detailBoard(int no, Model model) {
		model.addAttribute("b", dao.detailBoard(no));
	}
}
