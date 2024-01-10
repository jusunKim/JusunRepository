package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.EmpDAO;

public class ListDnoAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listDno.jsp";
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<Integer> list = dao.listDno();
		Gson gson = new Gson();
		String data = gson.toJson(list);
		request.setAttribute("data",data ); 
		return viewPage;
	}

}
