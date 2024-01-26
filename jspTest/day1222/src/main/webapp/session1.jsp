<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id"); //보내준 데서 id를 받아옴
	String pwd = request.getParameter("pwd");
	
	session.setAttribute("idKey", id); //id를 세션에 속성 설정
	session.setMaxInactiveInterval(60*5); //세션의 유효기간을 초단위로 설정.디폴트는 30분
%>
<h1>Session Example1</h1>
<form method="post" action="session1_1.jsp">
	1.가장조아하는계절?<br>
	<input type="radio" value="봄" name="season">봄	
	<input type="radio" value="여름" name="season">여름
	<input type="radio" value="가을" name="season">가을
	<input type="radio" value="겨울" name="season">겨울
	<br>
	2.가장조아하는과일?<br>
	<input type="radio" value="watermelon" name="fruit">수박
	<input type="radio" value="melon" name="fruit">멜론
	<input type="radio" value="apple" name="fruit">사과
	<input type="radio" value="orange" name="fruit">오렌지
	<br>
	<input type="submit" value="결과 보기">
</form>
</body>
</html>