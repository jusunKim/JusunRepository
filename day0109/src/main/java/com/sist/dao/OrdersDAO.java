package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.db.ConnectionProvider;

public class OrdersDAO {
	
	public static OrdersDAO dao; //=null안 해도 기본은 null이라고 하네
	
	private OrdersDAO() {}
	
	public static OrdersDAO getInstance() {
		if(dao==null) {
			dao = new OrdersDAO();
		}
		return dao;
	}
	
	public ArrayList<HashMap<String, Object>> listOrders(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "select c.custid, name, b.bookname"
				+ " from customer c, orders o, book b"
				+ " where c.custid = o.custid and o.bookid = b.bookid";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("custid", rs.getInt(1));
				map.put("name", rs.getString(2));
				map.put("bookname", rs.getString(3));
				list.add(map);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return list;
	}
}
