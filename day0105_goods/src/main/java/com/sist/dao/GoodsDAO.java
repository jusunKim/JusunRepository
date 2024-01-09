package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.db.ConnectionProvider;
import com.sist.vo.GoodsVO;

public class GoodsDAO {
	
	public static int totalPage=0;
	public static int pageSIZE = 3;
	public static int totalRecord = 0;
	
	public int getTotalRecord(String search) {
		int re = -1;
		String sql = "select count(*) from goods";
				if(search!=null) {
					sql+= " where name like '%"+search+"%'";
				}
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				re = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return re;
	}
	
	public ArrayList<GoodsVO> findAll(int pageNUM, String search){
		
		totalRecord = getTotalRecord(search);
		totalPage = (int)Math.ceil( totalRecord/(double)pageSIZE);
		
		int end = pageSIZE * pageNUM;
		int start = end-pageSIZE+1;
		if(end>totalRecord) {
			end=totalRecord;
		}
		
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select no, name, price, qty, fname from (select rownum n, a.* from (select * from goods ";
				if(search!=null) {
					sql+= "where name like '%"+search+"%'";
				}
				
				sql += ") a) where n between ? and ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new GoodsVO(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4), rs.getString(5)));
				
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return list;
	}
	
	public int updateGoods(GoodsVO g){
		int re = -1;
		String sql = "update goods set name=?, price=?, qty=?, fname=? where no=?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/sist");
			Connection conn =  ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(5, g.getNo());
			pstmt.setString(1, g.getName());
			pstmt.setInt(2, g.getPrice());
			pstmt.setInt(3, g.getQty());
			pstmt.setString(4, g.getFname());
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("에외 발생"+e.getMessage());
		}
		return re;
	}
	
	
	public int deleteGoods(int no) {
		int re = -1;
		String sql = "delete from goods where no=?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/sist");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("에외 발생:"+e.getMessage());
		}
		
		return re;
	}
	
	public GoodsVO findbyNo(int no) {
		GoodsVO g = null;
		String sql = "select * from goods where no=?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/sist");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				g= new GoodsVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
				System.out.println("예외 발생"+e.getMessage());
		}
		return g;
	}
	
	public int insertGoods(GoodsVO g){
		int re = -1;
		String sql = "insert into goods values(?,?,?,?,?)";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/sist");
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
	
	

}
