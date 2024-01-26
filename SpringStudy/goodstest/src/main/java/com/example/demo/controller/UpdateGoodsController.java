package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/updateGoods")
public class UpdateGoodsController {

	@Autowired
	GoodsDAO dao = new GoodsDAO();

	@GetMapping
	public void form(int no, Model model) {
		model.addAttribute("g",dao.findByNo(no));
	}
	@PostMapping
	public ModelAndView submit(GoodsVO g, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods"); //String해도 됨
		String path = request.getServletContext().getRealPath("images");
		System.out.println(path);
		String oldfname = g.getFname();
		String fname = null;
		
		MultipartFile uploadFile = g.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname!=null && !fname.equals("")) { //새로 넣을 파일 있음
			try {
				byte[] data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				g.setFname(fname);
			} catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
		int re = dao.update(g);
		if(re==1 &&  fname!=null &&!fname.equals("")) { //이거 냅다 re==1로 하면 안됨!!!
			File file = new File(path+"/"+oldfname);
			file.delete();
		}
		return mav;
	}
}
