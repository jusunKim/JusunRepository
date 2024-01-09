package com.sist.vo;

import java.util.Date;

public class EmpVO {
	private int eno;
	private String ename;
	private String job;
	private Date hiredate;
	private int salary;
	private int dno;
	private int mgr;
	private int comm;
	private String jumin;
	private String email;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmpVO(int eno, String ename, String job, Date hiredate, int salary, int dno, int mgr, int comm, String jumin,
			String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.salary = salary;
		this.dno = dno;
		this.mgr = mgr;
		this.comm = comm;
		this.jumin = jumin;
		this.email = email;
	}
	public EmpVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
