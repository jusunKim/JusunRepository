<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Member Join</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
        }

        form {
            max-width: 400px;
            width: 100%;
            margin: auto;
            margin-top: 50px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            border-bottom: 2px solid #e74c3c;
            padding-bottom: 5px;
            margin-bottom: 20px;
        }

        input[type="text"], input[type="password"], input[type="email"], input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #3498db; /* Bootstrap Primary Color */
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #217dbb; /* Darker shade of Bootstrap Primary Color */
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#joinForm').submit(function(event) {
                if (this.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                $(this).addClass('was-validated');
            });
        });
    </script>
</head>

</head>
<body>
 	<form id="joinForm" class="needs-validation" novalidate action="" method="post">
    <h2 class="text-center">회원가입</h2>
    <div>
        <div class="form-group">
            <label for="name">이름:</label>
            <input type="text" class="form-control" id="name" name="name" required>
            <div class="invalid-feedback">
                이름을 입력해주세요.
            </div>
        </div>
        <div class="form-group">
            <label for="nickname">닉네임:</label>
            <input type="text" class="form-control" id="nickname" name="nickname" required>
            <div class="invalid-feedback">
                닉네임을 입력해주세요.
            </div>
        </div>
        <div class="form-group">
            <label for="phoneNumber">전화번호:</label>
            <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" required>
            <div class="invalid-feedback">
                유효한 전화번호를 입력해주세요.
            </div>
        </div>
        <div class="form-group">
            <label for="email">이메일:</label>
            <input type="email" class="form-control" id="email" name="email" required>
            <div class="invalid-feedback">
                유효한 이메일 주소를 입력해주세요.
            </div>
        </div>
        <div class="form-group">
            <label for="password">비밀번호:</label>
            <input type="password" class="form-control" id="password" name="password" required>
            <div class="invalid-feedback">
                비밀번호를 입력해주세요.
            </div>
        </div>
        <div class="form-group">
            <label for="confirmPassword">비밀번호 확인:</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            <div class="invalid-feedback">
                비밀번호가 일치하지 않습니다.
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-block">가입하기</button>
    </div>
</form>
</body>
</html>

