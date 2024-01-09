<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 가입~</h2>
<hr>
<form action="memberJoinOK.do" method="post">
ID: <input type="text" name="id" required="required"><br>
PW: <input type="password" name="pw" required="required"><br>
이름: <input type="text" name="name" required="required"><br>
이메일: <input type="text" name="email" required="required"><br>
전화번호: <input type="text" name="phone" required="required"><br>
<input type="submit" value="회원가입">
<input type="reset" value="다시 쓰기">
</form>
</body>
</html>