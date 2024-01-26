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
import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

/**
 * Servlet implementation class InsertBook
 */
@WebServlet("/insertBook.do")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "insertBook.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("data");
		System.out.println("path:"+path);
		MultipartRequest multi = new MultipartRequest(request, path,1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		int bookid = Integer.parseInt(multi.getParameter("bookid"));
		String bookname = multi.getParameter("bookname");
		int price = Integer.parseInt(multi.getParameter("price"));
		String publisher = multi.getParameter("publisher");
		String fname = multi.getOriginalFileName("uploadFile");
		BookVO b = new BookVO(bookid, bookname, price, publisher, fname);
		
		BookDAO dao = new BookDAO();
		int re = dao.insertBook(b);
		String viewPage = "insertBookOK.jsp";
		if(re!=1) {
			viewPage= "error.jsp";
			request.setAttribute("msg", "도서 등록에 실패했습니다,,,");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
