<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<c:if test="${idKey ==null}">
	<a href="login.do">로그인</a>
	</c:if>
	<c:if test="${idKey !=null}">
	${idKey }님 환영합니다~~~<br>
	<a href="/day0105/logout.do">로그아웃</a>&nbsp;
	<a href="/day0105/member/listBoard.do?writer=${idKey }">내글보기</a>
	</c:if>
	&nbsp;
	<a href="/day0105/member/listBoard.do?writer=0">게시물 목록</a>
</body>
</html>