package com.example.demo.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class BookService {
	
	@Autowired
	private BookDAO dao ;
	
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}
	
	public BookVO findById(int bookid) {
		BookVO b = null;
		//JPA의 findById는 VO를 반환하지 않고 VO를 Optional로 포장해서 반환한다.
		Optional<BookVO> o = dao.findById(bookid);
		if(o.isPresent()) {
			b = o.get();
		}
		return b;
	}
	
	
	public List<BookVO> findAll(HashMap<String, String> map){
//		return dao.findAll();
		String category = null;
		String search = null;
		String ordering = null;
		
		
		 category = map.get("category");
		 search = map.get("search");
		 ordering = map.get("ordering");
		List<BookVO> list = null;
		
		
		if(search!=null && !search.equals("")) {
			
			//dao에 호출해야 할 메소드 이름을 문자열 변수로 처리해서 실행시키기
			String methodName = "findBy"+category;
			try {
				Class cls = Class.forName(dao.getClass().getName());
				if(category.equals("Bookname")||category.equals("Publisher")) {
					methodName += "Containing";
					if(ordering!=null) {
						methodName += "OrderBy"+ordering;
					}
					Method method =cls.getDeclaredMethod(methodName, String.class); //메소드객체반환
					list = (List<BookVO>)method.invoke(dao, search); //invoke를 통해 해당 메소드 실행. invoke는 object반환
					
				}else {
					if(ordering!=null) {
						methodName += "OrderBy"+ordering;
					}
					Method method =cls.getDeclaredMethod(methodName, Integer.class); 
					list = (List<BookVO>)method.invoke(dao, new Integer(search)); 
				}
			} catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}else {
			list= dao.findAllByOrderByBookname();	
			if(ordering!=null) {
				String methodName2 = "findAllByOrderBy"+ordering;
				try {
					Class clas = Class.forName(dao.getClass().getName());
					Method method =clas.getDeclaredMethod(methodName2); //메소드객체반환
					list = (List<BookVO>)method.invoke(dao);
					
				} catch (Exception e) {
					System.out.println("예외발생"+e.getMessage());
				}
			}
		}
		return list;
	}
	
	//insert나 update를 위한 메소드.PK에 해당하는 레코드가 있으면 update, 아니면 insert실행하는 save()
	public void save(BookVO b) {
		dao.save(b);
	}
}
