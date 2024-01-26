package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.DeptVO;

public class DeptDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##madang";
	String password = "madang";
	
	public DeptVO findByDno(int dno) {
		DeptVO d = null;
		String sql = "select * from dept where dno=?";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				d = new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return d;
	}
	
	
	public ArrayList<DeptVO> listDept(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept order by dno";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외 발생"+e.getMessage());
		}
		
		return list;
	}
}
