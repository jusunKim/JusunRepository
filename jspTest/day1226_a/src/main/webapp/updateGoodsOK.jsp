<%@page import="java.io.File"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("upload");
	
	MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
	
	GoodsVO g = new GoodsVO();
	g.setNo(Integer.parseInt(multi.getParameter("no")));
	g.setName(multi.getParameter("name"));
	g.setQty(Integer.parseInt(multi.getParameter("qty")));
	g.setPrice(Integer.parseInt(multi.getParameter("price")));
	String oldFname = multi.getParameter("fname");
	String fname = multi.getOriginalFileName("uploadFile");
	
	g.setFname(oldFname); //일단은 원래 사진이름을 VO에 저장
	
	
	//만약 사진도 수정한다면 VO에 수정하려는 파일 이름 저장하기
	if(fname!=null){
		g.setFname(fname);
		
	}
	GoodsDAO dao = new GoodsDAO();
	int re = dao.updateGoods(g);
	if(re==1){
		if(fname!=null){ //수정에 성공햇고 사진도 수정햇다면
			File file = new File(path+"/"+oldFname); //옛날 사진 지우려고 객체 생성
			file.delete();
		}
		out.print("상품 수정 성공");
	}else{
		out.print("상품 수정 실패");
	}
	
	
%>
<a href="listGoods.jsp">상품목록</a>
</body>
</html>