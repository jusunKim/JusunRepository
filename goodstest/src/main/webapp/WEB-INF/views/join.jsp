<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	#box_phone, #box_email, #box_check, #f{
		display:none;
	}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var newCode;
		var phone;
		var email;
		var authType;
		
		$("#radio_email").click(function(){
			$("#auth_span").html("이메일 주소:");
			$("#to").val("");
			authType="email";
		})
		$("#radio_phone").click(function(){
			$("#auth_span").html("휴대폰 버호 :");
			$("#to").val("");
			authType="phone";
		})
		
		$("#btnSendSms").click(function(){
			to = $("#to").val();
			var data = {to:to, authType:authType};
			$.ajax({
				url:"sendCode",
				data:data,
				success:function(r){
					newCode = r;
					console.log(newCode);
					$("#box_check").css("display","block");
					
				}
			})
		});
	
		$("#btnCheckNUM").click(function(){
			var userCode = $("#checkNUM").val();
			if(userCode==newCode){
				$("#f").css("display","block");
				$(".check").css("display","none");
				if(authType=="email"){
					$("#email2").val(to)
				}else{
					$("#phone2").val(to)
				}
			}else{
				alert("코드가 일치하지 않씁니다");
			}
		});
	});
</script>
<body>
	<h2>회원가입</h2>
	
	
	<div id="box_sms" class="check">
		<input type="radio" id="radio_email" value="email" name="authType"  >이메일로 인증하기
		<input type="radio" id="radio_phone" value="phone" name="authType" >전화번호로 인증하기<br>
		<span id="auth_span">전화번호: </span> <input id="to">
		<button id="btnSendSms">인증코드 전송</button>
	</div>
	
	
	
	<div id="box_check" class="check">
		인증번호 입력:<input id="checkNUM">
		<button id="btnCheckNUM">확인</button>
	</div>
	
	
	<form action="join" method="post" id="f">
		아이디: <input name="id"><br>
		비밀번호: <input type="password" name="pwd"><br>
		이름: <input name="name"><br>
		이메일: <input name="email" id="email2"><br>
		전화번호: <input name="phone" id="phone2"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>