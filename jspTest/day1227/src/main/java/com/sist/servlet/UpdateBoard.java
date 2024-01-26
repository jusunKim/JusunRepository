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
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class UpdateBoard
 */
@WebServlet("/updateBoard")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        request.setAttribute("no", no);
        String viewPage = "deleteBoard.jsp";
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
		String oldFname =multi.getParameter("fname");
		String fname = multi.getOriginalFileName("uploadFile");
		BoardVO b = new BoardVO();
		b.setNo(Integer.parseInt(multi.getParameter("no")));
		b.setTitle(multi.getParameter("title"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("content"));
		b.setFname(oldFname);
		if(fname!=null) {
			b.setFname(fname);
		}
		
		BoardDAO dao = new BoardDAO();
		int re = dao.update(b);
		String viewPage = "updateBoardOK.jsp";
		if(re==1) {
			if(fname!=null) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물수정실패함...");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
