<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서 등록</h2>
<hr>
<form action="insertDept" method="post">
	부서번호: <input type="text" name="dno">
	부서명: <input type="text" name="dname">
	부서위치:<input type="text" name="dloc">
	<input type="submit" value="추가">
	<input type="reset" value="다시 쓰기">
</form>
</body>
</html>