package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;

import jakarta.servlet.http.HttpServletRequest;


@RestController //데이터로 응답할거니까
public class GoodsController {
	@Autowired
	private GoodsService gs;
	
	@GetMapping("/listGoods")
	public List<Goods> listGoods(){
		return gs.listGoods();
	}
	
	@PostMapping("/insert")
	public String insertGoods(Goods g, MultipartFile uploadFile, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("images");
		String fname = "";
		System.out.println(g);
		try {
			if(uploadFile!=null) {
				fname = uploadFile.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
			} 
		}catch (Exception e) {
			System.out.println("파일예외발생:"+e.getMessage());
		}
		g.setFname(fname);
		gs.insertGoods(g);
		return "OK";
	}
	
	//매우고생함
	@PostMapping("/update")
	public String updateGoods(Goods g, MultipartFile uploadFile, HttpServletRequest request) {
		String oldFname = g.getFname();
		String path = request.getServletContext().getRealPath("images");
		String fname = null;
		System.out.println("oldFname:"+oldFname);
		
		try {
			if(uploadFile!=null) {//업로드할 파일 있으면
				fname=uploadFile.getOriginalFilename(); //fname에다 업로드할파일이름넣기
				//파일복사해서 올리기
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
			}
			if(oldFname!=null) { //전에 파일 있었으면
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}catch (Exception e) {
			System.out.println("파일수정처리중예외"+e.getMessage());
		} 
		g.setFname(fname); //fname설정(uploadFile이 있으면 파일명, 없으면 null)
		gs.updateGoods(g); //데이터베이스 업데이트
		return "OK";
	}
	
	
	@PostMapping("/delete")
	public String deleteGoods(int no, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("images");
		Goods good = gs.findByNo(no);
		String oldFname = good.getFname();
		gs.deleteGoods(no);
		if(oldFname!=null&&!oldFname.equals("")) {
			File file = new File(path+"/"+oldFname);
			file.delete();
		}
		return "OK";
	}
}
