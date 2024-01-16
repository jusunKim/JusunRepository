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
            margin: 20px;
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

        img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
            margin-right: 10px;
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
        }
        #left, #right{
        	display:inline-block;
        }
        a{
        	text-decoration:none;
        	color: black;
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
                    $("#myForm").submit();
    				alert("삭제되었습니다.")
                }
    		});
    		 
    	});
    </script>
</head>
<body>
   <div id="wrap">
	    <div id="left" style="width:70%">
	        <h2>예약 관리</h2>
	        <form action="listAllReservation.do", method="post">
	        검색: 
	        <select name="r_category">
	        	<option value="u_email">예약자 이메일</option>
	        	<option value="r.rno">예약번호</option>
	        	<option value="r.pno">상품번호</option>
	        </select>
	        <input type="search" name = "r_search">
	        <input type="submit" value="찾기">
	        </form>
	        <br>
	        <table id="table">
	            <tr>
	                <th>예약번호</th>
	                <th>예약일자</th>
	                <th>상품번호</th>
	                <th>체크인날짜</th>
	                <th>체크아웃날짜</th>
	                <th>게스트수</th>
	                <th>예약자 이메일</th>
	            </tr>
	            <c:forEach var="r" items="${list }">
	            <tr>
	                <td><a href="listAllReservation.do?rno=${r.rno }">${r.rno}</a></td>
	                <td><a href="listAllReservation.do?rno=${r.rno }">${r.r_date}</a></td>
	                <td><a href="listAllReservation.do?rno=${r.rno }">${r.pno}</a></td>
	                <td><a href="listAllReservation.do?rno=${r.rno }">${r.checkin_date}</a></td>
	                <td><a href="listAllReservation.do?rno=${r.rno }">${r.checkout_date}</a></td>
	                <td><a href="listAllReservation.do?rno=${r.rno }">${r.guest_cnt}</a></td>
	                <td><a href="listAllReservation.do?rno=${r.rno }">${r.u_email}</a></td>
	            </tr>
	             </c:forEach>
	        </table>
	    </div>
	    <div id="right" style="width:25%">
	    <h2>상세 정보</h2>
	    	<form id="myForm" action="deleteReservation.do">
	    		<input type="hidden" name="rno" value="${r.rno }">
	    		예약번호: <input type="text" name="rno" value="${r.rno }" readonly="readonly"><br><br>
				예약일자: <input type="text" name="r_date" value="${r.r_date }" readonly="readonly"><br><br>
				카드번호: <input type="text" name="cardno" value="${r.cardno }" readonly="readonly"><br><br>
				체크인날짜: <input type="text" name="checkin_date" value="${r.checkin_date }" readonly="readonly"><br><br>
				체크아웃날짜: <input type="text" name="checkout_date" value="${r.checkout_date }" readonly="readonly"><br><br>
				게스트수: <input type="text" name="guest_cnt" value="${r.guest_cnt }" readonly="readonly"><br><br>
				결제금액: <input type="text" name="saleprice" value="${r.saleprice }" readonly="readonly"><br><br>
				예약자명: <input type="text" name="u_name" value="${r.u_name }" readonly="readonly"><br><br>
				예약자 이메일: <input type="text" name="u_email" value="${r.u_email }" readonly="readonly"><br><br>
				상품번호: <input type="text" name="pno" value="${r.pno }" readonly="readonly"><br><br>
				상품명: <input type="text" name="p_name" value="${r.p_name }" readonly="readonly"><br><br>

	    		<input  type="button" id="deleteBtn" value="예약 취소" class="button">
	    	</form>
	    </div>
    </div>
    <hr>
    
</body>
</html>
