package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class UpdateBoardOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="updateBoardOK.jsp";
		BoardDAO dao = new BoardDAO();
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		String oldFname = multi.getParameter("fname");
		BoardVO b = new BoardVO();
		b.setNo(Integer.parseInt(multi.getParameter("no")));
		b.setTitle(multi.getParameter("title"));
		b.setContent(multi.getParameter("content"));
		b.setPwd(multi.getParameter("pwd"));
		b.setFname(oldFname);
		String fname = multi.getOriginalFileName("uploadFile");
		if(fname!=null) {
			b.setFname(fname);
		}
		int re = dao.update(b);
		if(re==1) {
			if(fname!=null &&oldFname!=null && !oldFname.equals("")) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물수정실패");
		}
		return viewPage;
	}

}
