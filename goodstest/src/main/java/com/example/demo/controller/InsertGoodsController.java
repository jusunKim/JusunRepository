package com.example.demo.controller;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/insertGoods") 
public class InsertGoodsController {
	
	@Autowired
	GoodsDAO dao = new GoodsDAO();
	
	@RequestMapping(method=RequestMethod.GET)
	public void form(Model model) {
		model.addAttribute("nno",dao.getNextNo());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(GoodsVO g, HttpServletRequest request) { //커맨드객체 g, 실경로 알아와야해서(jakarta의..)
		ModelAndView mav = new ModelAndView("redirect:/listGoods");
		String path = request.getServletContext().getRealPath("images"); //실경로 알아오기
		System.out.println("경로 "+path);
		String fname = null;
		
		MultipartFile uploadFile = g.getUploadFile();//업로드한 파일에 대한 정보 갖고 있는 거.파일없어도 null이 아님.
		fname = uploadFile.getOriginalFilename(); //업로드한 파일 이름을 가져오는 게 getOriginalFileName
		if(fname!=null && !fname.equals("")) { //업로드한 파일이 있는가
			try {
				byte[] data = uploadFile.getBytes(); //업로드한 파일의 내용 가져오는 메소드
				FileOutputStream fos = new FileOutputStream(path+"/"+fname); //저 경로에 ㅈ 이름으로 파일 출력하기 위한 스트림 생성
				fos.write(data); //출력을 해라
				fos.close(); //스트림 닫기
				g.setFname(fname);//업로드할 파일의 이름을 VO에 설정 -> 다오가 받아서 디비에 반영하게 하려고
			} catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
		int re = dao.insert(g);
		return mav;
	}
}
