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
	$("#btnReadSession").on("click", function(){
		
	});
	$("#btnSaveSession").on("click", function(){
		sessionStorage.setItem("session",$("#input_session").val());
	});
	$("#btnReadLocal").on("click", function(){
		
	});
	$("#btnSaveLocal").on("click", function(){
		localStorage.setItem("session",$("#input_session").val());		
	});
});
</script>
</head>
<body>
sessionStorage 출력: <span id="output_session"></span>
<button id="btnReadSession">sessionStorage읽어오기</button>
<br>
sessionStorage 입력: <input type="text" id="input_session">
<button id="btnSaveSession">sessionStorage저장</button>
<hr>
localStorage 출력: <span id="output_local"></span>
<button id="btnReadLocal">localStorage읽어오기</button>
<br>
localStorage 입력: <input type="text" id="input_local">
<button id="btnSaveLocal">localStorage저장</button>
<hr>
</body>
</html>