package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

public class ListEmpAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listEmp.jsp";
		EmpDAO dao = EmpDAO.getInstance();
		String search = null;
		String category = null;
		if(request.getParameter("search")!=null) {
			search = request.getParameter("search");
			category = request.getParameter("category");
		}
		System.out.println(category+" "+search);
		ArrayList<EmpVO> list = dao.listEmp(category, search);
		request.setAttribute("list", list);
		return viewPage;
	}

}
