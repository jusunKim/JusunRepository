package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.BookDAO;

public class ListPublisherAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listPublisher.jsp";
		BookDAO dao = BookDAO.getInstance();
		ArrayList<String> list = dao.listPublisher();
		Gson gson = new Gson();
		String data = gson.toJson(list);
		request.setAttribute("data", data);
		return viewPage;
	}

}
