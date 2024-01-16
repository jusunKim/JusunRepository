package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.QnaDAO;
import com.sist.dao.ReviewDAO;

public class DeleteReviewAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listAllReview.do";
		ReviewDAO dao = ReviewDAO.getInstance();
		int reno=0;
		String renoParam = request.getParameter("reno");
		if (renoParam != null && !renoParam.isEmpty()) {
			try {
				reno = Integer.parseInt(renoParam);
			} catch (NumberFormatException e) {
				System.out.println("예외 발생: " + renoParam);
			}
		}
		int re = dao.deleteReview(reno);
		if(re!=1) {
			viewPage = "error.jsp";
		}
		return viewPage;
	}

}
