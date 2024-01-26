package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class insertBoardOK
 */
@WebServlet("/insertBoardOK")
public class insertBoardOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertBoardOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardVO b = new BoardVO();
		b.setTitle(request.getParameter("title"));
		b.setWriter(request.getParameter("writer"));
		b.setContent(request.getParameter("content"));
		b.setIp(request.getRemoteAddr());
		BoardDAO dao = new BoardDAO();
		int re = dao.insertBoard(b);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str = "게시물 등록 완";
		if(re!=1) {
			str="게시물 등록 실패";
		}
		out.print(str);
		out.close();
		
	}

}
