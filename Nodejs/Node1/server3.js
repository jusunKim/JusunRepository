var items = [
    {name:"우유", price:2000},
    {name:"홍차", price:2000},
    {name:"커피", price:2000},
    
]

var http = require("http");
var express = require("express");
var app = express();

//미들웨어 설정
app.use(express.static("public"));
app.use(express.bodyParser()); //post방식의 데이터 처리를 위해 필요
app.use(app.router);

//post방식
app.post("/products",function(req,res){
    try {
        var name = req.param("name");
        var price = req.param("price");
        console.log("name"+name);
        console.log("price"+price);
        //넘어온 데이터를 배열에 추가하기
        var item = { //이런 형태를 document라고 한다네.. noSql에서,.
            name:name,
            price:price
        }
        items.push(item); //items배열에다가 사용자한테 입력받은 값으로 만든 item객체 추가
        res.send({ //객체 형태로 응답하기. 내맘대로만듦.
            message:"데이터를 추가했습니다",
            data:items
        })
    } catch (e) {
        console.log(e)
    }
})

app.get("/products",function(req,res){
    res.send(items);
})

app.get("/products/:id",function(req,res){
    var id = Number(req.param("id")); //parameter받아오면 어쨌든 문자취급되니까 걔를 숫자로바꿈
    if(isNaN(id)){
        res.send({error:"숫자를 입력하세요"});
    }else if(items[id]){ //js는 조건문 안에 불린이 아니라 0이외의값은 참으로 본다네
        res.send(items[id]);
    }else{
        res.send({error:"존재하지 않는 데이터입니다"});
    }
})

app.all("/wiki/:id", function(req,res){ //uri방식으로 전달받기. {}가 아니라 :를 쓴다
    var id = req.param("id");
    res.send("<h1>"+id+"</h1>")
})

//html로 응답하게
app.all("/data1", function(req,res){
    var output = "";
    output += "<!DOCTYPE html>";
    output += "<html>";
    output += "<body>";
    items.forEach(function(item){
        output += "<div>";
        output += "<h1>"+item.name+"</h1>";
        output += "<h2>"+item.price+"</h2>";
        output += "</div>";
    });
    output += "</body>";
    output += "</html>";
    
    res.send(output);   
});

//json으로 응답하게
app.all("/data2", function(req,res){
    res.send(items);
});

//xml로 응답하게
app.all("/data3", function(req,res){
    var output = "";
    res.type("text/xml");
    output += "<?xml version='1.0' encoding='UTF-8'?>";
    output += "<products>";
    items.forEach(function(item){
        output+="<product>";
        output+="<name>"+item.name+"</name>";
        output+="<price>"+item.price+"</price>";
        output+="</product>";
    });
    output += "</products>";
    res.send(output);   

});

http.createServer(app).listen(52273,function(){
    console.log("서버 가동되엇습니다. http://127.0.0.1:52273")
});