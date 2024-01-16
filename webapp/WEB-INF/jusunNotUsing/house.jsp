<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#p_titleImg{
		text-align:left;
    	margin: 0 auto;
    	
	}
	
    h2 {
        padding: 10px;
        text-align:left;
    }
	
	/* 이미지 */
	.detail_images {
    	margin-top: 20px;
   	 	margin-bottom: 20px;
	}
  	.main-image, .image-gallery, .image {
    	float: left;
    	border-radius: 30px; /* Rounded corners as per request */
  	}
  
  	.main-image {
    	width: 485px;
   		height: 350px; 
    	margin-right: 20px;
  	}
  	
  	.image-gallery {
    	width: 485px; 
    	height: 350px; 
  	}
  	.image-row {
    	display: flex;
    	justify-content: space-between;
    	margin-bottom: 10px;
  	}
  	.image {
   		width: 232px; 
    	height: 165px;
    	margin-right: 20px;
  	} 
  
  	img {
    	width: 100%;
    	height: 100%;
    	display: block;
    	border: 1px solid #ddd;
    	border-radius: 30px;
    	padding: 5px;
    	object-fit: cover;
  	}

    #p_detail {
        text-align: left;
        /* clear:both; */
        width:485px;
        float:left;
        overflow: auto;
    }
    
    #p_info {
        width:485px;
        height: 600px; 
        border-radius: 30px;
        margin-bottom: 20px; 
    }


	/* 편의시설 */
    #amenity {
        margin-bottom: 20px; 
    }
    	
	#amenity_img{
		width:490px;
		margin : 20px auto;
		overflow: auto;		
		background-color:yellowgreen;
	}
	
    #amenity_img > img {
        width: 240px; 
        height: 110px; 
        float: left; 
        margin-right: 10px; 
        margin-bottom: 10px;
        border-radius: 30px;
    }
     #amenity_img::after {
        content: "";
        clear: both;
        display: table;
    }   

</style>
</head>
<body>
	<!-- 컨텐트 1 : 상품명, 이미지 -->
<!-- 상품이미지-->		
<div class="detail_images">
  <div class="main-image">
    <img src="images/banner1.jpeg" alt="메인 이미지">
  </div>
  <div class="image-gallery">
    <div class="image-row">
      <div class="image">
        <img src="images/banner2.jpeg" alt="이미지 1">
      </div>
      <div class="image">
        <img src="images/banner3.jpeg" alt="이미지 2">
      </div>
    </div>
    <div class="image-row">
      <div class="image">
        <img src="images/banner4.jpeg" alt="이미지 3">
      </div>
      <div class="image">
        <img src="images/banner5.jpeg" alt="이미지 4">
      </div>
    </div>
  </div>
</div>
	
	<!-- 컨텐트 2 : 상품상세정보, 결제창-->	
	<div id = "p_detail">
		<div id = "p_detailName">
			<h2> 상품명 ${p.p_name }</h2>
		</div>
		<div id = "amenity">
			<h2>편의시설</h2>
			<hr>	
		
			<div id = "amenity_img">
				<img src = "">
				<img src = "">
				<img src = "">
				<img src = "">
			</div>
		</div>
		
		<div id = "p_info">
		
		</div>
	</div>
	
	<!-- 네비게이터 -->
	<div id = r_nav></div>
	
	<!-- 숙소후기 -->
	<div id = review></div>
	
	<!-- 위치 지도 -->
	<div id = detail_map></div>
	
	<!-- 맛집추천 -->
	
</body>
</html>