package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##madang";
	String password = "madang";
	
	int pageSIZE = 3;//한 화면에 보여줄 레코드 수
	int totalRecord; //전체 레코드 수 19
	int totalPage; 	//전체 페이지 수 4
	
	//전체 페이지수 반환하는 메소드
	public int getTotalPage() {
		int totalPage =0;
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/ (double)pageSIZE);
		
		return totalPage;
	}
	
	
	//전체 레코드수 반환하는 메소드
	public int getTotalRecord() {
		int cnt=0;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from goods";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
		return cnt;
	}
	
	public ArrayList<GoodsVO> listGoods(int pageNUM){
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/ (double)pageSIZE);
		
		int start; //현재페이지에 따른 시작레코드 위치
		int end;   //현재페이지에 따른 시작레코드 위치
		
		//현재페이지에 따른 시작레코드 위치와 마지막레코드의 위치를 계싼해 준자
		end = pageNUM*pageSIZE;
		start = end-(pageSIZE-1);
		
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select no, name, price, qty, fname from "
					+ "(select rownum n, a.* "
					+ "from (select * from goods order by no) a) "
					+ "where n between ? and ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new GoodsVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		return list;
	}
}
