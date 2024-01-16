package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.UserDAO;
import com.sist.vo.UserVO;

public class ListAllUserDataAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		String category = null;
		String search = null;
		UserVO u = new UserVO();
		HttpSession session = request.getSession();
		if(session.getAttribute("u_search")!=null) { 
			category=(String)session.getAttribute("u_category"); 
			search=(String)session.getAttribute("u_search"); 
		}
		
		if(request.getParameter("u_search")!=null ) {	
			if(!request.getParameter("u_search").equals("")) {
				category = request.getParameter("u_category");
				search = request.getParameter("u_search");
				session.setAttribute("u_category",category);
				session.setAttribute("u_search", search);
			}else {
				session.setAttribute("u_category",null);
				session.setAttribute("u_search", null);
			}
		}
		System.out.println(search+" "+category);
		
		int uno = 0;
		if(request.getParameter("uno")!=null) {
			uno = Integer.parseInt(request.getParameter("uno")) ;
			 u = dao.listMyData(uno);
		}
		request.setAttribute("u", u);
		
		ArrayList<UserVO> list = dao.listAllUserData(category, search);
		request.setAttribute("list",list);
		return "listAllUserData.jsp";
	}
}
