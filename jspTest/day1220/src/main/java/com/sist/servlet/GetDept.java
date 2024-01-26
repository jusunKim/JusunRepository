package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

/**
 * Servlet implementation class GetDept
 */
@WebServlet("/getDept")
public class GetDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dno= Integer.parseInt(request.getParameter("dno"));
		DeptDAO dao = new DeptDAO();
		DeptVO d = dao.findByDno(dno);
		Gson gson = new Gson();
		String data = gson.toJson(d);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(data);
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
