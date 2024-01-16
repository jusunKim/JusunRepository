<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .header {
            background-color: #f2f2f2;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header_nav {
            height: 50px;
            width: 60%;
            display: flex;
            font-size:15px;
            margin: 0 auto; /* 수평 가운데 정렬 */
        }

        .header_nav1, .header_nav2 {
            width: 400px;
            border: 1px solid #c7c7c7;
            background-color: transparent;
            cursor: pointer;
        }

        .header_nav3 {
            width: 500px;
            border: 1px solid #c7c7c7;
            background-color: transparent;
            position: relative;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 10px; 
            cursor: pointer;
        }

        .header_nav1 {
            border-top-left-radius: 30px;
            border-bottom-left-radius: 30px;
        }

        .header_nav3 {
            border-top-right-radius: 30px;
            border-bottom-right-radius: 30px;
        }

        .circle_button {
            background-color: #01d1ca;
            width: 30px;
            height: 30px;
            border-radius: 50%;
            border: none;
            outline: none;
            color: #fff;
            cursor: pointer;
        }

        .header_nav3_text {
            font-size: 15px;
            margin-left: auto;
            margin-right: auto;
        }

        .round-button {
            background-color: deeppink;
            width: 50px; /* Make the button larger */
            height: 50px; /* Make the button larger */
            border-radius: 50%;
            border: none;
            color: white;
            font-size: 16px;
            cursor: pointer;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-left: auto; /* Push the button to the right */
            margin-right: 10px; /* Add some right margin */
        }

        .menu-list {
		    display: none;
		    position: absolute;
		    top: 80px; /* Adjust the top position */
		    right: 10px; /* Adjust the right position */
		    background-color: #fff;
		    padding: 5px;
		    border-radius: 10px;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
		    z-index: 1; /* Ensure the menu appears above other elements */
		}
		
		.menu-list a {
		    display: block;
		    color: #333; /* Dark text color */
		    text-decoration: none;
		    margin-bottom: 10px;
		    padding: 5px;
		    background-color: #f7f7f7; /* Light gray background */
		    border-radius: 5px;
		    transition: background-color 0.3s ease; /* Smooth transition effect */
		}
		
		.menu-list a:hover {
		    background-color: deeppink; /* Hover color - Airbnb turquoise */
		    color: #fff; /* Text color on hover */
		}
    </style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
        function showMenu() {
            $('#menu').toggle();
        }
</script>
</head>
<body>
    <div class="header">
        <div class="header_nav">
            <button class="header_nav1">여행지</button>
            <button class="header_nav2">체크아웃</button>
            <div class="header_nav3">
                <span class="header_nav3_text">인원수</span>
                <button class="circle_button"></button>
            </div>
        </div>
        <c:if test="${userID == null}">
        	<a href="login.do"><b>로그인</b></a>
        </c:if>
        <c:if test="${userID != null}">
            <button class="round-button" onclick="showMenu()"> ${userID } </button>    
            <div id="menu" class="menu-list">
                <a href="userInfo.do"><b>마이페이지</b></a>
                <a href="https://www.example2.com"><b>링크 2</b></a>
                <a href="https://www.example3.com"><b>링크 3</b></a>
                <a href="https://www.example4.com"><b>링크 4</b></a>
                <a href="logoutOK.do"><b>로그아웃</b></a>
            </div>
        </c:if>
    </div>
</body>
</html>
