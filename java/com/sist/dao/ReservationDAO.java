package com.sist.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.db.ConnectionProvider;
import com.sist.vo.ReservationVO;

public class ReservationDAO {
	
	public static ReservationDAO dao = null;
	private ReservationDAO() { }
	public static ReservationDAO getInstance() {
		if( dao == null ) {
			dao = new ReservationDAO();
		}
		return dao;
	}
	
	
	//예약번호 rno를 1개를 상세조회 
		public ReservationVO detailReservation(int rno) {
		    ReservationVO rsrv = null;
		    String sql = "select * from reservation where rno = ?";
		    
		    try {
		        Connection conn = ConnectionProvider.getConnection();
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, rno);
		        
		        ResultSet rs = pstmt.executeQuery();
		        if (rs.next()) {
		            Date rDate = rs.getDate("R_DATE");
		            rsrv = new ReservationVO(rno, rDate,
		                    rs.getString("CARDNO"), 
		                    rs.getString("CHECKIN_DATE"),
		                    rs.getString("CHECKOUT_DATE"), 
		                    rs.getInt("GUEST_CNT"),
		                    rs.getInt("SALEPRICE"), 
		                    rs.getInt("UNO"), 
		                    rs.getInt("PNO"));
		        }
		        ConnectionProvider.close(conn, pstmt, rs);
		    } catch (Exception e) {
		        System.out.println("예외:" + e.getMessage());
		    }
		    return rsrv;
		}
	
	// 예약번호로 예약취소 - 정말 취소하시겠습니까?(확인절차)
	public int deleteReservation(int rno) {
		int re = -1;
		String sql = "delete reservation where rno = ?";
		System.out.println(sql);
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	// 예약하기
	public int insertReservation(ReservationVO r) {
		int re = -1;
		String sql = "insert into Reservation values (?, sysdate, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getRno());
			pstmt.setString(2, r.getCardno());
			pstmt.setString(3, r.getCheckin_date());
			pstmt.setString(4, r.getCheckout_date());
			pstmt.setInt(5, r.getGuest_cnt());
			pstmt.setInt(6, r.getSaleprice());
			pstmt.setInt(7, r.getUno());
			pstmt.setInt(8, r.getPno());
			
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		return re;
	}
	
	// 회원번호를 가지고 자신을 예약 조회 - 내림차순 정렬
	public ArrayList<HashMap<String, Object>> listMyReservation(int uno){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "select rno, cardno, checkin_date, checkout_date, guest_cnt, saleprice, p.p_name"
				+ " from reservation r, product p"
				+ " where r.pno = p.pno and uno = "+ uno
				+ " order by rno desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("rno", rs.getInt(1));
				map.put("cardno", rs.getInt(2));
				map.put("checkin_date", rs.getDate(3));
				map.put("checkout_date", rs.getDate(4));
				map.put("guest_cnt", rs.getInt(5));
				map.put("saleprice", rs.getInt(6));
				map.put("p_name", rs.getString(7));
				list.add(map);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		return list;
	}
	
	// 관리자용 전체 예약 조회 - 내림차순 정렬
	public ArrayList<HashMap<String, Object>> listAllReservation(String category, String keyword){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "select rno, cardno, checkin_date, checkout_date, "
				+ " guest_cnt, saleprice, u.u_name, u.u_email, p.p_name, r.pno, r.r_date"
				+ " from reservation r, product p, users u"
				+ " where r.pno = p.pno"
				+ " and r.uno = u.uno";
				if(keyword!=null) { //rno, u_email, pno로 검색.
					if(category.equals("u_email")) { 
						sql+=" and u_email like '%"+keyword+"%'";
					}else { //rno, pno.
						sql+=" and "+category+" = "+keyword;
					}
				}
				sql += " order by rno desc";
				System.out.println(sql);
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("rno", rs.getInt(1));
				map.put("cardno", rs.getString(2));
				map.put("checkin_date", rs.getDate(3));
				map.put("checkout_date", rs.getDate(4));
				map.put("guest_cnt", rs.getInt(5));
				map.put("saleprice", rs.getInt(6));
				map.put("u_name", rs.getString(7));
				map.put("u_email", rs.getString(8));
				map.put("p_name", rs.getString(9));
				map.put("pno", rs.getInt(10));
				map.put("r_date", rs.getDate(11));
				list.add(map);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		return list;
	}
	
	// 관리자용 전체 예약 조회 - 내림차순 정렬
	public HashMap<String, Object> detailAllReservation(int rno){
		HashMap<String, Object> map = new HashMap<String, Object>();
		String sql = "select rno, cardno, checkin_date, checkout_date, "
				+ " guest_cnt, saleprice, u.u_name, u.u_email, p.p_name, r.pno, r.r_date"
				+ " from reservation r, product p, users u"
				+ " where r.pno = p.pno"
				+ " and r.uno = u.uno and rno="+rno;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				map.put("rno", rs.getInt(1));
				map.put("cardno", rs.getString(2));
				map.put("checkin_date", rs.getDate(3));
				map.put("checkout_date", rs.getDate(4));
				map.put("guest_cnt", rs.getInt(5));
				map.put("saleprice", rs.getInt(6));
				map.put("u_name", rs.getString(7));
				map.put("u_email", rs.getString(8));
				map.put("p_name", rs.getString(9));
				map.put("pno", rs.getInt(10));
				map.put("r_date", rs.getDate(11));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		return map;
	}
	
	// 예약 등록시 예약번호 부여 ex 2401150001
	   public int getNextRno() {
	       int rno = 1;
	       String sql  = "SELECT TO_CHAR(SYSDATE, 'YYMMDD') || " +
	                     "LPAD(NVL(MAX(TO_NUMBER(SUBSTR(rno, 9))), 0) + 1, 3, '0') " +
	                     "FROM Reservation " +
	                     "WHERE TO_CHAR(r_date, 'YYMMDD') = TO_CHAR(SYSDATE, 'YYMMDD')";
	       try {
	           Connection conn = ConnectionProvider.getConnection();
	           Statement stmt = conn.createStatement();
	           ResultSet rs = stmt.executeQuery(sql);
	           if(rs.next()) {
	               rno = Integer.parseInt(rs.getString(1));
	           }
	           ConnectionProvider.close(conn, stmt, rs);
	       } catch (Exception e) {
	           System.out.println("예외발생 : " + e.getMessage());
	       }
	       return rno;
	   }
	
}