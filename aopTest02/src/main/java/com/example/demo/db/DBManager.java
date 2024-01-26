package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.SistLogVO;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.DeptVO;

public class DBManager {
	
	//마이바티스 설정파일의 sql을 요청하기 위한 담당자 .SqlSession 만드는 공장
	private static SqlSessionFactory factory;
	
	static { //호출하지 않아도 어플리케이션 가동 시 자동으로 동작하는 ㅁ명령어는 여기 안에다 쓰면 된대
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml"; //환경설정위치잡아줌
			InputStream inputStream = Resources.getResourceAsStream(resource); //읽어오기
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("예외 발생"+e.getMessage());
		}
	}
	
	public static int insertLog(SistLogVO a) {
		int re =-1;
		SqlSession session = factory.openSession(true);
		re = session.insert("sistLog.insert", a);
		session.close();
		return re;
	}
	
	public static List<BookVO> listBook(){
		List<BookVO> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("book.findAll");
		session.close();
		return list;
	}
	
	public static List<DeptVO> findAll(){
		List<DeptVO> list = null;
		SqlSession session =  factory.openSession(); //마이바티스 설정파일의 sql 요청 위해 sqlsession을 얻어 온다
		list = session.selectList("dept.findAll");//얜 매개변수 받은 게 ㅇ벗어서 1개고
		session.close();
		return list;
	}
	
	public static int insert(DeptVO d) {
		int re = -1;
		SqlSession session = factory.openSession(); 
		re = session.insert("dept.insert", d);//매개변수 줬으니까 얘는 매개변수 두개인가바
		session.commit(); //데이터베이스에 변동이 있는 sql(i/u/d)는 반드시 커밋을 해야 반영된대
		return re;
	}
	
	public static DeptVO findByDno(int dno) {
		DeptVO d = null;
		SqlSession session = factory.openSession();
		d = session.selectOne("dept.findByDno", dno);
		session.close();
		return d;
	}
	
	public static int update(DeptVO d) {
		int re = -1;
		SqlSession session = factory.openSession(true); //불린값을 주면 오토커밋. 커밋 따로 안 쓸수있음.
		re = session.update("dept.update",d);
		session.close();
		return re;
		//근데 업데이트를 여러 개 할 수도 있잫아 그니까 그럴 때는 오토커밋 하면 안됨. 하나가 되도 하나가 안 되면 취소시켜야하니까
	}
	
	public static int delete(int dno) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.delete("dept.delete",dno);
		session.close();
		return re;
	}
}
