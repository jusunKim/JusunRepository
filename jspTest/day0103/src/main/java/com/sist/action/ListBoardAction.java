package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;

public class ListBoardAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		request.setAttribute("list", dao.findAll());
		return "listBoard.jsp";
	}

}
