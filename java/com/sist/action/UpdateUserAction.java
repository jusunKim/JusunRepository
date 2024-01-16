package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.UserDAO;

public class UpdateUserAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listAllUserData.do";
		int uno = 0;
		String u_phone = null;
		String nickname = null;
		uno = Integer.parseInt(request.getParameter("uno"));
		u_phone = request.getParameter("u_phone");
		nickname = request.getParameter("nickname");
		System.out.println(uno+""+u_phone+" "+nickname);
		UserDAO dao = UserDAO.getInstance();
		int re = dao.updateUser(u_phone, nickname, uno);
		if(re!=1) {
			viewPage = "error.jsp";
		}
		return viewPage;
	}

}
