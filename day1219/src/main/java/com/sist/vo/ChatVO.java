package com.sist.vo;

public class ChatVO {
	private int no;
	private String name;
	private String msg;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ChatVO(int no, String name, String msg) {
		super();
		this.no = no;
		this.name = name;
		this.msg = msg;
	}
	public ChatVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatVO(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
	}
	
	
	
}
