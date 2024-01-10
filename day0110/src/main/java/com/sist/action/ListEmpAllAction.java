package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;

public class ListEmpAllAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		String search = null;
		String category = null;
		if(request.getParameter("search")!=null) {
			search=request.getParameter("search");
			category = request.getParameter("category");
		}
		request.setAttribute("list", dao.findAllEmp(category, search));
		System.out.println(category+" "+search);
		return "listEmpAll.jsp";
	}

}
