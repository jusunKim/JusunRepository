<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Q&A List</title>
    <!-- Bootstrap CSS Link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f5f5f5;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;	
        }

        table {
            width: 750px;
            border-collapse: collapse;
            max-width: 750px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }
        
        #qnaForm {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* 그림자 색상을 더 짙게 조절 */
        }
        
        #qnaList {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* 그림자 색상을 더 짙게 조절 */
        }

        h2 {
            color: #007bff;
            margin-bottom: 20px;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
        }

        label {
            margin-bottom: 5px;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            max-width: 600px;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        textarea {
            width: 100%;
            max-width: 600px;
            height: 200px; /* 고정된 높이값 */
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            overflow-y: auto; /* 세로 스크롤 추가 */
            resize: none; /* textarea 크기 조절 비활성화 */
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
        
        
    </style>
</head>
<body>
	<div id="qnaForm">
        <form action="insertQna.do" method="post">
            <br>
            <h2>문의하기</h2>
            <hr>
            <div class="mb-3">
                <label for="q_title" class="form-label">제목:</label>
                <input type="text" id="q_title" name="q_title" class="form-control">
            </div>
            <div class="mb-3">
                <label for="q_content" class="form-label">내용:</label>
                <textarea id="q_content" name="q_content" class="form-control"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <br>
        </form>
    </div>
    
	<div id="qnaList">
	<h2>나의 문의 리스트</h2>
    <table>
        <thead>
            <tr>
                <th>NO</th>
                <th>제목</th>
                <th>문의날짜</th>
                <th>답변하기</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${yourDataList}">
                <tr>
                    <td>${item.qno}</td>
                    <td>${item.q_title}</td>
                    <td>${item.q_date}</td>
                    <td><button type="button" onclick="location.href='updateQna.do?qno=${item.qno}'">답변달기</button></td>
                </tr>
            </c:forEach>
			<tr>
				<td>1</td>
				<td>밥이 나오나요?</td>
				<td>2023-01-01</td>
				<td><button type="updateQna.do?qno=${qno }">답변달기</button></td>
			<tr>
			<tr>
				<td>2</td>
				<td>밥이 나오나요?</td>
				<td>2023-01-01</td>
				<td><button type="updateQna.do?qno=${qno }">답변달기</button></td>
			<tr>
			<tr>
				<td>3</td>
				<td>밥이 나오나요?</td>
				<td>2023-01-01</td>
				<td><button type="updateQna.do?qno=${qno }">답변달기</button></td>
			<tr>
			<tr>
				<td>4</td>
				<td>밥이 나오나요?</td>
				<td>2023-01-01</td>
				<td><button type="updateQna.do?qno=${qno }">답변달기</button></td>
			<tr>
        </tbody>
    </table>
    </div>
</body>
</html>