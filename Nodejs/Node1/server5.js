var http = require("http");
var express = require("express");
var app = express();

app.use(express.static("public"));
app.use(express.bodyParser());
app.use(app.router);

var bd = require("./bookDAO");

app.get("/listBook", async function(req,res){ //여기도 함수 async여야한대..
    var arr = await bd.listBook(); //listBook이 async함수여서 await을 써줘야한대...
    res.send(arr);
})

app.post("/insertBook", async function(req, res) {
  var doc = req.body;
  var re = await bd.insertBook(doc);
  res.send(re);
})

app.post("/updateBook",async function(req,res){
  var doc = req.body;
  var re = await bd.updateBook(doc);
  res.send(re);
})

app.post("/deleteBook",async function(req,res){
  var doc = req.body;
  var bookid = parseInt(doc.bookid);
  var re = await bd.deleteBook(bookid);
  res.send(re)
})

// 매개변수 192.168.0.111의 위치를 비워두면 기본값(localhost 또는 127.0.0.1)으로 설정되고, 비워두지 않고, ip주소를 채워넣으면 해당 ip주소로 접속이 가능한 것입니다.
http.createServer(app).listen(52273,"192.168.0.51",function(){
    console.log("서버가 가동되었습니다. http://192.168.0.51:52273");
});