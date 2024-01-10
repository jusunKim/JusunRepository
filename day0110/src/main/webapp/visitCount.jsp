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
	int count = 0;

	Cookie[] cookies = request.getCookies(); //쿠키만들기
	if(cookies!=null){ //
		for(Cookie c:cookies){
			String name = c.getName();
			if(name.equals("visitCount")){
				count = Integer.parseInt(c.getValue());
			}
		}
	}
	count ++;
	
	out.print(count+"번쨰 방문입니다");
	Cookie cookie = new Cookie("visitCount",count+"");
	response.addCookie(cookie);
	
%>
</body>
</html>