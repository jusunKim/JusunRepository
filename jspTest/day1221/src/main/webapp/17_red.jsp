<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="red">
	<h1>red입니다.</h1>
	<%
		response.sendRedirect("yellow.jsp");
	%>
</body>
</html>