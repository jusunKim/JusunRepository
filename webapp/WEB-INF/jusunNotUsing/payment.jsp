<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>확인 및 결제</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
        }

        form {
            max-width: 800px;
            width: 100%;
            height: 720px;
            margin: auto;
            margin-top: 100px;
            margin-bottom: 100px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between;
            position: relative;
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
            background-color: #3498db;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 30%;
            position: absolute;
            bottom: 20px;
            width: 100px;
        }
		
		input[type="submit"].btn {
			margin-left: 160px;
			width: 200px;
		}
		
        input[type="submit"]:hover {
            background-color: #217dbb;
        }

        #payLeftHalf {
            width: 48%;
			height: 80%;
	        padding: 10px;
	        background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        #payRightHalf {
            width: 48%;
            height: 100%;
            text-align: center;
            padding: 10px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        #payRightHalf img {
            width: 50%;
        }

        #payRightHalf h2 {
            color: #333;
            margin-top: 20px;
            border-bottom: 2px solid #e74c3c;
            padding-bottom: 5px;
        }

        #payRightHalf table {
            width: 100%;
            margin-top: 20px;
            text-align: left;
        }

        #payRightHalf td {
            padding: 8px;
            border-bottom: 1px solid #eee;
        }
        
    </style>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#paymentForm').submit(function(event) {
                if (this.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                $(this).addClass('was-validated');
            });
        });
    </script>
</head>
<body>
    <form id="paymentForm" class="needs-validation" novalidate action="" method="post">
        <div id="payLeftHalf">
            <!-- Left Half Content -->
            <h2 class="text-center"><a href="">확인 및 결제</a></h2>
            <div>
                <div class="form-group">
                    <label for="date">날짜:</label>
                    <input type="text" class="form-control" id="date" name="date" required>
                    <div class="invalid-feedback">
                        날짜를 입력해주세요.
                    </div>
                </div>
                <div class="form-group">
                    <label for="occupancy">게스트:</label>
                    <input type="text" class="form-control" id="occupancy" name="occupancy" required>
                    <div class="invalid-feedback">
                        게스트 정보를 입력해주세요.
                    </div>
                </div>
            </div>
            <div>
                <h2>결제수단</h2>
                <div class="form-group">
                    <label for="cardNumber">카드번호:</label>
                    <input type="text" class="form-control" id="cardNumber" name="cardNumber" required>
                    <div class="invalid-feedback">
                        카드번호를 입력해주세요.
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="expirationMonth">만료일:</label>
                        <input type="month" class="form-control" id="expirationMonth" name="expirationMonth" required>
                        <div class="invalid-feedback">
                            유효한 만료일을 입력해주세요.
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cvv">CVV:</label>
                        <input type="text" class="form-control" id="cvv" name="cvv" required>
                        <div class="invalid-feedback">
                            유효한 CVV를 입력해주세요.
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <div id="payRightHalf">
            <!-- Right Half Content -->
            <table>
                <tr>
                    <td id="payRoomSum">
                        호텔이름 $(hotelName)<br>
                        호텔평점 $(hotelRate)<br>
                    </td>
                </tr>
                <tr>
                    <td><h2>요금 세부정보</h2><br>
                        <table>
                            <tr>
                                <td><$(price) x $(day)</td>
                                <td><$($(price)*$(day))</td>
                            </tr>
                            <tr>
                                <td>청소비</td>
                                <td>$(cleaning)</td>
                            </tr>
                            <tr>
                                <td><h2>합계</h2></td>
                                <td><h2>$(total)</h2></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="확인 및 결제">
    </form>
</body>
</html>

