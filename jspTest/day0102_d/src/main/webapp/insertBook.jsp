<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서 등록 페이지</h2>
<hr>
<form action="insertBookOK.do" method="post" enctype="multipart/form-data">
도서 번호: <input type="number" name="bookid"><br>
도서명: <input type="text" name="bookname"><br>
도서 가격:<input type="number" name="price"><br>
출판사:<input type="text" name="publisher"><br>
파일: <br>
<input type="file" name="uploadFile"><br>
<input type="submit" value="도서 등록">
</form>
</body>
</html>