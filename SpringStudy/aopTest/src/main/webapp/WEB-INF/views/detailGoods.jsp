<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 상세</h2>
<hr>
상품 번호: ${g.no } <br>
상품명: ${g.name }<br>
가격: ${g.price }<br>
수량: ${g.qty }<br>
파일: <img src="./images/${g.fname }" width="100" height="100">
<hr>
<a href="listGoods">상품목록</a>
<a href="updateGoods?no=${g.no }">상품수정</a>
<a href="deleteGoods?no=${g.no }">상품삭제</a>
</body>
</html>