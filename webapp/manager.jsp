<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
   
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
        }

        .menu {
            flex: 1;
            height: 157px;
            background-color: #f2f2f2; 
            color: #333; 
            position: sticky;
            top: 0;
            z-index: 100;
        }

        .menu ul {
            list-style-type: none;
            padding: 0;
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
       		float:left;
       		padding-left: 40px;
		    padding-right: 40px;
		    padding-top: 10px;
		    padding-bottom: 10px;
			background:#f2f2f2;
       		
       	}
       	li:hover,li.active{
       		background: #ffffff;
       	}
    </style>
     <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
        $(document).ready(function(){
            $(".menu a").click(function(){
                $(".menu li").removeClass("active");
                $(this).parent("li").addClass("active");
            });
        });
    </script>
    
</head>
<body>
	
	<div id="content">
		<div class="container">
	        <div class="menu">
	        	<div style="display: flex; align-items: center;">
				    <img src="./images/googyul_logo.png" width="100px" height="100px">
				    <h2 style="margin-left: 10px;"><a href="manager.jsp">구귤 관리자 페이지</a></h2>
				</div>
	            <div class="navi">
	            <ul class="navi">
	            	<li><a href="listAllUserData.do" target="contentFrame">회원 관리</a></li>
	                <li><a href="listAllProduct.do" target="contentFrame">상품 관리</a></li>
	                <li><a href="listAllReservation.do" target="contentFrame">예약 관리</a></li>
	                <li><a href="listAllReview.do" target="contentFrame">리뷰 관리</a></li>
	                <li><a href="listAllQna.do" target="contentFrame">문의사항 관리</a></li>
	            </ul>
	            </div>
	        </div>
	        <div class="content">
	            <iframe name="contentFrame" frameborder="0" scrolling="auto" src="listAllUserData.do"></iframe>
	        </div>
    </div>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>
