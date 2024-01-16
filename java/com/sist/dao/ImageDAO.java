package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.AmenityVO;
import com.sist.vo.ImageVO;

public class ImageDAO {
	//싱글턴 객체 다오
	public static ImageDAO dao = null;
	
	private ImageDAO() {
	}
	
	public static ImageDAO getInstance() {
		if(dao==null) {
			dao = new ImageDAO();
		}
		return dao;
	}
	
	//이하 메소드
	public ImageVO listImage(int pno){
	      ImageVO list = null;
	      String sql = "select * from image where pno="+pno;
	      try {
	         Connection conn =ConnectionProvider.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	            list = new ImageVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), pno);
	         }
	         ConnectionProvider.close(conn, stmt, rs);
	      } catch (Exception e) {
	         System.out.println("예외:"+e.getMessage());
	      }
	      return list;
	   }
	

}
