package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.DeptVO;

@Repository //이거 써 줘야 자동으로 스캔이 된대
public class DeptDAO {
	
	
	public DeptVO findByDno(int dno) {
		DeptVO d = new DeptVO();
		String sql = "select * from dept where dno="+dno;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
							"c##madang", "madang");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				d.setDno(rs.getInt(1));
				d.setDname(rs.getString(2));
				d.setDloc(rs.getString(3));
			}
			rs.close(); stmt.close(); conn.close();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return d;
	}
	
	
	public int deleteDept(int dno) {
		int re = -1;
		String sql = "delete dept where dno="+dno;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
							"c##madang", "madang");
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			stmt.close(); conn.close();
		} catch (Exception e) {
			System.out.println("sql예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public int updateDept(DeptVO d) {
		int re = -1;
		String sql = "update dept set dname=? , dloc=? where dno=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
							"c##madang", "madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getDname());
			pstmt.setString(2, d.getDloc());
			pstmt.setInt(3, d.getDno());
			re = pstmt.executeUpdate();
			pstmt.close(); conn.close(); 
		} catch (Exception e) {
			System.out.println("예외 발새이"+e.getMessage());
		}
		return re;
	}
	
	public int insertDept(DeptVO d) {
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
							"c##madang", "madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			re = pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			System.out.println("sql예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public ArrayList<DeptVO> findAll(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"c##madang", "madang");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return list;
	}
}
