<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문의하기</title>
    <!-- 부트스트랩 CSS 링크 추가 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #f5f5f5;
        }

        #qnaForm {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* 그림자 색상을 더 짙게 조절 */
        }

        h2 {
            color: #007bff;
            margin-bottom: 20px;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
        }

        label {
            margin-bottom: 5px;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            max-width: 600px;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        textarea {
            width: 100%;
            max-width: 600px;
            height: 300px; /* 고정된 높이값 */
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            overflow-y: auto; /* 세로 스크롤 추가 */
            resize: none; /* textarea 크기 조절 비활성화 */
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div id="qnaFormManager">
        <form action="updateQna.do" method="post">
            <br>
            <h2>문의하기 답변[관리자]</h2>
            <hr>
            <div class="mb-3">
                <label for="q_title" class="form-label">제목:</label>
                <input type="text" id="q_title" name="q_title" class="form-control" disabled>
            </div>
            <div class="mb-3">
                <label for="q_content" class="form-label">내용:</label>
                <textarea id="q_content" name="q_content" class="form-control" disabled>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Consequat semper viverra nam libero justo. Consequat interdum varius sit amet mattis vulputate enim nulla aliquet. Ultricies lacus sed turpis tincidunt. Adipiscing commodo elit at imperdiet dui. Ut sem viverra aliquet eget sit amet tellus cras adipiscing. Massa ultricies mi quis hendrerit dolor magna eget est lorem. Ac felis donec et odio pellentesque diam. Amet dictum sit amet justo donec enim diam vulputate ut. Euismod in pellentesque massa placerat duis. Nibh tellus molestie nunc non blandit massa enim nec. Viverra tellus in hac habitasse platea dictumst vestibulum rhoncus. Facilisis leo vel fringilla est ullamcorper eget. Morbi non arcu risus quis varius quam. Commodo elit at imperdiet dui accumsan sit amet nulla facilisi. Faucibus et molestie ac feugiat sed lectus. Leo vel fringilla est ullamcorper eget nulla facilisi etiam dignissim.

Quis hendrerit dolor magna eget est lorem ipsum. Consectetur adipiscing elit duis tristique sollicitudin nibh sit amet commodo. Mauris ultrices eros in cursus turpis massa tincidunt dui. Urna condimentum mattis pellentesque id nibh tortor id aliquet lectus. Phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec. Lacus vestibulum sed arcu non odio euismod lacinia at quis. Sed vulputate mi sit amet mauris commodo. In hendrerit gravida rutrum quisque non tellus orci ac. In cursus turpis massa tincidunt dui ut ornare lectus sit. Nibh sed pulvinar proin gravida hendrerit lectus a. Nisi vitae suscipit tellus mauris a diam. Amet dictum sit amet justo donec enim diam. Cursus metus aliquam eleifend mi. A condimentum vitae sapien pellentesque. Eget nullam non nisi est. Enim nec dui nunc mattis enim. Eu volutpat odio facilisis mauris.

Curabitur gravida arcu ac tortor dignissim convallis. Arcu vitae elementum curabitur vitae nunc sed velit. Sed vulputate odio ut enim blandit volutpat. Sagittis eu volutpat odio facilisis. Ac placerat vestibulum lectus mauris ultrices eros in cursus turpis. Amet luctus venenatis lectus magna fringilla urna. Ultrices dui sapien eget mi proin. Turpis massa sed elementum tempus egestas. Facilisis mauris sit amet massa vitae tortor condimentum. Semper feugiat nibh sed pulvinar proin gravida hendrerit. At tellus at urna condimentum mattis. Nam at lectus urna duis convallis convallis tellus id. Mauris vitae ultricies leo integer. Pellentesque habitant morbi tristique senectus et netus.

Et tortor at risus viverra adipiscing. Arcu non sodales neque sodales ut etiam sit amet nisl. Pellentesque massa placerat duis ultricies. Senectus et netus et malesuada. Nunc faucibus a pellentesque sit amet porttitor eget. Rhoncus dolor purus non enim praesent elementum facilisis. Tristique magna sit amet purus gravida quis. Enim ut sem viverra aliquet eget sit. Massa sapien faucibus et molestie ac feugiat sed lectus. Diam in arcu cursus euismod quis. Ut eu sem integer vitae. Nulla facilisi nullam vehicula ipsum a arcu. Suspendisse sed nisi lacus sed. Vestibulum rhoncus est pellentesque elit ullamcorper dignissim. Tempus iaculis urna id volutpat lacus. Consectetur adipiscing elit pellentesque habitant morbi tristique senectus et netus.

Id diam maecenas ultricies mi eget mauris pharetra et. Sem fringilla ut morbi tincidunt augue interdum velit. Lectus urna duis convallis convallis tellus id interdum velit. Velit aliquet sagittis id consectetur purus ut faucibus. Ullamcorper eget nulla facilisi etiam dignissim diam. Quisque id diam vel quam elementum pulvinar etiam. Nulla pharetra diam sit amet nisl. Malesuada bibendum arcu vitae elementum curabitur vitae. Pellentesque habitant morbi tristique senectus et netus et. Sed vulputate odio ut enim. $(q_content) }</textarea>
            </div>
            <br>
           
            <div class="mb-3">
                <label for="a_content" class="form-label">답변:</label>
                <textarea id="a_content" name="a_content" class="form-control"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>
