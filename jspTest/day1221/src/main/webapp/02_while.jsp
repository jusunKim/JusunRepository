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
	//사용자가 입력한 데이터가 한글일 수도 있으니까 한글 받아올 수 있게 인코딩 설정
	request.setCharacterEncoding("utf-8");

	//사용자가 입력한 msg를 받아와 변수에 저장
	String msg = request.getParameter("msg");
	
	//사용자가 입력한 number를 ㄹ정수형으로 변환해 변수에 저장
	int number = Integer.parseInt(request.getParameter("number"));
	
	//사용자가 입력한 number만큼 while반복문에 사용할 변수 선언. 0으로 초기화
	int count=0;
	
	//count가 number보다 작을 동안 반복문 실행
	while(count<number){
		out.print(msg+"<br>"); //out내장객체를 이용해 브라우저에 msg를 출력
		count++; //다음 반복문 위해 count증가.
	}
%>
</body>
</html>