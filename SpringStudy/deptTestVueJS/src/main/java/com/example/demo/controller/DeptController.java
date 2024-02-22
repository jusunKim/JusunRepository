package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;

import jakarta.servlet.http.HttpServletRequest;


@RestController //데이터로 응답할거니까
public class DeptController {
	@Autowired
	private DeptService ds;
	
	@GetMapping("/listDept")
	public List<Dept> listDept(){
		return ds.listDept();
	}
	
	@PostMapping("/insertDept")
	public String insertDept(Dept d, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("images");
		MultipartFile uploadFile = d.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		d.setFname(fname);
		ds.insertDept(d);
		if(fname!=null &&fname!="") {
			try {
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
			} catch (Exception e) {
				System.out.println("파일 업로드 예외"+e.getMessage());
			}
		}
		return "OK";
	}

}
