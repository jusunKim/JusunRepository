package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.ReviewDAO;

public class ListAllReviewAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO dao = ReviewDAO.getInstance();
		String category = null;
		String search = null;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("search")!=null) { 
			category=(String)session.getAttribute("category"); 
			search=(String)session.getAttribute("search"); 
		}
		if(request.getParameter("search")!=null) {
			category = request.getParameter("category");
			search = request.getParameter("search");
			session.setAttribute("category",category);
			session.setAttribute("search", search);
		}
		request.setAttribute("list", dao.listAllReview(category, search));
		
		int reno=1;
		if(request.getParameter("reno")!=null) {
			reno = Integer.parseInt(request.getParameter("reno"));
		}
		request.setAttribute("map", dao.detailAllReview(reno)); 
		return "listAllReview.jsp";
	}

}
