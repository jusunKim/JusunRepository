<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  		var jobList;
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
  		
  		$.ajax({
  			url:"listJob.do",
  			success:function(r){
  				jobList = r;
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
  			
  			
  			if(v=="d.dname" || v=="m.ename" || v=="e.job"){
  				$(".keyword").css("display","none");
  				$("#combo").css("display","inline-block");
  				$(".keyword").attr("name",null);
  				$("#combo").attr("name","search");
  				
  				switch(v){
	  				case "d.dname": addToCombo(deptList); break;
	  				case "m.ename": addToCombo(mgrList); break;
	  				case "e.job": addToCombo(jobList); break;
  				}
  			}else{
  				$(".keyword").css("display","none");
  				$("#search").css("display","inline-block");
  				$(".keyword").attr("name",null);
  				$("#search").attr("name","search");
  			}
  			
  			if(v=="e.hiredate"){
  				$("#op").css("display","inline-block");
  				$(".keyword").css("display","none");
  				$("#date_keyword").css("display","inline-block");
  				
  				$(".keyword").attr("name",null);
  				$("#date_keyword").attr("name","search");
  			}else{
  				$("#op").css("display","none");
  				$("#date_keyword").css("display","none");
  				
  				
  				
  			}

  		});
  	});
  </script>
  <style type="text/css">
  	#combo,#op, #date_keyword{
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
		<option value="e.job">직책</option>
		<option value="e.hiredate">입사일</option>
	</select>&nbsp;
	<select id="op" name="op">
		<option value=">">></option>
		<option value=">=">>=</option>
		<option value="<"><</option>
		<option value="<="><=</option>
		<option value="=">=</option>
	</select>
	<input type="search" id="search" name="search" class="keyword">&nbsp;
	<select id="combo" class="keyword"></select>
	<input type="date" id="date_keyword" class="keyword">
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
			<td>
				<fmt:formatDate value="${e.hiredate }" pattern="yyyy-MM"></fmt:formatDate>
			</td>
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