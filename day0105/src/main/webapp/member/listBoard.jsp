<%@page import="com.sist.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<h2>게시물 목록</h2>
<hr>
<a href="insertBoard.do">글 등록</a>
<table class="table table-hover">
   <tr>
      <th width="10%">글번호</th>
      <th width="70%">글제목</th>
      <th width="20%">작성자</th>
   </tr>   
   
   <c:forEach var="b" items="${list }">
      <tr>
         <td>${b.no }</td>
         <td>
            <c:if test="${b.b_level > 0 }">
               <c:forEach var="i" begin="1" end="${b.b_level }">
                  &nbsp;&nbsp;
               </c:forEach>
               <img src="re.png">
            </c:if>
            <a href="detailBoard.do?no=${b.no }">${b.title }</a>
         </td>
         <td>${b.writer }</td>
      </tr>
   </c:forEach>
</table>
   <c:forEach var="i" begin="1" end="${totalPage }">
      <a href="listBoard.do?pageNUM=${i }">${i }</a> &nbsp;
   </c:forEach>
</body>
</html>