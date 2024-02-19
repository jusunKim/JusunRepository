const {MongoClient} = require("mongodb");
const uri = "mongodb://localhost:27017";
let client;

async function listBook() {
  let data; //중괄호 안에서 data를 선언하면 그 밖에서 사용을 못해가지고 미리 밖에다해놓기
  try {
    client = new MongoClient(uri);
    const database = client.db('madang');
    const book = database.collection('book');
    data = await book.find().toArray(); 
  } finally {
    await client.close();
  }
  return data; //반환값을 줘
}

async function insertBook(doc){
  try {
    client = new MongoClient(uri);
     const database = client.db('madang');
     const book = database.collection('book');
     const obj = await book.find({}).sort({bookid:-1}).toArray();
     bookid = obj[0].bookid+1;
     doc.bookid = bookid;
     doc.price = parseInt(doc.price);
     await book.insertOne(doc)
   } finally {
     await client.close();
   }
   return doc;
}

async function updateBook(doc){
  
    var bookid = parseInt(doc.bookid);
    var bookname = doc.bookname;
    var price = parseInt(doc.price);
    var publisher = doc.publisher;
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
  }finally{
    await client.close()
  }
  return doc
}

async function deleteBook(bookid){
  let doc;
  try{
    doc = { bookid: bookid};
    client = new MongoClient(uri);
    const database = client.db('madang');
    const book = database.collection('book');
    await book.deleteOne(doc);
  }finally{
    await client.close()
  }
  return doc
}

module.exports={listBook, insertBook, updateBook, deleteBook}