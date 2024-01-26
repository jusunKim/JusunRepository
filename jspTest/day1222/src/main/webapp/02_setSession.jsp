<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
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
	String title = "Hello JSP!";
	int year = 2024;
	int[] data = {10,20,30};
	DeptVO d = new DeptVO(10,"개발1팀","판교");
	
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> list = dao.listBook();
	
	session.setAttribute("title", title);
	session.setAttribute("year", year);
	session.setAttribute("data", data);
	session.setAttribute("d", d);
	session.setAttribute("list", list);
%>
세션변수에 값을 저장햇ㅅ슴니다.
<hr>
<a href="getSession.jsp">세샨변수값확인하러가기</a>
</body>
</html>