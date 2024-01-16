<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문의하기</title>
    <!-- 부트스트랩 CSS 링크 추가 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #f5f5f5;
        }

        #qnaForm {
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
            height: 500px; /* 고정된 높이값 */
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
</body>
</html>