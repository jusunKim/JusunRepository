<%@page import="java.io.File"%>
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
GoodsDAO dao = new GoodsDAO();
int no = Integer.parseInt(request.getParameter("no"));
String fname = dao.findbyNo(no).getFname();
int re = dao.deleteGoods(no);

if(re==1){
	String path = request.getRealPath("upload");
	File file = new File(path+"/"+fname);
	file.delete();
	out.print("삭제 성공");
}else{
	out.print("삭제 실패..");
}
%>
<hr>
 <a href="insertGoods.jsp">상품등록</a><br>
 <a href="listGoods.jsp">상품목록</a><br>
</body>
</html>