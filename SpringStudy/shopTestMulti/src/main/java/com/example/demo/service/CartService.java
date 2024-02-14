package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartDAO;
import com.example.demo.dao.PayDAO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Payment;

@Service
public class CartService {

	@Autowired
	private CartDAO dao;
	
	public void insert(Cart c) {
		
//	    c.setNo(dao.getNextNo());
	    c.setQty(1);

	    String id = c.getId();
	    int gno = c.getGno();
	    Cart old = dao.findByIdAndGno(id, gno);
	    if(old!=null){
	        c.setQty(old.getQty()+1);
	        c.setNo(old.getNo());
	    }
		  
		dao.save(c);
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public void addQty(String id, int gno) {
		dao.addQty(id, gno);
	}
	
	public Cart findByIdAndGno(String id, int gno)  {
		return dao.findByIdAndGno(id, gno);
	}
	
	public List<Cart> findById(String id){
		return dao.findById(id);
	}
}
