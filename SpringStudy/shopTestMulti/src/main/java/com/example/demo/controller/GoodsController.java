package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Member;
import com.example.demo.service.CartService;
import com.example.demo.service.GoodsService;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class GoodsController {
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private GoodsService gs;
	
	@Autowired
	private CartService cs;
	
	@GetMapping("/goods/list")
	public void list(Model model, HttpSession session) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
		User user = (User)authentication.getPrincipal();
		String s_id = user.getUsername();
		Member m = ms.findById(s_id);
		session.setAttribute("loginUSER", m);
		model.addAttribute("list",gs.listGoods());
		
	}
	
	@GetMapping("/goods/insert")
	public void insertForm() {
	}
	
	@PostMapping("/goods/insert")
	public String insertSubmit(Goods g, HttpServletRequest request) {
		MultipartFile uploadFile = g.getUploadFile();
		String fname = null;
		fname = uploadFile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("images");
		System.out.println(path);
		g.setNo(gs.getNextNo());
		g.setFname(fname);
		Goods re = gs.insertGoods(g);
		if(re!=null &&fname!=null &&!fname.equals("")) {
			try {
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
			} catch (Exception e) {
				System.out.println("insert중 파일예외"+e.getMessage());
			}
		}
		return "redirect:/goods/list";
	}
	
	@GetMapping("/goods/detail/{no}")
	public String detail(@PathVariable int no, Model model) {
		model.addAttribute("g", gs.getGoods(no));
		return "/goods/detail";
	}
	
	@GetMapping("/orders/checkout")
	public void orderForm(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("loginUSER");
		String id = m.getId();
		List<Cart> list = cs.findById(id);
		int total = 0;
		String name = "";
		for(Cart c :list) {
			int qty = c.getQty();
			int goodsno  = c.getNo();
			Goods g = gs.getGoods(goodsno);
			int price = g.getPrice();
			total = total + qty*price;
			if(name.equals("")) {
				name = g.getItem()+" 외"+(list.size()-1)+"건";
			}
		}
		model.addAttribute("list",list);
		model.addAttribute("total",total);
		model.addAttribute("name",name);
		if(list!=null) {
			System.out.println("컨트ㅗㄹ럴ㄹ"+id);
		}
	}
}
