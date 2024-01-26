package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

/**
 * Servlet implementation class ListDept
 */
@WebServlet("/listDept")
public class ListDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptVO> d = dao.listDept();
		
		String data ="";
		data += "<html>";
		data += "<head>";
		data += "<title>무제</title>";
		data += "</head>";
		data += "<body>";
		data += "<table border=1 width='80%'>";
		data += "<tr>";
		data += "<th>부서번호</th>";
		data += "<th>부서명</th>";
		data += "<th>부서위치</th>";
		data += "</tr>";
		for(DeptVO v:d) {
			data += "<tr>";
			data += "<td>"+v.getDno()+"</td>";
			data += "<td>"+v.getDname()+"</td>";
			data += "<td>"+v.getDloc()+"</td>";
			data += "</tr>";
		}
		data += "</table>";
		data += "</body>";
		data += "</html>";
		PrintWriter out  = res.getWriter();
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
