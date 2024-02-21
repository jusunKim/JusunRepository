package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController //데이터로 응답할거니까
public class BookController {
	@Autowired
	private BookService bs;
	
	@GetMapping("/listBook")
	public List<Book> listBook(){
		return bs.listBook();
	}
	
	//Book b가져올 때 자꾸 오류 나서 이게 실행이 안 됏삼. 왜그러냐면 넘어오는 데서 bookid=""여가지고..
	//그래서 초기값을 1로 설정해서 데려옴
	@PostMapping("insertBook")
	public void insertBook(Book b) {
		b.setBookid(bs.getNextNo());
		bs.save(b);
	}
	
	@PostMapping("/updateBook")
	public void updateBook(Book b) {
		bs.save(b);
	}
	
	@PostMapping("/deleteBook")
	public void deleteBook(int bookid) {
		bs.deleteBook(bookid);
	}
}
