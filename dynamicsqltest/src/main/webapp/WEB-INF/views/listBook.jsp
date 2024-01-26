<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서목록</h2>
<hr>
<form action="listBook" >
	<select name="category">
		<option value="bookname">도서명</option>
		<option value="publisher">출판사</option>
	</select>
	<input type="search" name="search">
	<input type="submit" value="찾기">
</form>
<table border="1" width="80%">
	<tr>
		<th><a href="listBook?sColumn=bookid">도서번호</a></th>
		<th><a href="listBook?sColumn=bookname">도서명</a></th>
		<th><a href="listBook?sColumn=price">가격</a></th>
		<th><a href="listBook?sColumn=publisher">출판사</a></th>
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