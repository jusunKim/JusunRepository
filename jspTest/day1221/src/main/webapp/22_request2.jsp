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
	String protocol = request.getProtocol(); //프로토콜(통신규약)읽어오기
	String serverName = request.getServerName(); //서버이름 읽어오기
	int port = request.getServerPort(); //포트번호 읽어오기. 정수 반환
	String remoteAddr = request.getRemoteAddr(); //요청한 클라이언트의 ip주소
	String remoteHost = request.getRemoteHost(); //사용자 컴퓨터의 이름을 읽어옴
	String method = request.getMethod(); //서비스 요청방식을 읽어오기
	StringBuffer requestURL = request.getRequestURL(); //클라이언트가 웹브라우저에 입력한 주소표시줄의 내용을 http부터 모두 읽어옴
	String requestURI = request.getRequestURI(); //클라이언트가 웹브라우저에 입력한 주소표시줄의 내용 중 컨텍스트명부터 읽어옴
	String userBrowser = request.getHeader("User-Agent"); //클라이언트가 접속한 웹브라우저 정보 읽어옴
	String fileType = request.getHeader("Accept"); //클라이언트가 접속한 웹브라우저가 지원가능한 파일타입 모두 읽어옴
%>

<h1>Request Example2</h1>
프로토콜: <%=protocol %><br>
서버이름: <%=serverName %><br>
서버의 포트번호: <%=port%><br>
사용자 컴퓨터의 주소: <%=remoteAddr%><br>
사용자 컴퓨터의 이름: <%=remoteHost%><br>
요청 방식: <%=method%><br>
요청 경로(URL): <%=requestURL%><br>
요청 경로(URI): <%=requestURI%><br>
요청한 클라이언트의 브라우저: <%=userBrowser%><br>
브라우저가 지원하는 파일 형식: <%=fileType%><br>
</body>
</html>