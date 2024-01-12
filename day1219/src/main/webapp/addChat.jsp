<%@page import="com.sist.vo.ChatVO"%>
<%@page import="com.sist.dao.ChatDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name =  request.getParameter("name");
	String msg = request.getParameter("msg");

	ChatDAO dao = new ChatDAO();
	int re = dao.insertChat(new ChatVO(name, msg));
%>

{"msg":"<%=re%>"}