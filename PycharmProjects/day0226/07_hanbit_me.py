#한빛츌펀서의 새책이미지모두다운받기.

import re
import requests

for i in range(1,80):
    url = "https://www.hanbit.co.kr/store/books/new_book_list.html?page="+str(i)+"&brand=&cate1=&cate2=&searchKey=&keyWord="
    text = requests.get(url).text
    bookSrc = re.findall('<img src="(.+)" alt="" class="thumb" />',text)

    for src in bookSrc:
        iurl = "https://www.hanbit.co.kr"+src
        content = requests.get(iurl).content
        f=open("./Data/hanbitBooks/"+src[-17:],"wb")
        f.write(content)
        f.close()
        print(src[-17:]+"다운")
print("다운완료")