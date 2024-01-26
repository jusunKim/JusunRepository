package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	
	public int insertGoods(GoodsVO g){
		int re = -1;
		String sql = "insert into goods values(?,?,?,?,?)";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn =  ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3, g.getPrice());
			pstmt.setInt(4, g.getQty());
			pstmt.setString(5, g.getFname());
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("에외 발생"+e.getMessage());
		}
		return re;
	}
	
	
	public ArrayList<GoodsVO> findAll(){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select * from goods";
		try {
			Context context = new InitialContext();
			DataSource ds =  (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new GoodsVO(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4), rs.getString(5)));
				
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
