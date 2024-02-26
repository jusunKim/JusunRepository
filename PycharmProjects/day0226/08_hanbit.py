# 이름대로 파일 저장
import re
import requests

url = "https://www.hanbit.co.kr/store/books/new_book_list.html"
text = requests.get(url).text
base = "https://www.hanbit.co.kr"
# <!-- 책 리스트 -->
# <!-- //책 리스트 -->
text1 = re.findall('<!-- 책 리스트 -->(.+?)<!-- //책 리스트 -->', text, re.DOTALL)
arr = re.findall('<img src="(.+)" alt="" class="thumb" />', text1[0])  # text1이 리스트니까 그의 0번째라는거
arr2 = re.findall('<p class="book_tit"><a href=".+?">(.+?)</a></p>',text1[0])
for i in range(len(arr)): #for each로 하는 이유: 지금 배열이 두개니까 인덱스가 필요함
    content = requests.get(base+""+arr[i]).content
    fname = arr2[i]+".jpg"
    fname= fname.replace("/"," ")
    f = open("./Data/hanB2/"+fname,"wb")
    f.write(content)
    f.close()
    print(fname+"다운받음")
print("모두 저장")