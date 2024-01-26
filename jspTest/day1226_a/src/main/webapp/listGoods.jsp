<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
	GoodsDAO dao = new GoodsDAO();
	ArrayList<GoodsVO> list =dao.findAll();
%>
<h2>상품 목록</h2>
<hr>
<a href="insertGoods.jsp">상품등록</a>
<br>
<table width="60%" border="1">
	<tr>
		<th>상품번호</th>
		<th>상품이름</th>
	</tr>
	<%
		for(GoodsVO g: list){
			%>
				<tr>
					<td><%=g.getNo() %></td>
					<td>
						<a href="detailGoods.jsp?no=<%= g.getNo()%>"><%=g.getName() %></a>
					</td>
				</tr>
			<%
		}
	
		
	%>
</table>
</body>
</html>