<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>-주문 목록-</h2>
<hr>
<table border="1">
	<tr>
		<th>고객번호</th>
		<th>고객명</th>
		<th>주문도서</th>
	</tr>
	<c:forEach var="o" items="${list }">
		<tr>
			<td>${o.custid }</td>
			<td>${o.name}</td>
			<td>${o.bookname }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>