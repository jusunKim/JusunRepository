package com.sist.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.action.DeleteBoardAction;
import com.sist.action.DeleteBoardOKAction;
import com.sist.action.DetailBoardAction;
import com.sist.action.InsertBoardAction;
import com.sist.action.InsertBoardOKAction;
import com.sist.action.ListBoardAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBoardAction;
import com.sist.action.UpdateBoardOKAction;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class SistController
 */
//@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//사용자가 요청할 서비스명에 맞는 객체 만들기 위한 map 선언
	HashMap<String, SistAction> map;
    
	//서블릿이 맨 처음 요청될 때 딱 한 번 동작하는 init메소드를 오버라이딩
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
    	
    	//map생성해서 
    	map = new HashMap<String, SistAction>();
    	
    	try {
    		
    		//1.사용자 요청명, 일처리를 위한 클래스이름을 설정한 설정파일 sist.properties파일이 있는 실제 폴더WEB-INF의 경로 뽑기
    		//init에는 request가 없어서 ServletConfig를 통해서 실제경로를 알아온다.
			String path = config.getServletContext().getRealPath("WEB-INF");
			
			//2.sist.properties파일의 내용을 메모리로 읽어들이기 위한 FileReader객체 생성
			FileReader fr = new FileReader(path+"/sist.properties");
			
			//3.sist.properties파일의 내용을 key와 value로 분리시키기 위해 Properties객체 생성
			Properties prop = new Properties(); 
			
			//4.sist.properties파일의 스트림인 fr를 Properties객페인 prop에 담음.
			//load(스트림)을 하면 key와 value를 분리해 놓게 됨.(그게 prop안에 분리돼서 저장된 상태인듯)
			prop.load(fr); 			
			
			//5.Properties 객체 prop 통해 key를 가져온다(서비스명들)
			Set keys = prop.keySet();
			
			//6.Set의 요소를 하나씩 끄집어내오기위해 iterator로 변환해야 함.(Set은 반복문을 못써서)
			Iterator iter = keys.iterator(); 
			
			//7.Iterator에 데이터가 있는 만큼 반복 실행
			while(iter.hasNext()) {
				
				//7-1Iterator의 요소를 하나씩 끄집어내온다-next()를 통해. 결과물:설정파일의 서비스명
				String key = (String)iter.next();
				
				//7-2 Properties객체인 prop으로부터 서비스명(key)에 해당하는 일처리클래스명(value)꺼내온
				String clsName = (String)prop.get(key); //일처리 담당하는 클래스 이름
				
				//맵에다 클래스 이름을 스트링으로 등록하는 게 아니라 그거에 해당하는 객체를 등록해야하는거니까
				//7-3 클래스 이름에 해당하는 객체를 생성한다.
				SistAction obj = (SistAction)Class.forName(clsName).newInstance();
				
				//7-4 map에 서비스명과 일처리 담당 객체를 등록하기
				map.put(key, obj);
			}
			
			fr.close(); //8.스트림 닫기
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 요청 서비스명을 파악ㄱ하기 위해 uri를 알아오기
		String uri = request.getRequestURI();
		
		//uri로부터 서비스명을 추출해 cmd에 저장
		String cmd = uri.substring(uri.indexOf("/",1)+1); //앞에서부터 찾는데 첫글자(/)이후의 /를 찾는다는건가바
		
		//이동할 jsp파일명을 저장하기 위한 변수 선언. 
		String viewPage = "";
		
		BoardDAO dao = new BoardDAO();
		
		//map으로부터 일처리 담당 객체를 뽑아와
		SistAction action = map.get(cmd);
		//일처리 담당 객체를 통해 일처리 위한 메소드를 호출
		viewPage = action.pro(request, response);
		
		//jsp로 이동시키기 위한 디스패처 객체 생성
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		//디스패치 객체 통해 jsp로 이동시킴
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response); //사용자가 겟으로 요청하든 포스트로 요청하든 동일한 처리 위헤 post요청 시 doGet호출.
		//-> 모든 일처리는 doGet에 작성
	}

}
