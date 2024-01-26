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
	BookVO b = new BookVO();
	b.setBookid(100);
	b.setBookname("재미있는자바");
	b.setPrice(30000);
	b.setPublisher("쌍용미디어");
%>
도서번호: <%=b.getBookid() %><br>
도서이름: <%=b.getBookname() %><br>
가격: <%=b.getPrice() %><br>
출판사: <%=b.getPublisher()%>
</body>
</html>