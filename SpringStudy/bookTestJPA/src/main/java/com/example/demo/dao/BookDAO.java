package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.BookVO;

@Repository
public interface BookDAO extends JpaRepository<BookVO, Integer> {

	//검색 없이 정렬만 하는 메소드들
	public List<BookVO> findAllByOrderByBookname();
	public List<BookVO> findAllByOrderByBookid();
	public List<BookVO> findAllByOrderByPublisher();
	public List<BookVO> findAllByOrderByPrice();
	
	public List<BookVO> findByBooknameContaining(String bookname);
	public List<BookVO> findByPublisherContaining(String publisher);
	public List<BookVO> findByBookid(Integer bookid);
	public List<BookVO> findByPrice(Integer price);

	public List<BookVO> findByBooknameContainingOrderByBookname(String bookname);
	public List<BookVO> findByBooknameContainingOrderByBookid(String bookname);
	public List<BookVO> findByBooknameContainingOrderByPublisher(String bookname);
	public List<BookVO> findByBooknameContainingOrderByPrice(String bookname);
	
	public List<BookVO> findByPublisherContainingOrderByBookname(String publisher);
	public List<BookVO> findByPublisherContainingOrderByBookid(String publisher);
	public List<BookVO> findByPublisherContainingOrderByPublisher(String publisher);
	public List<BookVO> findByPublisherContainingOrderByPrice(String publisher);
	
	public List<BookVO> findByBookidOrderByBookname(Integer bookid);
	public List<BookVO> findByBookidOrderByBookid(Integer bookid);
	public List<BookVO> findByBookidOrderByPublisher(Integer bookid);
	public List<BookVO> findByBookidOrderByPrice(Integer bookid);
	
	public List<BookVO> findByPriceOrderByBookname(Integer price);
	public List<BookVO> findByPriceOrderByBookid(Integer price);
	public List<BookVO> findByPriceOrderByPublisher(Integer price);
	public List<BookVO> findByPriceOrderByPrice(Integer price);
}
