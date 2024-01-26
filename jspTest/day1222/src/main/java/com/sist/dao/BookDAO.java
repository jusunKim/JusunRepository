package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVO;

public class BookDAO {
   String driver ="oracle.jdbc.driver.OracleDriver";
   String url ="jdbc:oracle:thin:@localhost:1521:XE";
   String username = "c##madang";
   String password = "madang";
   
   public int deleteBook(int bookid) {
      int re = -1;
      String sql = "delete book where bookid = ?";
      try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement pstmt = conn.prepareStatement(sql);
               
         pstmt.setInt(1,bookid);
         re = pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      }catch (Exception e) {
         System.out.println("예외발생 : "+e.getMessage());
      }
      return re;
   }
   
   
   public int updateBook(BookVO b) {
      int re = -1;
      String sql = "update book set bookname=?, price=?, publisher=? where bookid=?";
      try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement pstmt = conn.prepareStatement(sql);
         
         
         pstmt.setString(1, b.getBookname());
         pstmt.setInt(2, b.getPrice());
         pstmt.setString(3, b.getPublisher());
         pstmt.setInt(4, b.getBookid());
         re = pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      }catch (Exception e) {
         System.out.println("예외발생 : "+e.getMessage());
      }
      return re;
   }
   
   public int insertBook(BookVO b) {
      int re = -1;
      String sql = "insert into book values(?,?,?,?)";
      try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, b.getBookid());
         pstmt.setString(2, b.getBookname());
         pstmt.setInt(3, b.getPrice());
         pstmt.setString(4, b.getPublisher());
         re = pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      }catch (Exception e) {
         System.out.println("예외발생 : "+e.getMessage());
      }
      return re;
   }
   
   public ArrayList<BookVO> listBook(){
      String sql = "select * from book order by bookid";
      ArrayList<BookVO> list = new ArrayList<BookVO>();
      try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, username, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()) {
            list.add(new BookVO(rs.getInt(1),
            rs.getString(2),
            rs.getInt(3),
            rs.getString(4)));
            
         }
      }catch (Exception e) {
         System.out.println("예외발생 : "+e.getMessage());
      }
      return list;
   }
}