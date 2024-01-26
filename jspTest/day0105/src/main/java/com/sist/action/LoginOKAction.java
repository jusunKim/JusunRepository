package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MemberDAO;

public class LoginOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String viewPage = "loginOK.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		if(dao.isMember(id, pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("idKey", id);
			
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "로그인 실패");
		}
		return viewPage;
	}
}
