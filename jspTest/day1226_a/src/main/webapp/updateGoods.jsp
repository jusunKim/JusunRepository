<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.sist.dao.GoodsDAO"%>
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
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsDAO dao = new GoodsDAO();
		GoodsVO g = dao.findbyNo(no);
	%>
	<h2>상품 수정</h2>
	<hr>
	<form action="updateGoodsOK.jsp" method="post" enctype="multipart/form-data">
		<table width="80%">	
			<tr>
				<td width="20%">상품이름</td>
				<td width="70%">
					<input type="hidden" name="no" value="<%=g.getNo()%>">
					<input type="text" name="name" required="required"
					value="<%=g.getName()%>">
				</td>
			</tr>
			<tr>
				<td>상품수량</td>
				<td>
					<input type="text" name="qty" required="required"
					value="<%=g.getQty()%>">
				</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td>
					<input type="text" name="price" required="required"
					value="<%=g.getPrice()%>">
				</td>
			</tr>
			<tr>
				<td>상품파일</td>
				<td>
					<input type="hidden" name="fname" value="<%=g.getFname()%>">
					<img src="./upload/<%=g.getFname()%>" width="50" height="50">
					<input type="file" name="uploadFile" >
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="다시 입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>