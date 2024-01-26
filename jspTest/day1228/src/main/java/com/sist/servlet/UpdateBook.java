package com.sist.servlet;

import java.io.File;
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
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook.do")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookVO b =  dao.findByBookid(bookid);
		request.setAttribute("b", b);
		String viewPage = "updateBook.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		
		BookVO b = new BookVO();
		b.setBookid(Integer.parseInt(multi.getParameter("bookid")));
		b.setPrice(Integer.parseInt(multi.getParameter("price")));
		b.setBookname(multi.getParameter("bookname"));
		b.setPublisher(multi.getParameter("publisher"));
		
		String oldFname = multi.getParameter("fname");
		b.setFname(oldFname);
		
		String fname = multi.getOriginalFileName("uploadFile");
		if(fname != null) {
			b.setFname(fname);
		}
				
		BookDAO dao = new BookDAO();
		int re = dao.updateBook(b);
		String viewPage = "updateBookOK.jsp";
		if(re != 1) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "도서수정에 실패하였습니다.");
		}else {
			if(fname != null && oldFname != null && !oldFname.equals("")) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
		}
		
		RequestDispatcher dispatcher = 
		request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
