package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Payment;

import jakarta.transaction.Transactional;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
	
	@Query(value="select nvl(max(no),0)+1 from cart", nativeQuery = true)
	public int getNextNo();
	
	@Modifying
	@Transactional
	@Query(value="update cart set qty=qty+1 where id=?1 and gno=?2", nativeQuery = true)
	public void addQty(String id, int gno);
	
//	@Query(value="select * from cart where id=?1 and gno=?2", nativeQuery = true)
//	public int alreadyCart(String id, int gno);	
	//쿼리메소드로 쓰는 게 낫겠다.
	public Cart findByIdAndGno(String id, int gno);
	
	public List<Cart> findById(String id);
}