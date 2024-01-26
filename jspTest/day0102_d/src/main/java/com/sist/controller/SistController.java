package com.sist.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.DeleteBookAction;
import com.sist.action.DeleteBookOKAction;
import com.sist.action.DetailBookAction;
import com.sist.action.InsertBookAction;
import com.sist.action.InsertBookOKAction;
import com.sist.action.ListBookAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBookAction;
import com.sist.action.UpdateBookOKAction;
import com.sist.dao.BookDAO;

/**
 * Servlet implementation class SistController
 */
//@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	HashMap<String, SistAction> map;
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
		map.put("listBook.do", new ListBookAction());
		map.put("insertBook.do", new InsertBookAction());
		map.put("insertBookOK.do", new InsertBookOKAction());
		map.put("detailBook.do", new DetailBookAction());
		map.put("deleteBook.do", new DeleteBookAction());
		map.put("deleteBookOK.do", new DeleteBookOKAction());
		map.put("updateBook.do", new UpdateBookAction());
		map.put("updateBookOK.do", new UpdateBookOKAction());
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		SistAction action = map.get(cmd);
		String viewPage = action.pro(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
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
