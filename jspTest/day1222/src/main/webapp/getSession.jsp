<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.DeptVO"%>
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
	String title= (String)session.getAttribute("title");
	int year = (Integer)session.getAttribute("year");
	//Integer[] data = (Integer[])session.getAttribute("data");
	DeptVO d= (DeptVO)session.getAttribute("d");
	ArrayList<BookVO> list = (ArrayList<BookVO>)session.getAttribute("list"); 
%>
<h2>세션 변수에 저장한 값 확인하기</h2>
<hr>
title: <%=title %><br>
year: <%=year%><br>
data: <%
	//for(int v:data){
	//	out.print(v+" ");
	//}
%><br>
<hr>
부서번호: <%=d.getDno() %><br>
부서명: <%=d.getDname() %><br>
부서위치: <%=d.getDloc() %><br>
<hr>
<h2>도서목록</h2>
<%
	for(BookVO b:list){
		%>
		도서번호: <%=b.getBookid() %><br>
		도서명: <%=b.getBookname() %><br>
		가격: <%=b.getPrice() %><br>
		가격: <%=b.getPublisher() %><br>
		<%
	}
%>
</body>
</html>