package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

public class BookDAO {
	//모든 도서 목록 조회해 반환하는 메소드 정의합니다
	public ArrayList<BookVO> findAll() {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return list;
	}
	
	//등록, 수정, 삭제를 위한 메소드를 각각 만들기
	
	//등록
	public int insertBook(BookVO b) {
		int re = -1;
		String sql = "insert into book values(?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBookid());
			pstmt.setString(2, b.getBookname());
			pstmt.setInt(3, b.getPrice());
			pstmt.setString(4, b.getPublisher());
			pstmt.setString(5, b.getFname());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return re;
	}
	
	//수정
	public int updateBook(BookVO b) {
		int re = -1;
		String sql = "update book set bookname=?, price=?, publisher=? where bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookname());
			pstmt.setInt(2, b.getPrice());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getBookid());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	//삭제
	public int deleteBook(int bookid) {
		int re = -1;
		String sql = "delete book where bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return re;
	}
	
	//도서 상세보기에 필요한 메소드
	//도서번호 매개변수로 전달받아 해당 도서 정보 조회해 반환하는 메솓,
	public BookVO findByBookid(int bookid) {
		BookVO b = new BookVO();
		String sql = "select * from book where bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setPrice(rs.getInt(3));
				b.setPublisher(rs.getString(4));
				b.setFname(rs.getString(5));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return b;
	}
}
