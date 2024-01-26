package com.sist.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class InsertBoard
 */
@WebServlet("/insertBoard")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "insertBoard.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("data");
		System.out.println("path:"+ path);
		MultipartRequest multi = new MultipartRequest(
										request, 
										path,
										1024*1024*5, 
										"utf-8", 
										new DefaultFileRenamePolicy());
		BoardDAO dao = new BoardDAO();
		int no = dao.getNextNO();
		BoardVO b = new BoardVO();
		b.setNo(no);
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("content"));
		b.setFname(multi.getOriginalFileName("uploadFile"));
		b.setIp(request.getRemoteAddr());
		
		int re = dao.insert(b);
		String viewPage = "insertBookOK.jsp"; //기본으로는 이걸로 해놓고
		if(re!=1) { //등록 실패하면
			viewPage = "error.jsp"; //에러페이지로 해놓고
			request.setAttribute("msg", "게시물 등록에 실패함"); //메시지 속성을 상태유지해놓게
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); //글로 보냄
	}

}
