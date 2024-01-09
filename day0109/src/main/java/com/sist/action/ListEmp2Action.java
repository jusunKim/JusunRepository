package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;

public class ListEmp2Action implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		request.setAttribute("list", dao.findAllEmp());
		System.out.println(dao.findAllEmp());
		return "listEmp2.jsp";
	}

}
