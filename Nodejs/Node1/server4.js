var http = require("http");
var express = require("express");
var app = express();

app.use(express.static("public"));
app.use(express.bodyParser());
app.use(app.router);

var data;
let client;
const {MongoClient} = require("mongodb");
const uri = "mongodb://localhost:27017";

app.get("/listBook",function(req,res){
    async function run() {
        try {
          client = new MongoClient(uri);
          const database = client.db('madang');
          const book = database.collection('book');
          const data = await book.find().toArray(); //find()는 커서를 반환하기 때문에 toArray작업까지 해줍니다.
          res.send(data);
        } finally {
          await client.close();
        }
      }
      run().catch(console.dir);
})



app.post("/insertBook", function(req, res) {
    var doc = req.body;
    async function run() {
        try {
         client = new MongoClient(uri);
          const database = client.db('madang');
          const book = database.collection('book');
          const obj = await book.find({}).sort({bookid:-1}).toArray();
          console.log(obj);
          bookid = obj[0].bookid+1;
          doc.bookid = bookid;
          doc.price = parseInt(req.body.price);
          await book.insertOne(doc)
          console.log(doc);
          res.send(doc);
        } finally {
          await client.close();
        }
      }
      run().catch(console.dir);
});

app.post("/updateBook",function(req,res){
    var doc = req.body;
    var bookid = parseInt(req.body.bookid);
    var bookname = req.body.bookname;
    var price = parseInt(req.body.price);
    var publisher = req.body.publisher;
    
    console.log(bookid+" "+bookname+" "+price+" "+publisher);
    async function run(){
        try{
            client = new MongoClient(uri);
            const database = client.db('madang');
            const book = database.collection('book');
            await book.updateOne(
                { bookid: bookid},
                {
                  $set: { 'bookname': bookname, 'price':price, 'publisher':publisher },
                  $currentDate: { lastModified: true }
                }
              );
          console.log(doc);
          res.send(doc);
        }finally{
            await client.close()
        }
    }
    run().catch(console.dir);
})


// 매개변수 192.168.0.111의 위치를 비워두면 기본값(localhost 또는 127.0.0.1)으로 설정되고, 비워두지 않고, ip주소를 채워넣으면 해당 ip주소로 접속이 가능한 것입니다.
http.createServer(app).listen(52273,"192.168.0.51",function(){
    console.log("서버가 가동되었습니다. http://192.168.0.51:52273");
});