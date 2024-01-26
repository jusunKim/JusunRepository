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
		//문자열 변수 name을 선언합니다
		String name = "korea";
		int year= 2024;
		String title="hello";
	%>
	<!-- 이건 html 주석임.. 소스보기 하면 보임. -->
	<%-- 
		이건 jsp 주석임. 소스보기 하면 안보임 
	--%>
	
	<%=name /*name변수의 내용을 출력합니다*/ %>
	<hr>
	<%-- <%= year%> --%>
	 <!-- <%=title %>  --> 
	 <!-- <h2>Hello</h2>  --> 
</body>
</html>