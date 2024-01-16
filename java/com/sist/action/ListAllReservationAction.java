package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.ReservationDAO;
import com.sist.dao.UserDAO;

public class ListAllReservationAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HashMap<String, Object>> r =null;
		ReservationDAO dao = ReservationDAO.getInstance();
		String r_category = null;
		String r_search = null;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("r_search")!=null) { 
			r_category=(String)session.getAttribute("r_category"); 
			r_search=(String)session.getAttribute("r_search"); 
		}
		
		if(request.getParameter("r_search")!=null  ) {
			r_category = request.getParameter("r_category");
			r_search = request.getParameter("r_search");
			session.setAttribute("r_category",r_category);
			session.setAttribute("r_search", r_search);
		}
		System.out.println(r_category+" "+r_search);
		int rno =0;
		if(request.getParameter("rno")!=null) {
			rno = Integer.parseInt(request.getParameter("rno"));
		}else {
			//System.out.println(rno);
		}
		request.setAttribute("r", dao.detailAllReservation(rno));
		
		ArrayList<HashMap<String, Object>> list = dao.listAllReservation(r_category, r_search);
		request.setAttribute("list",list);
		return "listAllReservation.jsp";
	}

}
