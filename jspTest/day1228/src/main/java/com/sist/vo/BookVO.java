package com.sist.vo;

public class BookVO {
	private int bookid;
	private String bookname;
	private int price;
	private String publisher;
	private String fname;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public BookVO(int bookid, String bookname, int price, String publisher, String fname) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.publisher = publisher;
		this.fname = fname;
	}
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookVO(int bookid, String bookname, int price, String publisher) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.publisher = publisher;
	}
	
	
	
	
}
