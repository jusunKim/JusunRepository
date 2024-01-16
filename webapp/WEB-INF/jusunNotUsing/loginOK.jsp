<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .round-button {
        width: 100px;
        height: 100px;
        background-color: deeppink;
        border-radius: 50%;
        border: none;
        color: white;
        font-size: 16px;
        cursor: pointer;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .menu-list {
        display: none;
        position: absolute;
        top: 120px;
        left: 20px;
        background-color: #888;
        padding: 5px;
        border-radius: 5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .menu-list a {
        display: block;
        color: white;
        text-decoration: none;
        margin-bottom: 5px;
        padding: 2px;
        background-color: #444;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
</style>
</head>
<body>
	<div>
		<button class="round-button" onclick="showMenu()"> ${userID } </button>	
        <div id="menu" class="menu-list">
            <a href="https://www.example1.com">링크 1</a>
            <a href="https://www.example2.com">링크 2</a>
            <a href="https://www.example3.com">링크 3</a>
            <a href="https://www.example4.com">링크 4</a>
            <a href="https://www.example5.com">링크 5</a>
        </div>
	</div>

    <script>
        function showMenu() {
            var menu = document.getElementById('menu');
            menu.style.display = (menu.style.display === 'none' || menu.style.display === '') ? 'block' : 'none';
        }
    </script>
</body>
</html>

