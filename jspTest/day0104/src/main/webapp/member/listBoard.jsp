<%@page import="com.sist.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
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

<h2>게시물 목록</h2>
<hr>
<a href="insertBoard.do">글 등록</a>
<table border="1" width="80%">
	<tr>
		<th width="10%">글번호</th>
		<th width="70%">제목</th>
		<th width="20%">작성자</th>
	</tr>
	<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.no}</td>
			
			<td>
			<c:if test="${b.b_level>0 }">
				<c:forEach var="i" begin="1" end="${b.b_level }">
					&nbsp;&nbsp;
				</c:forEach>
				<img src="re.png">
			</c:if>
			<a href="detailBoard.do?no=${b.no}">${b.title }</a></td>
			<td>${b.writer }</td>
		</tr>
	</c:forEach>
</table>

<c:forEach var="i" begin="1" end="${totalPage}">
	<a href="listBoard.do?pageNUM=${i }">${i }</a>
</c:forEach>

</body>
</html>