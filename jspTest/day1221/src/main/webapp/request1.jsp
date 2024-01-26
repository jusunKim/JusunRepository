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
	//사용자가 입력한 데이터가 한글일지도 모르니까 한글도 받아올 수 있게 설정
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name"); //사용자가 입력한 이름 받아와 변수에 저장
	//html태그에서 사용자가 입력한 값을 받아 오기 위해 request라는 jsp내장 객체의 geParameter메소드를 이용
	//이때 매개변수로는 html태그의 이름(name)을 써준다. getParameter메소드는 읽어온 데이터를 문자열로 반환한다

	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");
	
	if(gender.equals("man")){
		gender="남자";
	}else{
		gender="여자";
	}
%>
<h1>Request Example1</h1>
성명: <%=name %><br>
학번: <%=studentNum %><br>
성별: <%=gender %><br>
학과: <%=major %>
</body>
</html>