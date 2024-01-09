package com.sist.controller;

import java.io.FileReader;
import java.io.IOException;
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

import com.sist.action.SistAction;
import com.sist.dao.BoardDAO;

/**
 * Servlet implementation class SistController
 */
@WebServlet("*.do")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	HashMap<String , SistAction> map;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		map = new HashMap<String, SistAction>();
		String path = config.getServletContext().getRealPath("WEB-INF");
		try {
			FileReader fr = new FileReader(path+"/sist.properties");
			Properties prop = new Properties();
			prop.load(fr);
			Set keys = prop.keySet();
			Iterator iter = keys.iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();
				String clsName = prop.getProperty(key);
				SistAction obj = (SistAction)Class.forName(clsName).newInstance();
				map.put(key, obj);
				
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
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
		
		//jsp로 이동시키기 위한 디스패처 객체 생성. 템플릿으로 싹다보낼거임
		RequestDispatcher dispatcher = request.getRequestDispatcher("/template.jsp");
		if(uri.indexOf("member") != -1) {
			viewPage = "member/"+viewPage;
		}
		
		//template.jsp로 보낼 때 사용자가 요청한 페이지를 상태유지해서 보낼거여!!!
		request.setAttribute("viewPage", viewPage);
		
		//디스패치 객체 통해 jsp로 이동시킴
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
