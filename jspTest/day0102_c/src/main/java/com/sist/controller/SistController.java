package com.sist.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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
    	
    	//map생성해서 서비스명이 key, 일처리 담당 객체를 value로 해서 데이터 넣어놓기
    	map = new HashMap<String, SistAction>();
    	map.put("listBoard.do", new ListBoardAction());
    	map.put("insertBoard.do", new InsertBoardAction());
    	map.put("insertBoardOK.do", new InsertBoardOKAction());
    	map.put("detailBoard.do", new DetailBoardAction());
    	map.put("deleteBoard.do", new DeleteBoardAction());
    	map.put("deleteBoardOK.do", new DeleteBoardOKAction());
    	map.put("updateBoard.do", new UpdateBoardAction());
    	map.put("updateBoardOK.do", new UpdateBoardOKAction());
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
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		
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
		doGet(request, response); //사용자가 겟으로 요청하든 포스트로 요청하든 동일한 처리 위헤 post요청 시 doGet호출.
		//-> 모든 일처리는 doGet에 작성
	}

}
