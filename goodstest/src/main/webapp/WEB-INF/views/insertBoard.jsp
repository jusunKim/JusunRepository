<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 등록</h2>
<hr>
<form action="insertBoard" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${no }">
	제목: <input type="text" name="title"><br>
	작성자: <input type="text" name="writer"><br>
	비밀번호: <input type="password" name="pwd"><br>
	글 내용: 
	<br>
	<textarea rows="10" cols="30" name="content"></textarea><br>
	첨부파일: <input type="file" name="uploadFile"  ><br>
	<input type="submit" value="등록">
	<input type="reset" value="다시쓰기">
</form>
</body>
</html>
