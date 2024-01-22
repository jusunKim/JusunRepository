package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	
	public static List<GoodsVO> findAll(){
		List<GoodsVO> list = null;
		SqlSession session = factory.openSession();
		list =  session.selectList("goods.findAll");
		session.close();
		return list;
	}
	
	public static int getNextNo() {
		int re = 0;
		SqlSession session = factory.openSession();
		re = session.selectOne("goods.getNextNo");
		session.close();
		return re;
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
