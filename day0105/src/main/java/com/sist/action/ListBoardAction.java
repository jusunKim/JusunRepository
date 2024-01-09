package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BoardDAO;

public class ListBoardAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int pageNUM = 1;
		if(request.getParameter("pageNUM")!=null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		
		String writer=null;
		if(session.getAttribute("writer")!=null) { //세션에 상태유지된 writer가 있나?
			writer = (String)session.getAttribute("writer");
			
		}
		if(request.getParameter("writer")!=null) { //전달받은 값이 있나?
			writer=request.getParameter("writer");
			if(writer.equals("0")) {
				writer=null;
			}
			session.setAttribute("writer", writer);
		}
		String viewPage="listBoard.jsp";
		BoardDAO dao = new BoardDAO();
		request.setAttribute("list", dao.findAll(pageNUM, writer));
		request.setAttribute("totalPage", dao.totalPage);
		
		return viewPage;
	}

}
