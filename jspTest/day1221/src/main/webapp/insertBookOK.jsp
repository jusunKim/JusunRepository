<%@page import="com.sist.dao.BookDAO"%>
<%@page import="com.sist.vo.BookVO"%>
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
		BookVO b = new BookVO();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String bookname = request.getParameter("bookname");
		int price = Integer.parseInt(request.getParameter("price"));
		String publisher= request.getParameter("publisher");
		b.setBookid(bookid);
		b.setBookname(bookname);
		b.setPrice(price);
		b.setPublisher(publisher);
		BookDAO dao = new BookDAO();
		dao.insertBook(b);
		
	%>
	OK
</body>
</html>