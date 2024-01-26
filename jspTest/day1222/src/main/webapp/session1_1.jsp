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
	String season = request.getParameter("season");
	String fruit = request.getParameter("fruit");
	String id = (String)session.getAttribute("idKey"); //세션에 저장된 값을 읽어와 변수에 저장. 
	String sessionId = session.getId(); //클라이언트(브라우저)가 연결하면 클라이언트 구분을 위한 논리적 연결이이루어지는데 그게 세션. 글고 세션아이디 할당됨
	int intervalTime = session.getMaxInactiveInterval(); //세션의 유효시간을 읽어와 변수에 저장.
	
	if(id!=null){
		%>
		<h1>SESSION EXAMPLE1</h1>
		<b><%=id %></b>님이 좋아하는 계절과 과일은<br>
		<b><%=season %></b>와 <b><%=fruit %></b>입니다.<br>
		세션아이디: <%=sessionId %><br>
		세션 유지 시간: <%=intervalTime %><br>
		<%
	}else{
		out.print("세션의 시간이 지났거나 다른 이유로 연결이 불가합니다");
	}
%>
</body>
</html>