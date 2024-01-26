<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 삭제</h2>
	<form action="deleteBoardOK.do" method="post">
		글 암호를 입력하세요
		<input type="hidden" name="no" value="${no }">
		<input type="password" name="pwd">
		<input type="submit" value="삭제">
	</form>
</body>
</html>