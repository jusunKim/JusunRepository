package com.example.demo.controller;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/insertBoard")
public class InsertBoardController {

	@Autowired
	BoardDAO dao = new BoardDAO();
	
	@GetMapping
	 public void insertBoard(String no, Model model) { //--> 매개변수로 받은 no는 request.getparameter와 동일한 역할이라서 int로 받지 못하기 때문에 String으로 일단 받는다.
	      int bno=0; //부모글번호
	      if(no != null && !no.equals("")) {
	         bno = Integer.parseInt(no);
	      }
	      model.addAttribute("no",bno); //부모글번호를 걍 no로 전달해버리네..
	   }
	
	@PostMapping
	public String submit(BoardVO b, HttpServletRequest request) {
		String view = "redirect:/listBoard";
		String path = request.getServletContext().getRealPath("upload");
		System.out.println(path);
		String fname = null;
		
		//진짜 글번호로 들어가는 건 이거고.
		int no = dao.getNextNo();
		
		//일단 새글이라고 보고 짜
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;
		
		int pno = b.getNo(); //글고 그걸 걍 VO에 있던 no로 가져오는구나...
		if(pno!=0) {
			BoardVO pb = dao.detailBoard(pno);
			b_ref = pb.getB_ref();
			b_level = pb.getB_level();
			b_step = pb.getB_step();
			dao.updateStep(b_ref, b_step);
			b_level++;
			b_step++;
		}
		
		b.setNo(no);
		b.setIp(request.getRemoteAddr());
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		
		MultipartFile uploadFile = b.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		b.setFname(fname);

		int re = dao.insertBoard(b);
		
		//db에 insert성공했고 파일도 새로 추가했으면 파일복사를 한다
		if(re==1 && fname!=null && !fname.equals("")) {
			try {
				byte[] data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				System.out.println("파일처리 예외발생:"+e.getMessage());
			}
		}
		return view;
	}
}
