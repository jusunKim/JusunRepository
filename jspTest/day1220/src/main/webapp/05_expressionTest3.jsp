<%@page import="java.util.Date"%>
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
	Date date = new Date();
	int hour = date.getHours();
	int one = 10;
	int two = 20;
	
%>

<%!
	public int operation(int i, int j){
	return i>j? i:j;
}
%>

<p>지금은 오전일까, 오후일까? <%= (hour<12)?"오전":"오후" %></p>
<p>one과 two 둘 중에 큰 수는? <%=operation(one,two) %></p>
</body>
</html>