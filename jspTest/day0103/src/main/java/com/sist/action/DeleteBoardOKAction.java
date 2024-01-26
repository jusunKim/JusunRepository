package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class DeleteBoardOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		BoardDAO dao = new BoardDAO();
		BoardVO b =  dao.findByNO(no);
		String oldFname = b.getFname();
		
		String viewPage = "deleteBoardOK.jsp";
		int re = dao.delete(no, pwd);
		if(re==1) {
			if(oldFname!=null && !oldFname.equals("")) {
				String path = request.getRealPath("data");
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
			
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물 삭제 실패함..");
		}
		return viewPage;
	}

}
