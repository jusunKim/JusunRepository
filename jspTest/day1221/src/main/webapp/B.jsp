<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Forward Tag Example2</h1>
<%
	String name = request.getParameter("name");
	String bloodType = request.getParameter("bloodType");
%>
<b><%=name %></b>님의 혈액형은
<b><%=bloodType %></b>형입니다.
규격을 싫어하는 자유인~
</body>
</html>