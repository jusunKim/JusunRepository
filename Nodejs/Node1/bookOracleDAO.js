const oracledb = require('oracledb');
oracledb.outFormat = oracledb.OUT_FORMAT_OBJECT;
const mypw = "madang";

async function listBook(){
    const connection = await oracledb.getConnection({
        user:"c##madang", password : mypw, connectString :"localhost/XE"
    })
    const result = await connection.execute( 'select * from book' ); //execute
    await connection.close();
    return result.rows;
}

async function deleteBook(bookid){
    const connection = await oracledb.getConnection({
        user:"c##madang",  password : mypw,connectString :"localhost/XE"
    })
    sql = 'delete book where bookid='+bookid //이런식으로해도됨
    const result = await connection.execute(sql);  //execute
    connection.commit(); //autocommit을 할 상황이 아니면 이걸 쓰삼
    console.log(result.rowsAffected);
    await connection.close();
    return result.rowsAffected;
}

async function updateBook(doc){
    const connection = await oracledb.getConnection({
        user:"c##madang",  password : mypw,connectString :"localhost/XE"
    })
    const result = await connection.execute(`update book set bookname = :bookname, price=:price, publisher=:publisher where bookid=:bookid`, //execute
     doc, {autoCommit:true}); //커밋을 안해서 계속 안됨....
    await connection.close();
    return result.rowsAffected;
}

async function insertBook(doc){
    var bookid = await getNextNo(); 
    const connection = await oracledb.getConnection({
        user:"c##madang",  password : mypw, connectString :"localhost/XE"
    })
    doc.bookid = bookid;
    const result = await connection.execute(`insert into book(bookid,bookname,price,publisher) values(:bookid,:bookname,:price,:publisher)`, //execute
     doc, {autoCommit:true}); //커밋을 안해서 계속 안됨....
    console.log(result.rowsAffected);
    await connection.close();
    return result.rowsAffected;
}


async function getNextNo(){
    const connection = await oracledb.getConnection({
        user:"c##madang",  password : mypw, connectString :"localhost/XE"
    })
    const result = await connection.execute( //execute
        'select nvl(max(bookid),0)+1 as nextid from book'
    );
    await connection.close();
    return result.rows[0].NEXTID; //db에서 열이름 가져오는거는 대문자여야돼서그런듯..
}

module.exports={listBook, insertBook, getNextNo, updateBook, deleteBook}