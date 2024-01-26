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
	String[] name = {"Java","JSP","Android","Struts"};
%>
<table border=1 width="200">
	<%
		for(int i=0; i<name.length;i++){
			out.print("<tr>");
			out.print("<td>"+i+"</td>");
			out.print("<td>"+name[i]+"</td>");
			out.print("</tr>");
		}
	%>
</table>
</body>
</html>