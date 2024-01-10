<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script type="text/javascript">
  	$(function(){
  		var deptList;
  		var mgrList;
  		$.ajax("listDname.do",{
  			success:function(arr){
  				deptList = arr;
  			}
  		});
  		
  		$.ajax({
  			url:"listManager.do",
  			success:function(arr){
  				mgrList = arr;
  			}
  		});
  		
  		function addToCombo(list){
  			$("#combo").empty();
  			$.each(list, function(){
				var option = $("<option></option>").html(this);
				$(option).attr("value",this);
				$("#combo").append(option);
			});
  		}
  		
  		$("#category").change(function(){
  			var v = $(this).val();
  			console.log(v);
  			if(v=="d.dname" || v=="m.ename"){
  				$("#combo").css("display","inline-block");
  				$("#search").css("display","none");
  				$("#combo").attr("name","search");
  				$("#search").attr("name",null);
  				if(v=="d.dname"){
  					addToCombo(deptList);
  				}else{
  					addToCombo(mgrList);
  				}
  			}else{
  				$("#combo").css("display","none");
  				$("#search").css("display","inline-block");
  				$("#combo").attr("name",null);
  				$("#search").attr("name","search");
  			}
  		});
  	});
  </script>
  <style type="text/css">
  	#combo{
  			display:none
  		}
  </style>
<title>Insert title here</title>
</head>
<body>
<div class="container mt-3">
<h2>더 구체적인 사원 목록..</h2>
<hr>
<form action="listEmpAll.do" >
	검색하기~
	<select name="category" id="category">
		<option value="e.ename">사원명</option>
		<option value="d.dname">부서명</option>
		<option value="m.ename">관리자명</option>
	</select>&nbsp;
	<input type="search" id="search" name="search">&nbsp;
	<select id="combo">
	</select>
	<input type="submit" value="검색">
</form>
<hr>
<table class="table" border="1">
	<thead class="table-dark">
	<tr>
		<th>사원번호</th>
		<th>사원명</th>
		<th>부서번호</th>
		<th>부서명</th>
		<th>급여</th>
		<th>수당</th>
		<th>실수령액</th>
		<th>입사일</th>
		<th>근무개월수</th>
		<th>관리자명</th>
		<th>주민번호</th>
		<th>이메일</th>
		<th>직책</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="e" items="${list }">
		<tr>
			<td>${e.eno }</td>
			<td>${e.ename }</td>
			<td>${e.dno }</td>
			<td>${e.dname }</td>
			<td>${e.salary }</td>
			<td>${e.comm }</td>
			<td>${e.income }</td>
			<td>${e.hiredate }</td>
			<td>${e.workmonth }</td>
			<td>${e.mname }</td>
			<td>${e.jumin }</td>
			<td>${e.email }</td>
			<td>${e.job }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>