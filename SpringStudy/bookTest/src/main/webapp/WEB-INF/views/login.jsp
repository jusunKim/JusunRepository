<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<hr>
<form action="/login" method="post">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	아이디: <input name="username"><br>
	패스워드: <input type="password" name="password"><br>
	<input type="submit" value="로그인">
	<input type="reset" value="다시 쓰기">
</form>
</body>
</html>