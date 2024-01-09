package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BoardVO;

public class BoardDAO {
	
	public static int pageSIZE = 10; //한 화면에 보여줄 레코드 수
	public static int totalRecord =0; //전체 레코드 수
	public static int totalPage = 0; //전체 페이지 수
	
	
	
	//전체레코드수 반환하는 메소드 정의
	public int getTotalRecord(String writer) {
		int re = 0;
		String sql = "select count(*) from board ";
		
		if(writer!=null) {
			sql += "where writer='"+writer+"'";
		}
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				re=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return re;
	}
	

	
	//이미 달려있는 답글들의 b_step을 1씩 증가하는 메소드
	public void updateStep(int b_ref, int b_step) {
		
		String sql = "update board set b_step= b_step+1 where b_ref=? and b_step>?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);
			pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return ;
	}
	
	public int update(BoardVO b) {
		int re = -1;
		String sql = "update board set title=?, content=?, fname=? where no=? and pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getFname());
			pstmt.setInt(4, b.getNo());
			pstmt.setString(5, b.getPwd());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return re;
	}
	
	public int delete(int no, String pwd) {
		int re = -1;
		String sql = "delete board where no=? and pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return re;
	}
	
	public int insert(BoardVO b) {
		String sql = "insert into board values(?,?,?,?,?,sysdate,1,?,?,?,?,?)";
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContent());
			pstmt.setString(6, b.getFname());
			pstmt.setString(7, b.getIp());
			pstmt.setInt(8, b.getB_ref());
			pstmt.setInt(9, b.getB_level());
			pstmt.setInt(10, b.getB_step());
			re= pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public ArrayList<BoardVO> findAll(int pageNUM, String writer){
		totalRecord = getTotalRecord(writer);
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE);
		
		int end = pageNUM * pageSIZE ;
		int start = end-(pageSIZE-1);
		if(end>totalRecord) {
			end=totalRecord;
		}
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		
		String sql = "select no, title, writer, pwd,content,regdate,hit,fname,ip,b_ref,b_level,b_step "
				+ "from (select rownum n, no, title, writer, pwd,content,regdate,hit,fname,ip,b_ref,b_level,b_step "
				+ "from (select * from board  ";
		
		if(writer != null) {
			sql += " where writer = '"+writer+"'";
		}
		
		sql += " order by b_ref desc, b_step)) a "
				+ "where a.n between ? and ?";
		try {
			Connection conn= ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) ,  
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12)));
			}
			ConnectionProvider.close(conn, pstmt,rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}

	public int getNextNO() {
		int no = 0;
		String sql = "select nvl(max(no),0)+1 from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				no=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
		return no;
	}
	
	public BoardVO findByNO(int a) {
		BoardVO b = new BoardVO();
		String sql = "select * from board where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()) {
				b.setNo(a);
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPwd(rs.getString(4));
				b.setContent(rs.getString(5));
				b.setRegdate(rs.getDate(6));
				b.setHit(rs.getInt(7));
				b.setFname(rs.getString(8));
				b.setIp(rs.getString(9));
				b.setB_ref(rs.getInt(10));
				b.setB_level(rs.getInt(11));
				b.setB_step(rs.getInt(12));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e){
			System.out.println("예외 발생:"+e.getMessage());
		}
		return b;
	}

	
	
}
