<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
	Context initContext = new InitialContext();
	DataSource ds = (DataSource)initContext.lookup("java:/comp/env/myoracle");
	Connection conn = ds.getConnection();
%>
connection: <%=conn %>
</body>
</html>