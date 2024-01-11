<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<c:forEach var="v" items="${ list}">
	<tr>
		<td>${v.imgno }</td>
		<td>${v.img1}</td>
		<td>${v.img2 }</td>
		<td>${v.img3 }</td>
		<td>${v.img4 }</td>
		<td>${v.img5}</td>
		<td>${v.pno}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>