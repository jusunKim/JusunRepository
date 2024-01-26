package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/myServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String msg = "파이팅코리아";
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("MyServlet2");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>");
		out.print(msg);
		out.print("</h2>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
    


}
