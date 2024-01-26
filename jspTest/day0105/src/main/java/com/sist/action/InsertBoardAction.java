package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InsertBoardAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = 0; //no에 냅다 초기화를 겟파라미터로 하면 안돼!! 안올수도있잖아!!!
		if(request.getParameter("no")!=null) {
			no = Integer.parseInt(request.getParameter("no"));
		}
		request.setAttribute("no", no);
		return "insertBoard.jsp";
	}

}
