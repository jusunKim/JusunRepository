package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.ProductDAO;
import com.sist.vo.ProductVO;

public class ListAllProductAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = ProductDAO.getInstance();
		String p_category = null;
		String p_search = null;
		ProductVO p = new ProductVO();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("p_search")!=null) { 
			p_category=(String)session.getAttribute("p_category"); 
			p_search=(String)session.getAttribute("p_search"); 
		}
		
		if(request.getParameter("p_search")!=null) {
			p_category = request.getParameter("p_category");
			p_search = request.getParameter("p_search");
			session.setAttribute("p_category",p_category);
			session.setAttribute("p_search", p_search);
		}
		int pno =0;
		if(request.getParameter("pno")!=null) {
			pno = Integer.parseInt(request.getParameter("pno"));
		}else {
			//System.out.println(rno);
		}
		request.setAttribute("p", dao.detailProduct(pno));
		
		
		ArrayList<ProductVO> list = dao.listAllProduct(p_category, p_search);
		request.setAttribute("list", list);
		return "listAllProduct.jsp";
	}

}
