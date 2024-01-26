package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BookDAO;

public class ListBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listBook.jsp";
		BookDAO dao = BookDAO.getInstance();
		String search = null; 
		String category = null; 
		String comparing = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("search")!=null) {
			search=(String)session.getAttribute("search");
			category=(String)session.getAttribute("category");		
			comparing = (String)session.getAttribute("comparing");
		}
		
		if(request.getParameter("search")!=null) {
			search = request.getParameter("search");
			
			category = request.getParameter("category");
			if(category.equals("price")) {
				comparing = request.getParameter("op");
			}
			session.setAttribute("search", search);
			session.setAttribute("category", category);
			session.setAttribute("comparing", comparing);
		}
		String column = null;
		if(request.getParameter("column")!=null) {
			column = request.getParameter("column");
		}
//		System.out.println(category+" "+search);
		request.setAttribute("list", dao.findAll(category, comparing, search, column));
		return viewPage;
	}

}
