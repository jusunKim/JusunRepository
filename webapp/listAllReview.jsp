<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>My Reservations and Reviews</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        div {
            background-color: #fff;
            margin: 10px;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            margin-bottom: 15px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 15px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        hr {
            border: none;
            height: 1px;
            background-color: #ddd;
            margin: 20px 0;
        }

       .button {
            background-color: #01d1ca;
            color: #000000;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right:10px;
            width: 100px
        }

        tr:hover {
            background-color: #f2f2f2;
        }
        #wrap{
        	display:flex;
        	height: 700px;
        }
        #left, #right{
        	display:inline-block;
        }
        a{
        	text-decoration:none;
        	color:black;
        }
        input[type="text"], input[type="search"] {
   			 height: 20px; /* 원하는 높이로 조절 */
		}       
    </style>
     <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
    	$(function(){
    		
    		$("#deleteBtn").click(function(){
    			var confirmResult = confirm("정말 삭제하시겠습니까?");
                if (confirmResult) {
                    $("#detailForm").submit();
    				alert("삭제되었습니다.")
                }
    		});
    		 
    	});
    </script>
</head>
<body>
    <div id="wrap">
	    <div id="left" style="width:70%">
	        <h2>리뷰 관리</h2>
	        <form action="listAllReview.do" method="post">
	        검색: 
	        <select name="category">
	        	<option value="u_email">회원 이메일</option>
	        	<option value="p_name">상품명</option>
	        </select>
	        <input type="search" name="search">
	        <input type="submit" value="찾기">
	        </form>
	        <br>
	        <table id="table">
	            <tr>
	                <th>리뷰번호</a></th>
	                <th>상품명</th>
	                <th>이메일</th>
	                <th>제목</th>
	                <th>작성일자</th>
	            </tr>
	            <c:forEach var="re" items="${list }">
	            <tr>
	                <td><a href="listAllReview.do?reno=${re.reno }">${re.reno}</a></td>
	                <td><a href="listAllReview.do?reno=${re.reno }">${re.p_name}</a></td>
	                <td><a href="listAllReview.do?reno=${re.reno }">${re.u_email}</a></td>
	                <td><a href="listAllReview.do?reno=${re.reno }">${re.re_title}</a></td>
	                <td><a href="listAllReview.do?reno=${re.reno }">${re.re_date}</a></td>
	            </tr>
	            </c:forEach>
	        </table>
	    </div>
	    <div id="right" style="width:25%">
	    <h2>상세 정보</h2>
	    	<form action="deleteReview.do" id="detailForm" method="post">
	    		<input type="hidden" name="reno" value="${map.reno }">
	    		리뷰번호: <input type="text" name="reno" value="${map.reno }" readonly="readonly"><br><br>
				제목: <input type="text" name="re_title" value="${map.re_title }" readonly="readonly"><br><br>
				닉네임: <input type="text" name="nickname" value="${map.nickname }" readonly="readonly"><br><br>
				내용: <br>
				<textarea rows="10" cols="30" readonly="readonly">${map.re_content}</textarea><br><br>
				작성일자: <input type="text" name="re_date" value="${map.re_date }" readonly="readonly"><br><br>
				별점: ★${map.rating}<br><br>

	    		<input type="button" id="deleteBtn" value="이 리뷰 삭제" class="button">
	    	</form>
	    </div>
    </div>
    <hr>
    <hr>
    
</body>
</html>
