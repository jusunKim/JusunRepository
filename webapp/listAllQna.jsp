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
       	li{
       		list-style:none;
       		float:left;
       		padding-right:20px;
       		padding-left:0
       	}
       	a{
       		text-decoration:none;
       		color:black;
       	}
       	#wrap{
        	display:flex;
        }
        #left, #right{
        	display:inline-block;
        }
        #right{
        	height:800px
        }
        input[type="text"], input[type="search"] {
   			 height: 20px; /* 원하는 높이로 조절 */
		}
		.a_menu:hover{
			 text-decoration: underline;
		}
    </style>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
    	$(function(){
    		
    		$("#updateBtn").click(function(){
    			var confirmResult = confirm("답변을 등록하시겠습니까?");
                if (confirmResult) {
                    $("#detailForm").submit();
                }
    		});
    		 $("a").click(function(e) {
                 $(this).closest("tr").addClass("selected-row");
                 $("table tr").not($(this).closest("tr")).removeClass("selected-row");
             });
    	});
    </script>
</head>
<body>
    <div id="wrap">
    	<div id="left" style="width:70%">
        <h2>문의사항 관리</h2>
        <ul>
        	<li><a href="listAllQna.do?answered=1" class="a_menu">전체 문의사항</a></li>
        	<li><a href="listAllQna.do?answered=0" class="a_menu">답변이 필요한 문의사항</a></li>
        </ul>
        <br>
        <hr>
         	<form action="listAllQna.do" method="post">
		        이메일로 검색: 
		        <input type="search" name="search">
		        <input type="submit" value="찾기">
	        </form>
	        <br>
	        <table>
	            <tr>
	                <th>문의번호</th>
	                <th>이메일</th>
	                <th>제목</th>
	                <th>작성일</th>
	                <th>답변 상태</th>
	             </tr>
	             <c:forEach var="q" items="${nlist }">
	            <tr>
	                <td><a href="listAllQna.do?qno=${q.qno}">${q.qno}</a></td>
	                <td><a href="listAllQna.do?qno=${q.qno}">${q.u_email}</a></td>
	                <td><a href="listAllQna.do?qno=${q.qno}">${q.q_title}</a></td>
	                <td><a href="listAllQna.do?qno=${q.qno}">${q.q_date}</a></td>
	                <td><a href="listAllQna.do?qno=${q.qno}">${q.a_msg }</a></td> 
	            </tr>
	            </c:forEach>
	        </table>
        </div>
         <div id="right" style="width:25%" >
	    <h2>상세 정보</h2>
	    	<form id="detailForm" action="updateQna.do" method="post">
	    		<input type="hidden" name="qno" value="${q.qno }" >
				문의번호: <input type="text" name="qno" value="${q.qno }"><br><br>
				회원번호: <input type="text" name="uno" value="${q.uno }"><br><br>
				제목: <input type="text" name="q_title" value="${q.q_title }"><br><br>
				작성일자: <input type="text" name="q_date" value="${q.q_date }"><br><br>
	    		문의내용: <br>
	    		<textarea rows="10" cols="30" readonly="readonly">${q.q_content}</textarea><br><br>
	    		답변: <br>
	    		<textarea rows="10" cols="30" name="a_content">${q.a_content }</textarea><br><br>
	    		<input id="updateBtn" type="button" value="답변 등록" class="button">
	    	</form>
	    </div>
    </div>
    <hr>
    
</body>
</html>
