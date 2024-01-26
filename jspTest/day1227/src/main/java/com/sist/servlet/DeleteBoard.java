package com.sist.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class deleteBoard
 */
@WebServlet("/deleteBoard")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoard() {
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
		//1.글번호와 암호를 전달받는다.
		//2.dao를 통해 삭제할 게시물의 정보를 가져와서 파일명 저장해둔다
		//3.dao를 통해 해당 게시물 삭제
		//4.삭제 성공하ㅕㄴ 해당 파일 삭제
		//5.삭제 성공여부에 따라 viewPage를 다르게 해서 이동시킨다
		
		String path = request.getRealPath("data");
		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		BoardDAO dao = new BoardDAO();
		BoardVO b =  dao.findByNO(no);
		String fname = b.getFname();
		String viewPage = "deleteBoardOK.jsp";
		int re = dao.delete(no, pwd);
		if(re==1) {
			if(fname!=null && !fname.equals("")) {
				File file = new File(path+"/"+fname);
				file.delete();
			}
			
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물 삭제 실패함..");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
