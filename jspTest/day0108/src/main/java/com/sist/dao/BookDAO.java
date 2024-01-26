package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

public class BookDAO {
	
	public static BookDAO dao = null;
	
	private BookDAO() {
	}
	
	public static BookDAO  getInstance() {
		if(dao==null) { //최초의 다오가 필요할 때만
			dao = new BookDAO(); //다오를 생성하고
		} //아니면 기존의 다오를 반환하는거지
		return dao;
	}
	
	public ArrayList<String> listPublisher(){
		ArrayList<String> p_list = new ArrayList<String>();
		String sql = "select distinct publisher from book";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				p_list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return p_list;
	}
	
	public ArrayList<BookVO> findAll(String category, String comparing, String search, String column){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";
		if(search!=null) {
			if(!category.equals("price")) {
				sql += " where "+category+" like '%"+search+"%'";
			}else {
				sql += " where price "+comparing +" "+search+"";
			}
		}
		if(column!=null) {
			sql+= " order by "+column+"";
		}
		System.out.println(sql);
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
			ConnectionProvider.close(conn, stmt,rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
