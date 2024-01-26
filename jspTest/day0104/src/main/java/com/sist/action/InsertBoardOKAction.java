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
		
		int pno = Integer.parseInt(multi.getParameter("no")); //부모글의 글번호
		
		BoardDAO dao = new BoardDAO();
		BoardVO b = new BoardVO();
		int no = dao.getNextNO();
		
		//새글일떄+
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;
		
		//답글일 때
		if(pno!=0) {
			BoardVO pb = dao.findByNO(pno);
			b_ref=pb.getB_ref();
			b_level= pb.getB_level();
			b_step = pb.getB_step();
			dao.updateStep(b_ref, b_step);
			b_level++;
			b_step++;
		}
		
		
		b.setNo(no);
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("content"));
		b.setIp(request.getRemoteAddr());
		b.setFname(multi.getOriginalFileName("uploadFile"));
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		int re = dao.insert(b);
		if(re!=1) {
			viewPage ="error.jsp";
			request.setAttribute("msg", "등록 실패");
		}
		return viewPage;
	}

}
