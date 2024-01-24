<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>책 리스트</h2>
<hr>
<table>
	<tr>
		<th>책번호</th>
		<th>책이름</th>
		<th>가격</th>
		<th>출판사</th>
	</tr>
	<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.bookid }</td>
			<td>${b.bookname }</td>
			<td>${b.price }</td>
			<td>${b.publisher }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>