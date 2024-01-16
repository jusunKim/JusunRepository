package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.QnaDAO;

public class ListAllQnaAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnaDAO dao = QnaDAO.getInstance();
		String search = null;
		int qno=0;
		int answered = 1;
		HttpSession session = request.getSession();
		if(session.getAttribute("search")!=null) { 
			search=(String)session.getAttribute("search"); 
		}

		if(request.getParameter("search")!=null) {
			search = request.getParameter("search");
			session.setAttribute("search", search);

		}
		if(session.getAttribute("answered")!=null) {
			answered=(Integer)session.getAttribute("answered");
		}
		if(request.getParameter("answered")!=null) {
			answered=Integer.parseInt(request.getParameter("answered"));
			session.setAttribute("answered", answered);
		}
		
		if(request.getParameter("qno")!=null) {
			qno = Integer.parseInt(request.getParameter("qno"));
		}
		request.setAttribute("nlist", dao.listAllQna(answered, search));
		request.setAttribute("q", dao.detailAllQna(qno) );

		return "listAllQna.jsp";
	}

}
