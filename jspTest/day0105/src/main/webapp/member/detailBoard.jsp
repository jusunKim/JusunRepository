<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h2>게시물 상세</h2>
<hr>

글번호: ${b.no } <br>
제목: ${b.title } <br>
작성자: ${b.writer } <br>
내용: <br>
 <textarea rows="10" cols="50" readonly="readonly">${b.content}</textarea><br>
작성일: ${b.regdate }<br>
조회수: ${b.hit }<br>
ip주소: ${b.ip}<br>
첨부파일: ${b.fname }<br>
<hr>
<a href="insertBoard.do?no=${b.no }">답글달기</a>
<a href="listBoard.do">목록으로</a>
</body>
</html>