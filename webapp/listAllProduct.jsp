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
        #combo{
        	display:none
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
	    	    		  $("#myForm").attr("action", "updateProduct.do").submit();
	                  	  
	    	    	  }
	              });
	    	      $("#deleteButton").click(function(event){
	    	    	  var deleteConfirmed = confirm("정말 삭제할까요?");
	    	    	  if(deleteConfirmed){
	    	    		  $("#myForm").attr("action", "deleteProduct.do").submit();
	                  	 
	    	    	  }
	              })
	              $("#p_category").change(function(){ 
		      			var v = $(this).val();
		      			if(v=="a_code"){
		      				$("#combo").css("display","inline-block");
		      				$("#p_search").css("display","none");	
		      				$("#combo").attr("name","p_search");
		      				$("#p_search").attr("name",null);		
		      			}else{
		      				$("#p_search").css("display","inline-block");
		      				$("#combo").css("display","none");		
		      				$("#combo").attr("name",null);
		      				$("#p_search").attr("name","p_search");	
		      			}
	      		});

	    	}); 
	    </script>
    
</head>
<body>
    <div id="wrap">
    	<div id="left" style="width:70%">
	        <h2>상품 관리</h2>
	        <form action="listAllProduct.do" method="post">
		        검색: 
		        <select name="p_category" id="p_category">
		        	<option value="p_name">상품명</option>
		        	<option value="a_code">지역구분</option>
		        </select>
		        <select id="combo">
		        	<option value="1">제주시 서부</option>
		        	<option value="2">제주시 중부</option>
		        	<option value="3">제주시 동부</option>
		        	<option value="4">서귀포시 서부</option>
		        	<option value="5">서귀포시 중부</option>
		        	<option value="6">서귀포시 동부</option>
		        </select>
		        <input type="search" id="p_search" name="p_search">
		        <input type="submit" value="찾기">
	        </form>
	        <br>
	        <table>
	            <tr>
	                <th>상품번호</th>
	                <th>상품명</th>
	                <th>주소</th>
	                <th>최대 인원 수</th>
	                <th>1박 당 가격</th>
	                <th>별점</th>
	              
	             </tr>
	            <c:forEach var="p" items="${list }">
	            <tr>
	                <td><a href="listAllProduct.do?pno=${p.pno }"> ${p.pno}</a></td>
	                <td><a href="listAllProduct.do?pno=${p.pno }">${p.p_name}</a></td>
	                <td><a href="listAllProduct.do?pno=${p.pno }">${p.addr}</a></td>
	                <td><a href="listAllProduct.do?pno=${p.pno }">${p.occ_max}명</a></td>
	                <td><a href="listAllProduct.do?pno=${p.pno }">${p.price}원</a></td>
	                <td><a href="listAllProduct.do?pno=${p.pno }">★${p.rating}</a></td>
	            </c:forEach>   
	            </tr>
	        </table>
	    </div>
	    <div id="right" style="width:25%">
	    <h2>상세 정보</h2>
	    	<form id="myForm">
	    		상품번호: <input type="text" name="pno" value="${p.pno }" readonly="readonly"> <br><br>
	    		상품명: <input type="text" name="p_name" value="${p.p_name }" readonly="readonly"><br><br>
	    		연락처: <input type="text" name="p_phone" value="${p.p_phone }"><br><br>
	    		주소: <input type="text" name="addr" size="30" value="${p.addr }" readonly="readonly"> <br><br>
	    		최대인원수: <input type="text" name="occ_max" value="${p.occ_max }"> <br><br>
	    		가격: <input type="text" name="price" value="${p.price }"><br><br>
	    		별점: <input type="text" name="rating" value="${p.rating }" readonly="readonly"><br><br>
	    		상세설명: <br>
	    		<textarea rows="10" cols="30" name="p_explain">${p.p_explain }</textarea><br><br>
	    		위도: <input type="text" name="lat" value="${p.lat }" readonly="readonly"><br><br>
	    		경도: <input type="text" name="lng" value="${p.lng }" readonly="readonly"><br><br>
	    		상품코드: <input type="text" name="p_code" value="${p.p_code }" readonly="readonly"><br><br>
	    		지역코드: <input type="text" name="a_code" value="${p.a_code }" readonly="readonly"><br><br>
	    		<input type="button" id="saveButton" value="변경사항 저장" class="button">
	    		<input type="button" id="deleteButton" value="상품 삭제" class="button">
	    	</form>
	    </div>
    </div>
    <hr>
    
</body>
</html>
