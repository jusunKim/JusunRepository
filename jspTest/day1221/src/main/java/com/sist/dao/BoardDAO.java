package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVO;
import com.sist.vo.BookVO;

public class BoardDAO {
   String driver ="oracle.jdbc.driver.OracleDriver";
   String url ="jdbc:oracle:thin:@localhost:1521:XE";
   String username = "c##madang";
   String password = "madang";
   

   
   public int insertBoard(BoardVO b) {
      int re = -1;
      String sql = "insert into board values(seq_board.nextval,?,?,?,sysdate,?)";
      try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, b.getTitle());
         pstmt.setString(2, b.getWriter());
         pstmt.setString(3, b.getContent());
         pstmt.setString(4, b.getIp());
         re = pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      }catch (Exception e) {
         System.out.println("예외발생 : "+e.getMessage());
      }
      return re;
   }
   
   
}