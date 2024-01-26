<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서 수정~</h2>
<hr>
<form action="updateBookOK.do" method="post" enctype="multipart/form-data">
	도서번호: ${b.bookid }<br>
	<input type="hidden" name="bookid" value="${b.bookid }" >
	도서명: <input type="text" name="bookname" value="${b.bookname }" required="required"><br>
	가격: <input type="number" name="price" value="${b.price }" required="required"><br>
	출판사: <input type="text" name="publisher" value="${b.publisher }" required="required"><br>
	<img src="./data/${b.fname }" width="100" height="100">
	도서 사진: <input type="file" name="uploadFile">
	<input type="hidden" value="${b.fname }">
	<input type="submit" value="수정">
	<input type="reset" value="다시입력">
</form>
</body>
</html>