<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" 
	buffer="16kb" 
	autoFlush="true"
 	isThreadSafe="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date date = new Date();
%>
현재 날자와 시간은?<br>
<%=date.toLocaleString() %>
</body>
</html>