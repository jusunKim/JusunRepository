package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.OrdersDAO;

public class ListOrdersAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersDAO dao = OrdersDAO.getInstance();
		ArrayList<HashMap<String, Object>> list = dao.listOrders();
		request.setAttribute("list", list);
		return "listOrders.jsp";
	}

}
