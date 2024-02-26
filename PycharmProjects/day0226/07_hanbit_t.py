import re
import requests
url = "https://www.hanbit.co.kr/store/books/new_book_list.html"
text = requests.get(url).text
base = "https://www.hanbit.co.kr"
# <!-- 책 리스트 -->
# <!-- //책 리스트 -->
text1 = re.findall('<!-- 책 리스트 -->(.+?)<!-- //책 리스트 -->',text,re.DOTALL)
arr = re.findall('<img src="(.+)" alt="" class="thumb" />',text1[0]) #text1이 리스트니까 그의 0번째라는거
i=1
for row in arr:
    content = requests.get(base+""+row).content
    f = open("./Data/hanB/book_"+str(i)+".jpg","wb")
    f.write(content)
    f.close()
    print("book_"+str(i)+"을 저장했습니다")
    i+=1
    
print("저장 완료")