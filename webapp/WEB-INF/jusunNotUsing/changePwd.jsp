<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Password Change</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f0f0;
        }

        form {
            max-width: 500px;
            width: 100%;
            margin: auto;
            margin-top: 50px;
            padding: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            border-bottom: 2px solid #3498db;
            padding-bottom: 10px;
            margin-bottom: 30px;
        }

        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .btn-block {
            display: block;
            width: 100%;
        }

        /* Responsive styles */
        @media (max-width: 576px) {
            form {
                padding: 20px;
            }
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#passwordChangeForm").submit(function(event) {
                var currentPassword = $("#currentPassword").val();
                var newPassword = $("#newPassword").val();
                var confirmNewPassword = $("#confirmNewPassword").val();

                if (currentPassword === "" || newPassword === "" || confirmNewPassword === "") {
                    alert("Please fill in all fields.");
                    event.preventDefault();
                } else if (newPassword !== confirmNewPassword) {
                    alert("New passwords do not match.");
                    event.preventDefault();
                }
            });
        });
    </script>
</head>
<body>
    <form id="passwordChangeForm" class="needs-validation" novalidate action="backend_password_change_logic.jsp" method="post">
        <h2 class="text-center">비밀번호 변경</h2>
        <div>
            <div class="form-group">
                <label for="currentPassword">현재 비밀번호:</label>
                <input type="password" class="form-control" id="currentPassword" name="currentPassword" required>
            </div>
            <div class="form-group">
                <label for="newPassword">새로운 비밀번호:</label>
                <input type="password" class="form-control" id="newPassword" name="newPassword" required>
            </div>
            <div class="form-group">
                <label for="confirmNewPassword">새로운 비밀번호 확인:</label>
                <input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">비밀번호 변경</button>
        </div>
    </form>
</body>
</html>
