package com.sist.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.db.ConnectionProvider;
import com.sist.vo.EmpVO;

public class EmpDAO {
	
	public static EmpDAO dao = null;
	
	private EmpDAO() {
	}
	
	public static EmpDAO getInstance() {
		if(dao==null) {
			dao = new EmpDAO();
		}
		return dao;
	}
	
	
	
	public ArrayList<String> findAllManager(){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select distinct m.ename from emp e, emp m"
				+ " where e.mgr = m.eno order by m.ename";
		try {
			Connection conn =ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		return list;
	}
	
	public ArrayList<String> findAllDname(){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select distinct dname from dept order by dname";
		try {
			Connection conn =ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> findAllEmp(String category, String search) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "select e.eno, e.ename, d.dno, d.dname,  e.salary, nvl(e.comm,0) , e.salary+nvl(e.comm,0) , e.hiredate,"
				+ " floor(months_between(sysdate, e.hiredate)),m.ename, rpad(substr(e.jumin,1,8),14,'*') , e.email, e.job"
				+ " from emp e, emp m, dept d"
				+ " where e.mgr=m.eno"
				+ " and e.dno = d.dno";
				if(search!=null && !search.equals("")) {
					sql+= " and "+category+" ='"+search+"'";
				}
				sql += " order by e.eno";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("eno", rs.getInt(1));
				map.put("ename", rs.getString(2));
				map.put("dno", rs.getInt(3));
				map.put("dname", rs.getString(4));
				map.put("salary", rs.getInt(5));
				map.put("comm", rs.getInt(6));
				map.put("income", rs.getInt(7));
				map.put("hiredate", rs.getDate(8));
				map.put("workmonth", rs.getInt(9));
				map.put("mname", rs.getString(10));
				map.put("jumin", rs.getString(11));
				map.put("email", rs.getString(12));
				map.put("job", rs.getString(13));
				list.add(map);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		return list;
	}
	
	public ArrayList<Integer> listDno(){
		ArrayList<Integer> dlist = new ArrayList<Integer>();
		String sql = "select distinct dno from emp order by dno";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dlist.add(rs.getInt(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return dlist;
	}
	
	public ArrayList<String> listJob(){
		ArrayList<String> jlist = new ArrayList<String>();
		String sql = "select distinct job from emp";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jlist.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return jlist;
	}
	
	public ArrayList<EmpVO> listEmp(String category, String search){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		String sql = "select eno, ename, job, hiredate, salary, dno,"
				+ "mgr, comm, rpad(substr(jumin, 1, 8), 14, '*'), email from emp";
		if(search!=null && !search.equals("")) {
			if(category.equals("jumin")) {
				sql+= " where jumin like '"+search+"%'";
			}else if(category.equals("email")) {
				sql+= " where substr(email,1,instr(email,'@')-1) = '"+search+"'";
			}else{
				sql+= " where "+category+" ='"+search+"'";
			}
		}
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new EmpVO(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getString(9), rs.getString(10)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생-"+e.getMessage());
		}
		return list;
	}
}
