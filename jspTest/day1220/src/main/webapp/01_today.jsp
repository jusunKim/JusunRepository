
<%@page import="java.text.SimpleDateFormat"%>
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
	Date today = new Date();
/*	int year = today.getYear()+1900;
	int month = today.getMonth()+1;
	int date = today.getDate();
	String strDate = year+"-"+month+"-"+date;
	*/
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String strDate = format.format(today);
%>
오늘 날짜는 <%=strDate%>
</body>
</html>