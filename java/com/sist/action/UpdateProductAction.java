package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.ProductDAO;
import com.sist.vo.ProductVO;

public class UpdateProductAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listAllProduct.do";
		int pno=0;
		ProductVO p = new ProductVO();
		pno = Integer.parseInt(request.getParameter("pno"));
		String p_phone = request.getParameter("p_phone");
		int occ_max = Integer.parseInt(request.getParameter("occ_max"));
		int price = Integer.parseInt(request.getParameter("price"));
		p.setPno(pno);
		p.setP_phone(p_phone);
		p.setOcc_max(occ_max);
		p.setPrice(price);
		ProductDAO dao = ProductDAO.getInstance();
		int re = dao.updateProduct(p);
		if(re!=1) {
			viewPage = "error.jsp";
		}
		return viewPage;
	}

}
