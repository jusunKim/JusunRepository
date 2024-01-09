package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.GoodsDAO;

public class ListGoodsAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listGoods.jsp";
		GoodsDAO dao = new GoodsDAO();
		HttpSession session = request.getSession();
		int pageNUM = 1;
		if(request.getParameter("pageNUM")!=null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		
		String search = null;
		if(session.getAttribute("search")!=null) {
			search = (String)session.getAttribute("search");
		}
		if(request.getParameter("search")!=null) {
			search = request.getParameter("search");
			if(search.equals("0")) {
				search=null;
			}
			session.setAttribute("search", search);
		}
	request.setAttribute("list", dao.findAll(pageNUM,search));
	request.setAttribute("totalPage", dao.totalPage);
	return viewPage;
}

}
