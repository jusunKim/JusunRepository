package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.UserDAO;

public class DeleteUserAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listAllUserData.do";
		int uno = 0;
		uno = Integer.parseInt(request.getParameter("uno"));
		UserDAO dao = UserDAO.getInstance();
		int re = dao.deleteUser(uno);
		if(re!=1) {
			viewPage = "error.jsp";
		}
		return viewPage;
	
	}

}
