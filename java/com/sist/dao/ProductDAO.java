package com.sist.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.db.ConnectionProvider;
import com.sist.vo.ProductVO;

public class ProductDAO {
   public static ProductDAO dao = null;
   private ProductDAO() { }
   public static ProductDAO getInstance() {
      if( dao == null ) {
         dao = new ProductDAO();
      }
      return dao;
   }
   
   // 상품 삭제시 자식 테이블에 연결되어있는 레코드도 삭제시키는 트리거
//   CREATE OR REPLACE TRIGGER cascade_delete_trigger
//   BEFORE DELETE ON product
//   FOR EACH ROW
//   BEGIN
//     DELETE FROM Amenity WHERE pno = :OLD.pno;
//     DELETE FROM Review WHERE pno = :OLD.pno;
//     DELETE FROM Wishlist WHERE pno = :OLD.pno;
//     DELETE FROM Image WHERE pno = :OLD.pno;
//     DELETE FROM Reservation WHERE pno = :OLD.pno;
//   END;
//   /
   
   // review 를 등록완료시 상품번호에 따른 평균 평점을 구하여 상품테이블 평점 업데이트
      public int avgRating(int pno) {
         int re = -1;
         String sql = "update product set rating ="
               + " (select avg(rating from review "
               + " where pno = "+ pno +") where pno = " + pno;
         try {
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            re = stmt.executeUpdate(sql);
            ConnectionProvider.close(conn, stmt);
         } catch (Exception e) {
            System.out.println("예외발생:"+e.getMessage());
         }
         return re;
      }
   
   // 검색은 상품명으로 하지만 상품번호를 받아와서 삭제 -- 트리거 설정
   public int deleteProduct(int pno) {
      int re = -1;
      String sql  = "delete product where pno=?" ; 
      System.out.println(sql);
      System.out.println(sql);
      try {
         Connection conn = ConnectionProvider.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, pno);
         re = pstmt.executeUpdate();
         ConnectionProvider.close(conn, pstmt);
      } catch (Exception e) {
         System.out.println("예외발생:"+e.getMessage());
      }
      return re;
   }
   
   // 리뷰를 전체 조회해서 평균평점 계산
//   public int avgRating() {
//       
//   }
   
   // 상품번호에 따른 연락처, 최대 인원수, 가격 변경
   public int updateProduct(ProductVO p) {
      int re = -1;
      String sql = "update Product set p_phone = ?, occ_max = ?, price = ? where pno = ?";
     
      try {      
         Connection conn =ConnectionProvider.getConnection();   
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, p.getP_phone());
         pstmt.setInt(2, p.getOcc_max());
         pstmt.setInt(3, p.getPrice());
         pstmt.setInt(4, p.getPno());
         re = pstmt.executeUpdate();
         ConnectionProvider.close(conn, pstmt);      
      }catch (Exception e) {
         System.out.println("예외발생:"+e.getMessage());
      }      
      System.out.println(sql);
      return re;
   }
   
   // 상품등록
   public int insertProduct(ProductVO p) {
      String sql = "insert into Product values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      int re = -1;
      try {
         Connection conn = ConnectionProvider.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, p.getPno());
         pstmt.setString(2, p.getP_phone());
         pstmt.setString(3, p.getP_name());
         pstmt.setString(4, p.getAddr());
         pstmt.setInt(5, p.getOcc_max());
         pstmt.setInt(6, p.getPrice());
         pstmt.setDouble(7, p.getRating());
         pstmt.setString(8, p.getP_explain());
         pstmt.setDouble(9, p.getLat());
         pstmt.setDouble(10, p.getLng());
         pstmt.setInt(11, p.getA_code());
         pstmt.setInt(12, p.getP_code());
         
         re = pstmt.executeUpdate();
         ConnectionProvider.close(conn, pstmt);
      } catch (Exception e) {
         System.out.println("예외발생 : " + e.getMessage());
      }
      return re;
   }
   
   
  
   
   //지도로 검색
   //select p.pno, i.img1, p.p_name, p.price, p.rating
   //from product p, image i
   //where p.pno = i.pno
   //and a_code=?;
   public ArrayList<HashMap<String, Object>> mapSearchProduct(int a_code){
	   ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
	   String sql = "select p.pno, i.img1, p.p_name, p.price, p.rating "
	   		+ " from product p, image i "
	   		+ " where p.pno = i.pno "
	   		+ " and a_code="+a_code;
	   try {
		   Connection conn =ConnectionProvider.getConnection();
		   Statement stmt = conn.createStatement();
		   ResultSet rs = stmt.executeQuery(sql);
		   while(rs.next()) {
			   System.out.println(1);
			   HashMap<String, Object> map = new HashMap<String, Object>();
			   map.put("pno", rs.getInt(1));
			   map.put("img", rs.getString(2));
			   map.put("p_name", rs.getString(3));
			   map.put("price", rs.getInt(4));
			   map.put("rating", rs.getDouble(5));
			   list.add(map);
		   }
		   ConnectionProvider.close(conn, stmt, rs);
	   } catch (Exception e) {
		   System.out.println("예외:"+e.getMessage());
	   }
	   return list;
   }
   
 //상단바 검색 -가격 추가
 //  select p.pno, i.img1, p.p_name, p.price, p.rating
 //  from product p, image i
 //  where p.pno=i.pno
 //  and occ_max>=2
 //  and a_code=2
 //  and p.price between 10000 and 100000
 //  and p.pno in (
 //  select distinct p.pno
 //  from product p, reservationstatus rs
 //  where p.pno=rs.pno
 //  and reserved_date not between '23/12/23' and '23/12/30')
 //  order by rating desc;
   public ArrayList<HashMap<String, Object>> menuSearchProduct(int occ_max, int a_code, int min, int max, String start_date, String end_date){
	   ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
	   String sql = "select p.pno, i.img1, p.p_name, p.price, p.rating "
	   		+ "from product p, image i "
	   		+ "where p.pno=i.pno "
	   		+ "and occ_max>=? "
	   		+ "and a_code=? "
	   		+ "and p.price beween ? and ? "
	   		+ "and p.pno in ( "
	   		+ "select distinct p.pno "
	   		+ "from product p, reservationstatus rs "
	   		+ "where p.pno=rs.pno "
	   		+ "and reserved_date not between ? and ?) "
	   		+ "order by rating desc";
	   try {
		   Connection conn =ConnectionProvider.getConnection();
		   PreparedStatement pstmt = conn.prepareStatement(sql);
		   pstmt.setInt(1, occ_max);
		   pstmt.setInt(2, a_code);
		   pstmt.setInt(3, min);
		   pstmt.setInt(4, max);
		   pstmt.setString(5, start_date);
		   pstmt.setString(6, end_date);
		   ResultSet rs = pstmt.executeQuery();
		   while(rs.next()) {
			   HashMap<String, Object> map = new HashMap<String, Object>();
			   map.put("pno", rs.getInt(1));
			   map.put("img", rs.getString(2));
			   map.put("p_name", rs.getString(3));
			   map.put("price", rs.getInt(4));
			   map.put("rating", rs.getDouble(5));
			   list.add(map);
			   System.out.println(rs.getInt(1));
		   }
		   ConnectionProvider.close(conn, pstmt, rs);
	   } catch (Exception e) {
		   System.out.println("예외:"+e.getMessage());
	   }
	   return list;
   }
   
   
   // 상품 전체 조회
   public ArrayList<HashMap<String, Object>> listProduct(int uno){
      ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
      String sql = "select p.pno, i.img1, p.p_name, p.price, p.rating "
            + "from product p, image i "
            + "where p.pno = i.pno ";
      
            if(uno != 0) {
               sql += "and p.pno not in (select pno from wishlist where uno = "+ uno +")";
            }
      
            sql += " order by rating desc";
      try {
         Connection conn = ConnectionProvider.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("pno", rs.getInt(1));
            map.put("img", rs.getString(2));
            map.put("p_name", rs.getString(3));
            map.put("price", rs.getInt(4));
            map.put("rating", rs.getDouble(5));
            list.add(map);
         }
         ConnectionProvider.close(conn, stmt, rs);
      } catch (Exception e) {
         System.out.println("예외발생 : " + e.getMessage());
      }
      return list;
   }
   
   
   //관리자>상품 관리 화면 상품 테이블전체뽑아오기
   public ArrayList<ProductVO> listAllProduct(String category, String search){
      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
      String sql = "select * from product p";
      if(search!=null) { //p_name, a_code로 검색.
    	  if(category.equals("p_name")) {
    		  sql += " where p_name like '%"+search+"%'";
    	  }else {
    		  sql += " where a_code = "+ search;
    	  }
    	 sql+=" order by p_name";
      }
      System.out.println(sql);
      try {
         Connection conn = ConnectionProvider.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()) {
        	 list.add(new ProductVO( rs.getInt(1),
                     rs.getString(2),
                     rs.getString(3),
                     rs.getString(4),
                     rs.getInt(5),
                     rs.getInt(6),
                     rs.getDouble(7),
                     rs.getString(8),
                     rs.getDouble(9),
                     rs.getDouble(10),
                     rs.getInt(11),
                     rs.getInt(12)   
             ));
         }
         ConnectionProvider.close(conn, stmt, rs);
      } catch (Exception e) {
         System.out.println("예외발생 : " + e.getMessage());
      }
      return list;
   }
   
   // 상세페이지 조회 조건 추가시 매개변수,sql 수정 
   public ProductVO detailProduct(int pno){
	      ProductVO pd = null;
	      String sql = "select * from product where pno= "+pno;
	      try {
	         Connection conn = ConnectionProvider.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	            pd = new ProductVO(
	                     rs.getInt("pno"),
	                     rs.getString("p_phone"),
	                     rs.getString("p_name"),
	                     rs.getString("addr"),
	                     rs.getInt("occ_max"),
	                     rs.getInt("price"),
	                     rs.getDouble("rating"),
	                     rs.getString("p_explain"),
	                     rs.getDouble("lat"),
	                     rs.getDouble("lng"),
	                     rs.getInt("a_code"),
	                     rs.getInt("p_code")
	                  );
	         }
	         ConnectionProvider.close(conn, stmt, rs);
	      } catch (Exception e) {
	         System.out.println("예외발생 : " + e.getMessage());
	      }
	      return pd;
	   }

 //예약 확인서 상세페이지룡 rno와 uno를 매개변수로 받는 product 확인 메소드
	  public HashMap<String, Object> getProductVoucher(int rno, int uno) {
	       HashMap<String, Object> info = null;
	       String sql = "SELECT R.pno, P.p_name, P.p_phone, P.addr " +
	                    "FROM Reservation R " +
	                    "JOIN Users U ON R.uno = U.uno " +
	                    "JOIN Product P ON R.pno = P.pno " +
	                    "WHERE R.rno = ? AND U.uno = ?";
	
	       try (Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	
	           pstmt.setInt(1, rno);
	           pstmt.setInt(2, uno);
	
	           try (ResultSet rs = pstmt.executeQuery()) {
	               if (rs.next()) {
	                   info = new HashMap<>();
	                   info.put("pno", rs.getInt("pno"));
	                   info.put("productName", rs.getString("p_name"));
	                   info.put("pPhone", rs.getString("p_phone"));
	                   info.put("addr", rs.getString("addr"));
	               }
	           }
	
	       } catch (Exception e) {
	           System.out.println("예외 발생: " + e.getMessage());
	       }
	
	       return info;
	   }
   
   // 상품 번호에 따른 이미지와 주소, 평점, 최대인원 
   public ArrayList<HashMap<String, Object>> listCard(int pno){
      ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
      String sql = "select img1, img2, img3, img4, img5, addr, rating, occ_max"
            + " from product p, image"
            + " where p.pno = i.pno and p.pno = "+ pno;
      try {
         Connection conn = ConnectionProvider.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("img1", rs.getString(1));
            map.put("img2", rs.getString(2));
            map.put("img3", rs.getString(3));
            map.put("img4", rs.getString(4));
            map.put("img5", rs.getString(5));
            map.put("addr", rs.getString(6));
            map.put("rating", rs.getDouble(7));
            map.put("occ_max", rs.getInt(8));
            list.add(map);
         }
         ConnectionProvider.close(conn, stmt, rs);
      } catch (Exception e) {
         System.out.println("예외발생 : " + e.getMessage());
      }
      return list;
   }
   
   // 상품 등록시 번호 부여
   //select nvl(max(pno),700000+6*10000) + 1 from product
   //where floor(pno/1000)*1000 = 700000+6*10000;
   public int getNextPno(int a_code) {
      int pno = 0;
      String sql  = "select nvl(max(pno),700000+"+a_code+"*10000) + 1 from product "
      				+ "where floor(pno/1000)*1000 = 700000+"+a_code+"*10000";
      try {
         Connection conn = ConnectionProvider.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         if(rs.next()) {
            pno = rs.getInt(1);
         }
         ConnectionProvider.close(conn, stmt, rs);
      } catch (Exception e) {
         System.out.println("예외발생 : " + e.getMessage());
      }
      return pno;
   }
   
   //주소 넣으면 a_code반환하는 메소드. product에 insert할 때 a_code 노가다로 찾지 말고 메소드 불러와서 넣으면 될듯
   public int getACode(String addr) {
	   int re = 0;
	   String keyword = null;
	   String[] jejuCityAreas = {"한경면", "한림읍", "애월읍", "조천읍", "구좌읍"};
	   String[] seogwipoCityAreas = {"대정읍", "안덕면", "중문", "남원읍", "표선면", "성산읍"};

	   if (addr.contains("제주시")) {
	       for (String area : jejuCityAreas) {
	           if (addr.contains(area)) {
	               keyword = area;
	               break;
	           }
	       }
	       if (keyword == null) {
	           keyword = "제주시";
	       }
	   } else if (addr.contains("서귀포시")) {
	       for (String area : seogwipoCityAreas) {
	           if (addr.contains(area)) {
	               keyword = area;
	               break;
	           }
	       }
	       if (keyword == null) {
	           keyword = "서귀포시";
	       }
	   }

	   
	   String sql = "select a_code from local where local = '"+keyword+"' ";
	     try {
	         Connection conn = ConnectionProvider.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         if(rs.next()) {
	            re = rs.getInt(1);
	         }
	         ConnectionProvider.close(conn, stmt, rs);
	      } catch (Exception e) {
	         System.out.println("예외발생 : " + e.getMessage());
	      }
	   
	   return re;
   }
}