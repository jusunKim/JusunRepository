# 모든 도서목록 csv로 저장. book.csv
import json
import requests

url = "http://192.168.0.51:52273/listBook" #노드에서 서버 실행해서 listBook요청한 거. 결과는 json
f=open("./Data/book.csv","w",encoding="utf-8")
text = requests.get(url).text
dicts = json.loads(text) #얘는 dict의 list임
for row in dicts:
    f.write(str(row['BOOKID'])+","+row['BOOKNAME']+","+str(row['PRICE'])+","+row['PUBLISHER']+"\n")
f.close()