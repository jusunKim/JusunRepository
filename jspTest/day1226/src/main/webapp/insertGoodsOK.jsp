<%@page import="com.sist.dao.GoodsDAO"%>
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
%>
 <jsp:useBean id="goods" class="com.sist.vo.GoodsVO"/>
 <jsp:useBean id="dao" class="com.sist.dao.GoodsDAO"/>
 <jsp:setProperty property="*" name="goods"/>
 <%
 	
 	
 	int re = dao.insertGoods(goods);
 	if(re==1){
 		out.print("상품 등록 성공");
 	}else{
 		out.print("실패");
 	}
 %>
 <br>
 <a href="insertGoods.jsp">상품등록</a><br>
 <a href="listGoods.jsp">상품목록</a><br>

</body>
</html>