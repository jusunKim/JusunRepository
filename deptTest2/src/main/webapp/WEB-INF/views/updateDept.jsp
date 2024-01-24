<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서 수정</h2>
<hr>
<form action="updateDept" method="post">
	부서번호: <input type="text" name="dno" value="${d.dno }"><br>
	부서명: <input type="text" name="dname" value="${d.dname }"><br>
	부서위치:<input type="text" name="dloc" value="${d.dloc }"><br>
	<input type="submit" value="수정하기">
	<input type="reset" value="다시 쓰기">
</form>
</body>
</html>