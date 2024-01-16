<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Recovery</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url(./image/login.png);
            background-repeat: no-repeat;
            background-size: cover;
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0; /* To remove default body margin */
        }

        #findPwd {
            max-width: 400px;
            width: 100%;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            border-bottom: 2px solid #3498db; /* Cool Blue Color */
            padding-bottom: 5px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 15px;
        }

        table, td {
            border: none;
        }

        input[type="email"], input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button[type="submit"] {
            background-color: #3498db; /* Cool Blue Color */
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            display: block;
            width: 100%;
        }

        button[type="submit"]:hover {
            background-color: #2980b9; /* Darker shade of Cool Blue */
        }
    </style>
</head>
<body>
    <div id="findPwd">    
        <form action="findPasswordOK.do" method="post">
            <h2>비밀번호 찾기</h2>
            <table>
                <tr>
                    <td>이메일주소 :</td> 
                    <td><input type="email" required></td>
                </tr>
                <tr>
                    <td>전화번호:</td>
                    <td><input type="tel" required></td>
                </tr>
            </table>
            <button type="submit">찾기</button>
        </form>
        <div>
        	로그인 화면으로 돌아가시겠습니까?&nbsp;&nbsp;&nbsp;<a href="login.do" >로그인 페이지</a><br>
       </div>
    </div>
</body>
</html>
