package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.ReservationDAO;

public class DeleteReservationAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listAllReservation.do";
		ReservationDAO dao = ReservationDAO.getInstance();
		int rno = 0;
		String rnoParam = request.getParameter("rno");
		if (rnoParam != null && !rnoParam.isEmpty()) {
			try {
				rno = Integer.parseInt(rnoParam);
			} catch (NumberFormatException e) {
				System.out.println("예외 발생: " + rnoParam);
			}
		}
		int re = dao.deleteReservation(rno);
		System.out.println(re);
		if(re!=1) {
			viewPage = "error.jsp";
		}
		return viewPage;
	}

}
