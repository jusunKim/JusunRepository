package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.UserDAO;
import com.sist.vo.UserVO;

public class DetailAllUserAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		int uno=0;
		uno = Integer.parseInt(request.getParameter("uno"));
		UserVO u = dao.listMyData(uno);
		Gson gson = new Gson();
		String data = gson.toJson(u);
		request.setAttribute("u", data);
		return "detailAllUser.jsp";
	}

}
