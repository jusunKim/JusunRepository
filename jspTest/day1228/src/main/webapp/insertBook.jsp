<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서 등록~</h2>
<hr>
<form action="insertBook.do" method="post"  enctype="multipart/form-data">
	도서번호: <input type="number" name="bookid" required="required"><br>
	도서명: <input type="text" name="bookname" required="required"><br>
	가격: <input type="number" name="price" required="required"><br>
	출판사: <input type="text" name="publisher" required="required"><br>
	파일:<br>
	<input type="file" name="uploadFile"><br>
	<input type="submit" value="등록">
	<input type="reset" value="다시 입력">
</form>
</body>
</html>