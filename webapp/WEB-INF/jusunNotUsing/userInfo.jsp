<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <link rel="stylesheet" href="reset.css">
    <style>
    	iframe{
    		margin:0;
    	}
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            color: #333; /* Dark gray text color */
        }

        .container {
        	margin: 0;
            display: flex;
        }

        .menu {
            flex: 1;
            height: 2000px;
            background-color: #f0f0f0; /* Light gray background color */
            color: #333; /* Dark gray text color */
            padding: 20px;
        }

        .menu ul {
            list-style-type: none;
            padding: 0;
        }

        .menu li {
            margin-bottom: 10px;
        }

        .menu a {
            text-decoration: none;
            color: #; /* Dark gray text color */
            font-weight: bold;
        }

        .content {
            flex: 4;
            height: 2000px;
            padding-left: 5px;
        }

        iframe {
            width: 100%;
            height: 100%;
            border: none;
        }
       	a{
       		text-decoration:none;
       		color: black;
       	}
       	
       	li{
       		
       		padding 20px;
       		
       	}
       	li:hover {
       		background: deeppink;
       	}
    </style>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp"/>
	</div>
	<hr>
	<div id="content">
		<div class="container">
        <div class="menu">
            <ul>
            	<h2>내 정보</h2>
                <li><a href="listUserData.do" target="contentFrame">마이페이지</a></li>
                <li><a href="listReservation.do" target="contentFrame">예약내역</a></li>
                <li><a href="listWishlist.do" target="contentFrame">위시리스트</a></li>
                <li><a href="changePwd.do" target="contentFrame">비밀번호 변경</a></li>
            </ul>
        </div>
        <div class="content">
            <iframe name="contentFrame" frameborder="0" scrolling="auto" src="listUserData.do"></iframe>
        </div>
    </div>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>
