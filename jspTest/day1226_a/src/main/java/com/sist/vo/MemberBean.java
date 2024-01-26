package com.sist.vo;

public class MemberBean {
	private String id;
	private String pwd;
	private String name;
	private String birthday;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println("setId동작합");
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		System.out.println("setPwd동작합");
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName동작합");
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		System.out.println("setBirthday동작합");
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		System.out.println("setEmail동작합");
	}
	public MemberBean(String id, String pwd, String name, String birthday, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
	}
	public MemberBean() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("기본생성자동작합");
	}
	
	
}
