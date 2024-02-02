package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	@GetMapping("/board/insert")
	public void insertForm(Model model, String pno) {
		int pp = 0;
		if(pno!=null) {
			pp = Integer.parseInt(pno);
		}
		model.addAttribute("no",pp);
	}
	
	@PostMapping("/board/insert")
	public String insert(Board b, HttpServletRequest request) {
		String view = "redirect:/board/list";
		int pno = b.getNo();
		int no = bs.getNextNo();
	
		String path = request.getServletContext().getRealPath("images");
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		
		if(fname!=null && !fname.equals("")) {
			try {
				byte[] data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				b.setFname(fname);
				System.out.println(path);
			} catch (IOException e) {
				System.out.println("파일등록예외발생:"+e.getMessage());
			}
		}
		
		//새글일 때
		int b_level = 0;
		int b_step =0;
		int b_ref = no;
		
		//답글일 때
		if(pno!=0) {
			Board pb = bs.findByNo(pno);
			b_ref=pb.getB_ref();
			b_level = pb.getB_level();
			b_step = pb.getB_step();
			int re = bs.updateStep(b_ref, b_step);
			b_level++;
			b_step++;
		}
		
		b.setB_level(b_level);
		b.setB_ref(b_ref);
		b.setB_step(b_step);
		b.setNo(no);
		bs.insert(b);
		
		
		
		return view;
	}
	
	@GetMapping("/board/list")
	public void list(Model model) {
		model.addAttribute("list",bs.findAll());
	}
	
	@GetMapping("/board/detail/{no}")
	public String detail(Model model, @PathVariable int no) {
		String view = "board/detail";
		model.addAttribute("b",bs.findByNo(no));
		return view;
	}
	
}
