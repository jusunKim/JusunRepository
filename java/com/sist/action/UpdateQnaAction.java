package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.QnaDAO;

public class UpdateQnaAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listAllQna.do";
		QnaDAO dao = QnaDAO.getInstance();
		String a_content = null;
		int qno=0;
		String qnoParam = request.getParameter("qno");
		if (qnoParam != null && !qnoParam.isEmpty()) {
			try {
				qno = Integer.parseInt(qnoParam);
				a_content = request.getParameter("a_content");
			} catch (NumberFormatException e) {
				System.out.println("Invalid qno parameter: " + qnoParam);
			}
		}
		int re = dao.updateQna(a_content, qno);
		if(re!=1) {
			viewPage = "error.jsp";
		}
		return viewPage;
	}

}
