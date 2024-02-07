package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.service.BoardService;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	@Autowired
	private MemberService ms;
	
//	@GetMapping("/board/insert")
//	public void insertForm(Model model, String pno) {
//		int pp = 0;
//		if(pno!=null) {
//			pp = Integer.parseInt(pno);
//		}
//		model.addAttribute("no",pp);
//	}
	
	@GetMapping("/board/insert")
	public void insertForm(Model model, @RequestParam(value="no", defaultValue="0") int no) {
		
		model.addAttribute("no",no);
	}
	
	@PostMapping("/board/insert")
	public String insert(Board b, HttpServletRequest request) {
		String view = "redirect:/board/list/1/null";
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
	
	//로그인 세션유지!!: 시큐리티 환경설정파일에서 로그인 성공 시 이동할 url인 이곳에서 상태유지해야댐
	@GetMapping("/board/list/{page}/{id}")
	public String list( HttpSession session ,Model model, @PathVariable int page, @PathVariable String id) {
		//1.로그아웃 전까지 상태유지를 위해 session을 매개변수로 추가함
		
		//2.시큐리티에서 로그인한 회원 정보 가져오려면 Authentication객체가 필요. 걜 가져오려면 SecurityContextHolder가필요
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//3.Authentication객체를 통해 로그인한 객체를 가져옴
		User user = (User)authentication.getPrincipal();
		
		//4.User를 통해 로그인한 회원의 아이디 가져옴
		String s_id = user.getUsername();
		
		//5.세션유지하기
		Member m = ms.findById(s_id);
		session.setAttribute("loginUSER", m);
		
		int totalRecord = bs.getTotalRecord();
		if(!id.equals("null")) {
			totalRecord = bs.getTotalRecord(id);
		}
		int pageSize = 5;
		int totalPage = (int)Math.ceil(totalRecord/(double)pageSize) ;
		
		int end = page*pageSize;
		int start = end-pageSize+1;
		model.addAttribute("totalPage",totalPage);
		if(id.equals("null")) {
			model.addAttribute("list",bs.findAll(start, end));
		}else {
			model.addAttribute("list",bs.findMyBoard(start, end, id));
		}
		model.addAttribute("id",id);
		return "/board/list";
	}
	
	@GetMapping("/board/detail/{no}")
	public String detail(Model model, @PathVariable int no) {
		String view = "/board/detail";
		model.addAttribute("b",bs.findByNo(no));
		return view;
	}
	
	@GetMapping("/board/delete/{no}")
	public String deleteForm(Model model, @PathVariable int no) {
		model.addAttribute("no",no);
		return "/board/delete";
	}
	
	@PostMapping("/board/delete")
	public String delete(Board b, HttpServletRequest request) {
		int no = b.getNo();
		System.out.println(no);
		Board ob = bs.findByNo(no);
		String oldFname = ob.getFname();
		String path = request.getServletContext().getRealPath("images");
		if(ob.getPwd().equals(b.getPwd()) ) {
			int re = bs.delete(no);
			if(re==1) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}
		return "redirect:/board/list/1";
	}
	
	@GetMapping("/board/update/{no}")
	public String updateForm(Model model, @PathVariable int no) {
		String view = "/board/update";
		model.addAttribute("b",bs.findByNo(no));
		return view;
	}
	
	@PostMapping("/board/update")
	public String update(Board b, HttpServletRequest request) {
		int no = b.getNo();
		Board ob = bs.findByNo(no);
		if(b.getPwd().equals(ob.getPwd()) ) {
			//파일관련
			String path = request.getServletContext().getRealPath("images");
			MultipartFile uploadFile = b.getUploadFile();
			String fname = uploadFile.getOriginalFilename();
			String oldFname = ob.getFname();//이렇게 안 하고 걍 hidden으로 실어와도되겟네
			if(fname!=null && !fname.equals("") && !fname.equals(oldFname)) {

				try {
					FileOutputStream fos = new FileOutputStream(path+"/"+fname);
					//스트링이 제공해주는 파일복사가 있대. FileCopyUtils
					FileCopyUtils.copy(uploadFile.getBytes(), fos);
					fos.close();
					b.setFname(fname);
					System.out.println(path);
				} catch (IOException e) {
					System.out.println("파일등록예외발생:"+e.getMessage());
				}
		}
		int re = bs.update(b);
		if(re==1 &&oldFname!=null && !oldFname.equals(fname)) {
			File file = new File(path+"/"+oldFname);
			file.delete();				
		}
	}
		return "redirect:/board/detail/"+b.getNo();
	}
	
}
