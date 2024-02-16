var http = require("http");
var express = require("express");

var app = express(); //익스프레스 객체 생성
app.use(express.static("public")); //static 미들웨어
app.use(app.router); //router미들웨어->사용자 요청에 따라 각각 다른 서비스

app.all("/list.do",function(req,res){ //이런 요청이 있을 때 이게 동작(요청명, 콜백함수(요청,응답))
    res.send("<h1>글 목록 보기</h1>");
}); 

app.all("/write.do",function(req,res){
    res.send("<h1>글 작성하기</h1>");
}); 

app.all("/update.do",function(req,res){
    res.send("<h1>글 수정하기</h1>");
}); 

http.createServer(app).listen(52273,function(){
    console.log("서버 가동되엇습니다. http://127.0.0.1:52273")
});