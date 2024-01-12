<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.ChatVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.ChatDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ChatDAO dao = new ChatDAO();
	ArrayList<ChatVO> list = dao.listChat();
	Gson gson = new Gson();
	
%>

<%=gson.toJson(list)%>