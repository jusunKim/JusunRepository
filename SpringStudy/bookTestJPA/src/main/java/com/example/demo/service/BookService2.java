package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

//@Service
public class BookService2 {
	
	@Autowired
	private BookDAO dao ;
	
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}
	
	public BookVO findById(int bookid) {
		BookVO b = null;
		//JPA의 findById는 VO를 반환하지 않고 VO를 Optional로 포장해서 반환한다.
		Optional<BookVO> o = dao.findById(bookid);
		if(o.isPresent()) {
			b = o.get();
		}
		return b;
	}
	
	
	
	public List<BookVO> findAll(HashMap<String, String> map){
//		return dao.findAll();
		String category = map.get("category");
		String search = map.get("search");
		List<BookVO> list = null;
		if(search!=null && !search.equals("")) {
			switch(category){
				case "bookname" : list= dao.findByBooknameContaining(search); break;
				case "bookid" : list= dao.findByBookid(Integer.parseInt(search)); break;
				case "publisher" : list= dao.findByPublisherContaining(search); break;
				case "price" : list= dao.findByPrice(Integer.parseInt(search)); break;
			}
		}else {
			list= dao.findAllByOrderByBookname();		
		}
		return list;
	}
	
	//insert나 update를 위한 메소드.PK에 해당하는 레코드가 있으면 update, 아니면 insert실행하는 save()
	public void save(BookVO b) {
		dao.save(b);
	}
}
