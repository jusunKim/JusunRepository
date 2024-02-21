package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Book;

@Service
public class BookService {
	@Autowired
	private BookDAO dao;
	
	public List<Book> listBook(){
		return dao.findAll();
	}
	
	public void save(Book b) {
		dao.save(b);
	}
	
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public void deleteBook(int bookid) {
		dao.deleteById(bookid);
	}
}
