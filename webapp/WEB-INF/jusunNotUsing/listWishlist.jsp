<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            width: 30%; /* Adjust the width as needed */
            display: inline-block;
            margin: 0 1.5%; /* Adjust the margin as needed */
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
        <hr>
        <div>
            <h2>마이 리뷰</h2>
            <div>
                <!-- Start Loop -->
                <!-- <c:forEach> -->
                <table>
                    <tr>
                        <td width="140px"><a href="temporary.jsp" ><img src="./image/image7.jpg ${r_image }" alt="Review Image"/></a></td>
                    </tr>
                    <tr>
                    	<td>
                            제주 쌍용 팬션 ${r_name}<br>
                           	바다가 보이는 소개${contentShort}
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td width="140px"><a href="temporary.jsp" ><img src="./image/image6.jpg ${r_image }" alt="Review Image"/></a></td>
                    </tr>
                    <tr>
                    	<td>
                            제주 쌍용 팬션 ${r_name}<br>
                           	바다가 보이는 소개${contentShort}
                        </td>
                    </tr>
                </table>                <table>
                    <tr>
                        <td width="140px"><a href="temporary.jsp" ><img src="./image/image5.jpg ${r_image }" alt="Review Image"/></a></td>
                   </tr>
                    <tr>
                    	<td>
                            제주 쌍용 팬션 ${r_name}<br>
                           	바다가 보이는 소개${contentShort}
                        </td>
                    </tr>
                </table>                <table>
                    <tr>
                        <td width="150px"><a href="temporary.jsp" ><img src="./image/image4.jpg ${r_image }" alt="Review Image"/></a></td>
                    </tr>
                    <tr>
                    	<td>
                            제주 쌍용 팬션 ${r_name}<br>
                           	바다가 보이는 소개${contentShort}
                        </td>
                    </tr>
                </table>                <table>
                    <tr>
                        <td width="150px"><a href="temporary.jsp" ><img src="./image/image3.jpg ${r_image }" alt="Review Image"/></a></td>
                    </tr>
                    <tr>
                    	<td>
                            제주 쌍용 팬션 ${r_name}<br>
                           	바다가 보이는 소개${contentShort}
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td width="140px"><a href="temporary.jsp" ><img src="./image/image2.jpg ${r_image }" alt="Review Image"/></a></td>
                   </tr>
                    <tr>
                    	<td>
                            제주 쌍용 팬션 ${r_name}<br>
                           	바다가 보이는 소개${contentShort}
                        </td>
                    </tr>
                </table>
                <!-- </c:forEach> -->
                <!-- Repeat the above table block for the remaining reviews -->

                <!-- Additional Functionality Comment: Add any additional functionalities here -->
				
            </div>
            <button>더보기</button>
        </div>
    </div>
</body>
</html>
