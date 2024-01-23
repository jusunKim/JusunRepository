package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVO;
import com.example.demo.vo.GoodsVO;

public class DBManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.println("예외 발생:"+e.getMessage());
		}
	}
	
	public static int countTotalRecord() {
		int re = 0;
		SqlSession session = factory.openSession();
		re = session.selectOne("board.countTotalRecord");
		session.close();
		return re;
	}
	
	public static int updateStep(int b_ref, int b_step) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		HashMap<String, Integer> map = new HashMap<String, Integer>();//밑에 매개변수 줘야되는데 두개를 줘야되니까 map으로
		map.put("b_ref", b_ref);
		map.put("b_step", b_step);
		re = session.update("board.updateStep",map); //줘야하는파라미터가 여러개면 맵에 실어서 보냄!!! sql에서는 key이름으로 접근
		session.close();
		return re;
	}
	
	public static int getNextNo() {
		int re = 0;
		SqlSession session = factory.openSession();
		re = session.selectOne("board.getNextNo");
		session.close();
		return re;
	}
	
	public static List<BoardVO> listBoard(HashMap<String, Integer> map){
		List<BoardVO> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("board.listBoard",map);
		session.close();
		return list;
	}
	
	public static BoardVO detailBoard(int no) {
		SqlSession session = factory.openSession();
		BoardVO b = session.selectOne("board.detailBoard",no);
		session.close();
		return b;
	}
	
	public static int insertBoard(BoardVO b) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("board.insert", b);
		session.close();
		return re;
	}

	public static List<GoodsVO> findAll(){
		List<GoodsVO> list = null;
		SqlSession session = factory.openSession();
		list =  session.selectList("goods.findAll");
		session.close();
		return list;
	}
	
	
	
	public static int insert(GoodsVO g) {
		int re = -1;
		SqlSession session = factory.openSession(true); //커밋 따로 안 해도 되게!!!!!
		re = session.insert("goods.insert",g);
		session.close();
		return re;
	}
	
	public static GoodsVO findByNo(int no) {
		SqlSession session = factory.openSession();
		GoodsVO g = session.selectOne("goods.findByNo",no);
		session.close();
		return g;
	}
	
	public static int update(GoodsVO g) {
		int re = -1;
		SqlSession session = factory.openSession(true); 
		re = session.update("goods.update",g);
		session.close();
		return re;
	}
	
	public static int delete(int no) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.delete("goods.delete",no);
		session.close();
		return re;
	}

}
