<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>My Reservations and Reviews</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        div {
            background-color: #fff;
            margin: 20px;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            margin-bottom: 15px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 15px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        hr {
            border: none;
            height: 1px;
            background-color: #ddd;
            margin: 20px 0;
        }

        img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
            margin-right: 10px;
        }

        button {
            background-color: #008489;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #006666;
        }
    </style>
</head>
<body>
    <div>
        <h2>예약 내역</h2>
        <table>
            <tr>
                <th>날짜</th>
                <th>숙소명</th>
                <th>가격</th>
                <th>인원수</th>
            </tr>
            <tr>
                <td>2023.11.12 ${r_date}</td>
                <td>제주 쌍용 팬션 ${r_name}</td>
                <td>₩120,000 ${r_price}</td>
                <td>4 ${occupancy}</td>
            </tr>
        </table>
    </div>
    <hr>
    <div>
        <h2>마이 리뷰</h2>
        <div>
            <table>
                <tr>
                    <td width="150px"><img src="./image/image7.jpg ${r_image }" alt="Review Image"/></td>
                    <td>
                        제주 쌍용 팬션 ${r_name}<br>
                        아주 좋습니다. ${r_review}
                    </td>
                </tr>
            </table>
            <button>더보기</button>
        </div>
    </div>
</body>
</html>
