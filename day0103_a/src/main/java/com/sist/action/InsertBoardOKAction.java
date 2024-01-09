package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class InsertBoardOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "insertBoardOK.jsp";
		String path  = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		BoardDAO dao = new BoardDAO();
		BoardVO b = new BoardVO();
		b.setNo(dao.getNextNO());
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("context"));
		b.setIp(request.getRemoteAddr());
		b.setFname(multi.getOriginalFileName("uploadFile"));
		int re = dao.insert(b);
		if(re!=1) {
			viewPage ="error.jsp";
			request.setAttribute("msg", "등록 실패");
		}
		return viewPage;
	}

}
