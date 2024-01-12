package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.ChatVO;

public class ChatDAO {
	   String driver ="oracle.jdbc.driver.OracleDriver";
	   String url ="jdbc:oracle:thin:@localhost:1521:XE";
	   String username = "c##madang";
	   String password = "madang";
	   
	   public ArrayList<ChatVO> listChat(){
		   ArrayList<ChatVO> list = new ArrayList<ChatVO>();
		   String sql = "select * from chat order by no desc";
		   try {
			   Class.forName(driver);
			   Connection conn = DriverManager.getConnection(url, username, password);
			   Statement stmt = conn.createStatement();
			   ResultSet rs = stmt.executeQuery(sql);
			   while(rs.next()) {
				   list.add(new ChatVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			   }
			   rs.close();
			   stmt.close();
			   conn.close();
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
			return list;	   
	   }
	   
	   public int insertChat(ChatVO c) {
		   int re = -1;
		   String sql = "insert into chat values(seq_chat.nextval, ?, ?)";
		   try {
			   Class.forName(driver);
			   Connection conn = DriverManager.getConnection(url, username, password);
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, c.getName());
			   pstmt.setString(2, c.getMsg());
			   re = pstmt.executeUpdate();
			   pstmt.close();
			   conn.close();
		} catch (Exception e) {
			System.out.println("예외 발생"+e.getMessage());
		}
		   return re;
	   }
	   
}
