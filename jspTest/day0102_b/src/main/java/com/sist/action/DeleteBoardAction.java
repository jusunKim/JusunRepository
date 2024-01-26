package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBoardAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="deleteBoard.jsp";
		int no = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("no", no);
		return viewPage;
	}

}
