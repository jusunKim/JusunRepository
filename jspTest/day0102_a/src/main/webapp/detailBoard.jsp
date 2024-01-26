<%@page import="com.sist.vo.BoardVO"%>
<%@page import="com.sist.dao.BoardDAO"%>
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
글번호 : ${b.no }<br>
글제목: ${b.title }<br>
작성자: ${b.writer }<br>
글 내용: <br>
<textarea rows="10" cols="50" readonly="readonly">${b.content }</textarea>
 <br>
조회수: ${b.hit }<br>
등록일: ${b.regdate }<br>
첨부파일: ${b.fname }<br>
<hr>
<a href="insertBoard.do">글등록</a> &nbsp;
<a href="listBoard.do">글목록</a> &nbsp;
<a href="updateBoard.do?no=${b.no }">글수정</a> &nbsp;
<a href="deleteBoard.do?no=${b.no }">글삭제</a> 
</body>
</html>