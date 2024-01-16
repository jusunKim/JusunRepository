<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<form action="" method="post">
	<h2><a href=""><</a>확인 및 결제</h2>
	<div>
		<table>
			<tr>
				<td><h3>예약정보</h3></td>
			</tr>
			<tr>
				<td><b>날짜</b></td>
			</tr>
			<tr>
				<td>(날짜시작)${date } - (날짜끝)${date }</td>
			</tr>
			<tr>
				<td><b>게스트</b>b</td>
			</tr>
			<tr>
				<td>(게스트입력공간)${occupancy }</td>
			</tr>
		</table>
	</div>
	
	<div>
		<h2>결제수단</h2>
		<table>
			<tr>카드번호<input type="card"></tr>
			<hr>
			<tr>만료일<input type="month"> cvv<input type=""></tr>
		</table>
	</div>
	<input type="submit" value="확인 및 결제">
	</form>
</body>
</html>