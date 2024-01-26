package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class UpdateBookOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "updateBookOK.jsp";
		String path = request.getRealPath("data");
		BookDAO dao = new BookDAO();
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		
		BookVO b = new BookVO();
		b.setBookid(Integer.parseInt(multi.getParameter("bookid")));
		b.setPrice(Integer.parseInt(multi.getParameter("price")));
		b.setBookname(multi.getParameter("bookname"));
		b.setPublisher(multi.getParameter("publisher"));
		
		String oldFname = multi.getParameter("fname");
		b.setFname(oldFname);
		
		String fname = multi.getOriginalFileName("uploadFile");
		if(fname!=null) {
			b.setFname(fname);
		}
		
		int re = dao.updateBook(b);
		if(re==1) {
			if(fname!=null && oldFname!=null && !oldFname.equals("")) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}else {
			viewPage="error.jsp";
			request.setAttribute("msg", "수정 실패하였음");
		}
		return viewPage;
	}

}
