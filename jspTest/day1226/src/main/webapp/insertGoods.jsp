<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품 등록</h2>
	<hr>
	<form action="insertGoodsOK.jsp" method="post">
		<table width="80%">
			<tr>
				<td width="20%">상품번호</td>
				<td width="70%">
					<input type="text" name="no" required="required">
				</td>
			</tr>

			<tr>
				<td>상품이름</td>
				<td>
					<input type="text" name="name" required="required">
				</td>
			</tr>
			<tr>
				<td>상품수량</td>
				<td>
					<input type="text" name="qty" required="required">
				</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td>
					<input type="text" name="price" required="required">
				</td>
			</tr>
			<tr>
				<td>상품파일</td>
				<td>
					<input type="text" name="fname" required="required">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="다시 입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>