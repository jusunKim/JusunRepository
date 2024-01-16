package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.ProductDAO;

public class DeleteProductAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listAllProduct.do";
		int pno = 0;
		pno = Integer.parseInt(request.getParameter("pno"));
		ProductDAO dao = ProductDAO.getInstance();
		int re = dao.deleteProduct(pno);
		if(re!=1) {
			viewPage = "error.jsp";
		}
		return viewPage;
	}

}
