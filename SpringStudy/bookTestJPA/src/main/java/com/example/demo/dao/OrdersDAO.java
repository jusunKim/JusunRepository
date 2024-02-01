package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.OrdersVO;

import jakarta.transaction.Transactional;

@Repository
public interface OrdersDAO extends JpaRepository<OrdersVO, Integer> {
	
	//새 메소드 필요하니까 만들수있삼,
	@Query(value="select nvl(max(orderid),0)+1 from orders", nativeQuery = true)
	public int getNextNo();
	
	//오늘날짜를 넣어줘야돼가지구 직접 만드는중..
	@Modifying
	@Transactional 
	@Query(value = "insert into orders(orderid,custid,bookid,saleprice,orderdate) values(:#{#o.orderid},:#{#o.customer.custid},:#{#o.book.bookid},:#{#o.saleprice},sysdate)", nativeQuery = true)
	public void insert(@Param("o") OrdersVO o);
	
	public List<OrdersVO> findByCustomer_Name(String name);
	
}

