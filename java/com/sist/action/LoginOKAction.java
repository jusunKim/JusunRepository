package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.UserDAO;

public class LoginOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "template.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//id (email)에서 앞의 글씨만 뽑아와 변수에 저
		String[] parts = id.split("@");
        String username = parts[0];

		
		UserDAO dao = UserDAO.getInstance();
		if(dao.login(id, pwd) == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userID", username);
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "로그인에 실패하였습니다.");
		}
		return viewPage;
	}

}
