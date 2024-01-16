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
    	      $("#saveButton").click(function(event){
    	    	  var changeConfirmed = confirm("변경 사항을 저장할까요?");
    	    	  if(changeConfirmed){
    	    		  $("#myForm").attr("action", "updateUser.do").submit();
                  	  alert("회원 정보 수정이 완료되었습니다.");
    	    	  }
              });
    	      $("#deleteButton").click(function(event){
    	    	  var deleteConfirmed = confirm("정말 삭제할까요?");
    	    	  if(deleteConfirmed){
    	    		  $("#myForm").attr("action", "deleteUser.do").submit();
                  	  alert("회원 삭제가 완료되었습니다.");
    	    	  }
              })
    	}); 
    </script>
</head>
<body>
	<div id="wrap">
	    <div id="left" style="width:70%">
	        <h2>회원 관리</h2>
	        <form action="listAllUserData.do", method="post">
	        검색: 
	        <select name="u_category">
	        	<option value="u_name">회원명</option>
	        	<option value="u_phone">핸드폰번호</option>
	        </select>
	        <input type="search" name = "u_search">
	        <input type="submit" value="찾기">
	        </form>
	        <br>
	        <table id="table">
	            <tr>
	                <th>회원번호</th>
	                <th>회원명</th>
	                <th>이메일</th>
	                <th>전화번호</th>
	            </tr>
	            <c:forEach var="u" items="${list }">
	            <tr >
	                <td><a href="listAllUserData.do?uno=${u.uno }">${u.uno}</a></td>
	                <td><a href="listAllUserData.do?uno=${u.uno }">${u.u_name}</a></td>
	                <td><a href="listAllUserData.do?uno=${u.uno }">${u.u_email}</a></td>
	                <td><a href="listAllUserData.do?uno=${u.uno }">${u.u_phone}</a></td>
	            </tr>
	            </c:forEach>
	        </table>
	    </div>
	    <div id="right" style="width:25%">
	    <h2>상세 정보</h2>
	    	<form id="myForm">
	    		회원번호: <input type="text" value="${u.uno }" name="uno" readonly="readonly"> <br><br>
	    		회원명: <input type="text" value="${u.u_name } " name="u_name" readonly="readonly"><br><br>
	    		이메일: <input type="text" value="${u.u_email } " name="u_email" readonly="readonly"><br><br>
	    		휴대폰번호: <input type="text" value="${u.u_phone }" name="u_phone" > <br><br>
	    		비밀번호: <input type="text" value="${u.u_pwd }" name="u_pwd" readonly="readonly"> <br><br>
	    		닉네임: <input type="text" value="${u.nickname }" name="nickname"><br><br>
	    		<input type="button" id="saveButton" value="변경사항 저장" class="button">
	    		<input type="button" id="deleteButton" value="회원 삭제" class="button">
	    	</form>
	    </div>
    </div>
    <hr>
    
</body>
</html>
