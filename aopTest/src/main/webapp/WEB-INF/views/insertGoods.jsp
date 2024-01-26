<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품등록</h2>
<hr>
<form action="insertGoods" method="post" enctype="multipart/form-data">
	상품번호: <input type="number" name="no" value="${nno }"><br>
	상품이름: <input type="text" name="name"><br>
	상품가격: <input type="number" name="price"><br>
	상품수량: <input type="number" name="qty"><br>
	상품사진: <input type="file" name="uploadFile"><br>
	<input type="submit" value="등록">
	<input type="reset" value="다시 입력">
</form>
</body>
</html>