<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 등록</h2>
<form action="insertBoardOK.do" method="post" enctype="multipart/form-data">
<table width="80%">
	<tr>
		<td>글제목</td>
		<td><input type="text" name="title" required="required"></td>
	</tr>
	<tr>
	<td>작성자</td>
		<td><input type="text" name="writer" value="${idKey }" required="required"></td>
	</tr>
	<tr>
		<td>글암호</td>
		<td><input type="text" name="pwd" required="required"></td>
	</tr>
	<tr>
		<td>글내용</td>
		<td><textarea rows="10" cols="30" name="content" required="required"></textarea></td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td><input type="file" name="uploadFile"></td>
	</tr>
	<tr>
		<td colspan=2>
			<input type="submit" value="등록"> &nbsp; 
			<input type="reset" value="재설정">
		</td>
	</tr>
</table>



</form>
</body>
</html>