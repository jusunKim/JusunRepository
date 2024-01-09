package com.sist.vo;

import java.util.Date;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String pwd;
	private String content;
	private Date regdate;
	private int hit;
	private String fname;
	private String ip;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public BoardVO(int no, String title, String writer, String pwd, String content, Date regdate, int hit, String fname,
			String ip) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.pwd = pwd;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.fname = fname;
		this.ip = ip;
	}
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
