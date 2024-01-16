<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <style>
    .blur-background {
      filter: blur(5px);
      transition: filter 0.5s ease;
    }
    .fade-out {
      opacity: 0;
      transition: opacity 0.5s ease;
    }
    .fade-in {
      opacity: 1;
      transition: opacity 0.5s ease;
    }
    .popup-content{
      width: 400px;
      height: 200px;
      padding: 10px;
    }
    .close-popup-btn {
      cursor: pointer;
      float: right;
      font-size: 18px;
      font-weight: bold;
    }
    
    .popup {
	  position: fixed; /* 고정된 위치에 배치 */
	  top: 50%; /* 상단에서 50% 떨어진 위치에 배치 */
	  left: 50%; /* 왼쪽에서 50% 떨어진 위치에 배치 */
	  transform: translate(-50%, -50%); /* 중앙으로 이동 */
	  width: 400px; /* 팝업의 너비 */
	  height: 200px; /* 팝업의 높이 */
	  padding: 10px; /* 내부 여백 */
	}
  </style>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
  $(document).ready(function() {
    var showPopup = false;
    var popupContent = $('.popup-content');
    
    function openPopup(id) {
      showPopup = true;
      $('.popup').addClass('fade-in');
      $('.background').addClass('blur-background');
      popupContent.empty(); // 기존 내용 제거
      $.ajax({
        url: id + '.jsp', // Use the id to construct the URL
        success: function(data) {
          popupContent.html(data);
          popupContent.find('.close-popup-btn').on('click', function() {
            closePopup();
          });
          var popupWidth = popupContent.width(); // 불러온 JSP의 너비를 가져옴
          var popupHeight = popupContent.height(); // 불러온 JSP의 높이를 가져옴
          $('.popup').width(popupWidth); // 가져온 너비를 팝업의 너비로 설정
          $('.popup').height(popupHeight); // 가져온 높이를 팝업의 높이로 설정
        }
      });
    }
    
    function closePopup() {
      showPopup = false;
      $('.popup').removeClass('fade-in');
      $('.background').removeClass('blur-background');
      popupContent.empty(); // 내용 제거
    }
    
    $('.open-popup').click(function() {
      var buttonId = $(this).attr('id');
      if(!$(this).prop('disabled')) { // 버튼이 활성화 상태인지 확인
        openPopup(buttonId);
        $(this).prop('disabled', true); // 버튼 비활성화
      }
    });
  });
</script>
</head>
<body>
  <div class="background">
    <!-- index 페이지 내용 -->
    <h1>메인 페이지</h1>
    <p>팝업을 열려면 아래 버튼을 클릭하세요.</p>
    <button class="open-popup" id="login">로그인</button>
    <button class="open-popup" id="joinMember">회원가입</button>
    <button class="open-popup" id="payment">결제</button>
  </div>
  <div class="popup">
    <!-- 팝업 컨텐츠 -->
    <div class="popup-content">
      <!-- AJAX를 통해 동적으로 로드될 로그인 화면 -->
    </div>
  </div>
</body>
</html>