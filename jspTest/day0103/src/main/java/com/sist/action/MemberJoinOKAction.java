package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class MemberJoinOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "memberJoinOK.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		MemberVO m = new MemberVO(id, pw, name, email, phone);
		MemberDAO dao = new MemberDAO();
		int re = dao.insert(m);
		if(re!=1) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "회원 가입 실패");
		}
		
		return viewPage;
	}

}
