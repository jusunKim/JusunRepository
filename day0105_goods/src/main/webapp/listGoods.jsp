<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.wrap{
	width: 400px; height: 120px;
	border:  1px solid pink;
	border-radius: 5px;
	margin: 20px;
	position: relative;
	padding: 10px
}
.image{
	float:left;
}
</style>
</head>
<body>
<form action="listGoods.do" method="post">
검색 <input type="search" name="search">
<input type="submit" value="찾기">
</form>
<h2>상품목록~</h2>
<c:forEach var="b" items="${list}" >
	<div class="wrap">
		<div class="image">
			<img src="images/${b.fname }" width="100" height=100>
		</div>
		<div class="detail" style="vertical-align:center">
			<p><b>상품번호</b>: ${b.no }     <b>상품이름</b>: ${b.name }</p>
			<p><b>가격</b>: ${b.price }           <b>수량</b>: ${b.qty }</p>
		</div>
	</div>
</c:forEach>
<c:forEach var="i" begin="1" end="${totalPage }">
<a href="listGoods.do?pageNUM=${i }">${ i}</a>
</c:forEach>
</body>
</html>