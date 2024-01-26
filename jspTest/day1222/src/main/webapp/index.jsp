<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LifeCycle" method="get">
	<input type="submit" value="GET LifeCycle">
</form>
<form action="LifeCycle" method="post">
	<input type="submit" value="POST LifeCycle">
</form>

<hr>
<form method="get" action="hello">
	title: <input type="text" name="title">
	year: <input type="text" name="year">
	<input type="submit" value="get방식의요청">
</form>
<form method="post" action="hello">
	title: <input type="text" name="title">
	year: <input type="text" name="year">
	<input type="submit" value="post방식의요청">
</form>
<a href="hello?title=hello&year=2023">get방식의요청</a>
</body>
</html>