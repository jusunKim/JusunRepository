<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btnDelete").click(function(){
		var bookid = $(this).attr("bookid");
		re = confirm("정말 삭제할건가요")
		if(re==true){
			location.href = "deleteBook.do?bookid="+bookid;
		}
	})
})
</script>
</head>
<body>
<h2>도서 상세~</h2>
도서 번호: ${b.bookid }<br>
도서명: ${b.bookname }<br>
도서 가격: ${b.price }<br>
출판사: ${b.publisher }<br>
파일: ${b.fname }<br>
<img src="./data/${b.fname }" width="100" height="100">
<hr>
<a href="listBook.do">도서 목록</a>&nbsp;
<a href="updateBook.do?bookid=${b.bookid }">도서 수정</a>&nbsp;
<a href="#" id="btnDelete" bookid=${b.bookid }>도서 삭제</a>
</body>
</html>