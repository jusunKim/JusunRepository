var http = require("http");
var express = require("express");
var app = express();

//public 폴더를 정적 컨텐츠 두는 곳으로 설정하기
//->public 폴더 안의 내용은 변경해도 서버 재가동 없이 바로 확인할 수 있삼.
app.use(express.static("public"));

app.use(function(req,res){
	res.send("<h1>안녕하세여</h1>");
});

http.createServer(app).listen(52273, function(){
	console.log("서버가동됨 http://127.0.0.1:52273");
});