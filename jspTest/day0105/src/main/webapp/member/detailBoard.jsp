<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h2>�Խù� ��</h2>
<hr>

�۹�ȣ: ${b.no } <br>
����: ${b.title } <br>
�ۼ���: ${b.writer } <br>
����: <br>
 <textarea rows="10" cols="50" readonly="readonly">${b.content}</textarea><br>
�ۼ���: ${b.regdate }<br>
��ȸ��: ${b.hit }<br>
ip�ּ�: ${b.ip}<br>
÷������: ${b.fname }<br>
<hr>
<a href="insertBoard.do?no=${b.no }">��۴ޱ�</a>
<a href="listBoard.do">�������</a>
</body>
</html>