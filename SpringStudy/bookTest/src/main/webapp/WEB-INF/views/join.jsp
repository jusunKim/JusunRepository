<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입</h2>
	<hr>
	<form action="/join" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		아이디: <input name="id"><br>	
		비밀번호: <input type="password" name="pwd"><br>	
		이름: <input name="name"><br>	
		<input type="submit" value="가입">
		<input type="reset" value="다시입력">
	</form>
</body>
</html>