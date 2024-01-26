<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String path = request.getRealPath("upload"); //파일을 업로드할 실제 경로를 알아 온다
	System.out.println("path:"+path);
	request.setCharacterEncoding("utf-8");
	
	MultipartRequest multi = new MultipartRequest(
									request, 
									path, 
									1024*1024*5, 
									"utf-8", 
									new DefaultFileRenamePolicy());
	
	GoodsVO g = new GoodsVO();
	g.setNo(Integer.parseInt(multi.getParameter("no")));
	g.setName(multi.getParameter("name"));
	g.setPrice(Integer.parseInt(multi.getParameter("price")));
	g.setQty(Integer.parseInt(multi.getParameter("qty")));
	g.setFname(multi.getOriginalFileName("uploadFile"));
	
	GoodsDAO dao  = new GoodsDAO();
	int re = dao.insertGoods(g);
	if(re==1){
		out.print("상품등록 성공");
	}
%>

 <hr>
 <a href="insertGoods.jsp">상품등록</a><br>
 <a href="listGoods.jsp">상품목록</a><br>

</body>
</html>