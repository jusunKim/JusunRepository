<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#combo{
		display:none;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax("listJob.do",{
			success:function(arr){
				jobList =arr;
				//addJob(jobList);
				
			}
		})
		$.ajax({
			url : "listDno.do",
			success:function(r){
				dnoList=r;
				//addJob(jobList);
			}
		});
		
		function add(list){
			$("#combo").empty();
			$.each(list, function(){
				var option = $("<option></option>").html(this);
				option.attr("value",this);
				$("#combo").append(option);				
			})
		}
		
		
		$("#category").change(function(){
			var v = $(this).val();
				console.log(v);
			if(v=="job" || v=="dno"){
				if(v=="job"){
					add(jobList);
				}else{
					add(dnoList);
				}
				$("#combo").css("display","inline-block");
				$("#search").css("display","none");
				$("#combo").attr("name","search");
				$("#search").attr("name",null);
				
			}else{
				$("#combo").css("display","none");
				$("#search").css("display","inline-block");
				$("#combo").attr("name",null);
				$("#search").attr("name","search");
			}
		});
	});
</script>
</head>
<body>
<h2>-사원 목록-</h2>
<hr>
<form action="listEmp.do">
	검색: 
	<select name="category" id="category">
		<option value="email">아이디</option>
		<option value="jumin">생년월일</option>
		<option value="job">직책</option>
		<option value="dno">부서</option>
	</select>
	<select id="combo" >
	</select>
	<input type="search" name="search" id="search"> &nbsp;
	<input type="submit" value="찾기">
</form><br>

<table border="1">
	<tr>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>직책</th>
		<th>입사일</th>
		<th>급여</th>
		<th>부서번호</th>
		<th>주민번호</th>
		<th>이메일</th>
	</tr>
	<c:forEach var="e" items="${list }">
		<tr>
			<td>${e.eno }</td>
			<td>${e.ename }</td>
			<td>${e.job }</td>
			<td>${e.hiredate }</td>
			<td>${e.salary}</td>
			<td>${e.dno }</td>
			<td>${e.jumin }</td>
			<td>${e.email }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>