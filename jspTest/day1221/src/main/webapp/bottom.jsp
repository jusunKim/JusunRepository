<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date date = new Date();
%>
include 지시자의 Bottom 부분입니다<br>
<%=date.toLocaleString() %>
</body>
</html>