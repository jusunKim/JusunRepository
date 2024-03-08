# list = [
#     {'id':'tiger','name':'홍길동','age':20},
#     {'id':'kim','name':'김길동','age':30},
#     {'id':'park','name':'박길동','age':40}
# ]
#몽고디비랑 연동되게 코드를 수정해 보자
import pymongo
from pymongo import MongoClient

client = MongoClient("mongodb://localhost:27017/") #url과 포트번호 줌
db = client["sist2"] #db생성
collection = db["member"] #컬렉션생성



def listMember():
    return collection.find()

def insertMember(doc):
    return collection.insert_one(doc).inserted_id