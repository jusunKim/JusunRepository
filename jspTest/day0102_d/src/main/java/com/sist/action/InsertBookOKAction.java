package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class InsertBookOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "insertBookOK.jsp";
		String path = request.getRealPath("data");
		System.out.println(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		int bookid = Integer.parseInt( multi.getParameter("bookid"));
		String bookname = multi.getParameter("bookname");
		int price = Integer.parseInt(multi.getParameter("price"));
		String publisher = multi.getParameter("publisher");
		String fname = multi.getOriginalFileName("uploadFile");
		BookVO b = new BookVO();
		b.setBookid(bookid); //윗 덩어리랑 합치는 게 나앗겟군..
		b.setBookname(bookname);
		b.setPrice(price);
		b.setPublisher(publisher);
		b.setFname(fname);
		BookDAO dao = new BookDAO();
		int re = dao.insertBook(b);
		if(re!=1) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "책 등록 실패함");
		}
		return viewPage;
	}

}
