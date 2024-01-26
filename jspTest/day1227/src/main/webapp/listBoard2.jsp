<%@page import="com.sist.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("list");
%>

<h2>게시물 목록</h2>
<hr>
<table border="1" width="80%">
	<tr>
		<th width="10%">글번호</th>
		<th width="80%">제목</th>
		<th width="10%">작성자</th>
	</tr>
	<%
		for(BoardVO b:list){
			%>
			<tr>
				<td><%=b.getNo()%></td>
				<td><%=b.getTitle() %></td>
				<td><%=b.getWriter() %></td>
			</tr>
			<%
		}
	%>
</table>
</body>
</html>