package com.sist.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
			}else if(category.equals("job")) {
				sql+= " where job ='"+search+"'";
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
