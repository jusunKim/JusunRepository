<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  // 후기 팝업을 보여주는 함수
  function showReviews() {
    document.getElementById('reviewPopup').style.display = 'block';
  }

  // 후기 팝업을 닫는 함수
  function closeReviews() {
    document.getElementById('reviewPopup').style.display = 'none';
  }
</script>
<style>
  body {
    font-family: '나눔고딕', Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f0f0f0;
  }

  header, footer, .content, .review-popup {
    border-radius: 30px;
    margin: 10px;
    background-color: white;
  }

  header {
    padding: 20px;
    text-align: center;
  }

  footer {
    position: absolute;
    bottom: 10px;
    width: calc(100% - 20px);
    padding: 10px;
    text-align: center;
    font-size: 12px;
  }

  .content {
    padding: 15px;
  }

  .product-info {
    width: 100%;
    overflow: hidden;
    margin-bottom: 20px;
  }

  .product-details {
    float: left;
    width: 60%;
    padding: 15px;
  }

  .booking-form {
    float: right;
    width: 40%;
    padding: 15px;
    position: relative;
  }

  .reviews, .map, .activities {
    clear: both;
    padding: 15px;
    margin-top: 10px;
  }

  .review {
    width: 190px;
    height: 340px;
    margin: 5px;
    float: left;
    position: relative;
  }

  .review-popup {
    display: none;
    position: fixed;
    left: 50%;
    top: 50%;
    width: 400px;
    height: 700px;
    transform: translate(-50%, -50%);
    overflow-y: auto;
    z-index: 1000;
    padding: 20px;
  }

  .close-btn {
    position: absolute;
    right: 20px;
    top: 20px;
    cursor: pointer;
    font-size: 24px;
  }

  button {
    padding: 10px 20px;
    margin-top: 10px;
    border: none;
    background-color: #007bff;
    color: white;
    border-radius: 5px;
    cursor: pointer;
  }

</style>
</head>
<body>


<div class="content">
  <div class="product-info">
    <div class="product-details">
      <!-- 상품 상세 정보 -->
    </div>
    <div class="booking-form">
      <!-- 예약 버튼 -->
    </div>
  </div>

  <div class="reviews">
    <!-- 후기 -->
  </div>

  <div class="map">
    <!-- 지도 -->
  </div>

  <div class="activities">
    <!-- 주변 액티비티 및 식당 추천 -->
  </div>
</div>

<div class="review-popup" id="reviewPopup">
  <span class="close-btn" onclick="closeReviews()">&times;</span>
  <!-- 후기 내용 -->
</div>




</body>
</html>