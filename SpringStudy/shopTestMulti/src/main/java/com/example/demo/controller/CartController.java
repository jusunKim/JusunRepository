package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Member;
import com.example.demo.entity.Payment;
import com.example.demo.service.CartService;
import com.example.demo.service.GoodsService;
import com.example.demo.service.PayService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	
	@Autowired
	private CartService cs;
	
//	@Autowired
//	private GoodsService gs;
	
	@GetMapping("/cart/add/{no}")
	public String cartSubmit(@PathVariable int no, HttpSession session) {
		Cart c = new Cart();
		c.setGno(no);
		Member m = (Member)session.getAttribute("loginUSER");
		c.setId(m.getId());
		cs.insert(c);
		return "/cart/add";
	}
	
	@GetMapping("/cart/list")
	public void listCart(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("loginUSER");
		String id = m.getId();
//		gs.getItemByNo(0)
		model.addAttribute("list",cs.findById(id) );
	}
}

