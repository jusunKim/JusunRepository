<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#op{
	display:none;
}
#pub{
	display:none;
}
a{
	text-decoration: none;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#category").change(function(){
			var v = $(this).val();
			if(v=="price"){
				$("#op").css("display","inline-block");
				$("#search").css("display","inline-block");
				$("#pub").css("display","none");
			}else{
				$("#op").css("display","none");				
			
			if(v=="bookname"){
				$("#search").css("display","inline-block");
			}	
				
			if(v=="publisher"){
				$("#pub").css("display","inline-block");
				$("#search").css("display","none");
				$.ajax("listPublisher.do", {
					success: function(r){
						$.each(r,function(){
							var option = $("<option></option>").html(this);
							$("#pub").append(option);
						})
					}
				})
			}else{
				$("#pub").css("display","none");
				
			}
			}
		});
	});
</script>
</head>
<body>
<h2><a href="listBook.do">도서 목록</a></h2>
<hr>
<form method="post" action="listBook.do">
	검색: <select name = "category" id="category">
		<option value="bookname">도서명</option>	
		<option value="publisher">출판사</option>	
		<option value="price">가격</option>			
	</select>&nbsp; 
	<select name="op" id="op">
		<option value=">">></option>
		<option value=">=">>=</option>
		<option value="<"><</option>
		<option value="<="><=</option>
		<option value="=">=</option>
	</select>
	<select name="pub" id="pub">
	</select>
	<input type="search" name="search" id="search">&nbsp;
	<input type="submit" value="찾기">
</form>
<hr>
<table border=1>
	<tr>
		<th><a href="listBook.do?column=bookid">도서번호</a></th>
		<th><a href="listBook.do?column=bookname">도서명</a></th>
		<th><a href="listBook.do?column=price">가격</a></th>
		<th><a href="listBook.do?column=publisher">출판사</a></th>
	</tr>
	<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.bookid }</td>
			<td>${b.bookname }</td>
			<td>${b.price }</td>
			<td>${b.publisher }</td>		
		</tr>
	</c:forEach>
</table>
<hr>

</body>
</html>