<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="b" class="com.sist.vo.BookVO"/>
<jsp:useBean id="dao" class="com.sist.dao.BookDAO"/>

<jsp:setProperty property="bookid" name="b" value="100"/>
<jsp:setProperty property="bookname" name="b" value="재미있는자바"/>
<jsp:setProperty property="price" name="b" value="30000"/>
<jsp:setProperty property="publisher" name="b" value="쌍용미디어"/>

도서번호: <jsp:getProperty property="bookid" name="b"/><br>
도서이름: <jsp:getProperty property="bookname" name="b"/><br>
가격: <jsp:getProperty property="price" name="b"/><br>
출판사: <jsp:getProperty property="publisher" name="b"/>

<%
	dao.insertBook(b);
%>
</body>
</html>