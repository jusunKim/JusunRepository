var http = require("http");
var express = require("express");
var app = express();

app.use(express.static("public"));
app.use(express.bodyParser());
app.use(app.router);

var dao = require("./bookDAO");


app.get("/listBook", async function(req,res){ //
    var arr = await dao.listBook();
    res.send(arr);
})

app.post("/insertBook", async function(req, res) {
    var doc = req.body;
    var re = await dao.insertBook(doc);
    res.send(re+""); //send()는 문자열만 전송할 수 있다네...
  })


  app.post("/updateBook",async function(req,res){
    var doc = req.body;
    var re = await dao.updateBook(doc);
    res.send(re+"");
  })

  app.post("/deleteBook",async function(req,res){
    var doc = req.body;
    var bookid = doc.bookid; //parseInt로..안해도되나벼..
    var re = await dao.deleteBook(bookid);
    res.send(re+"")
  })

http.createServer(app).listen(52273,"192.168.0.51",function(){
    console.log("서버가 가동되었습니다. http://192.168.0.51:52273");
});