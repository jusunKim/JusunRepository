<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String title = "쌍용강북교육센터";
	int age = 20;
	/*if(age==20){
		title="OK";
	} 선언문 안에는 if문같은거못온다고*/
	public int addData(int data){
		return data+1;
	}
	
%>
<%
	String result = "hello";
	int year = 2023;
	if(year==2023){
		result = "hello 2023";
	}
%>
result: <%=result %><br>
year: <%=year %><br>
title: <%=title%><br>
age: <%=age%><br>
<hr>
addData(age): <%= addData(age)%><br>
addData(year): <%= addData(year)%><br>
</body>
</html>