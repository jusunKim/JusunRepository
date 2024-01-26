<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 상세</h2>
<hr>
게시물 번호: ${b.no } <br>
제목: ${b.title } <br>
작성자: ${b.writer } <br>
내용: <br>
<textarea rows="10" cols="30" readonly="readonly">${b.content }</textarea> <br>
작성일: ${b.regdate } <br>
조회수: ${b.hit } <br>
파일명: ${b.fname } <br>
<img src="./upload/${b.fname }" width="100" height="100"><br>
IP:${b.ip }
<hr>
<a href="insertBoard?no=${b.no }">답글쓰기</a>
</body>
</html>