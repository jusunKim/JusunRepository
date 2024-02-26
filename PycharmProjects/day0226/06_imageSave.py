import requests

url = "https://www.hanbit.co.kr/data/books/B2814543303_l.jpg"
# content = requests.get(url).text => 텍스트
# content = requests.get(url).content => 이미지

content = requests.get(url).content
f = open("./Data/새책.jpg","wb") #binaryfile이라는 뜻으로 모드에 wb
f.write(content)
f.close()
print("그림을 내려받앗습니다.")

