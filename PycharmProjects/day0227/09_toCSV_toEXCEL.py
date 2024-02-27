import pandas as pd

name = ['홍길동','이순신','유관순']
kor = [80,90,100]
eng = [100,90,100]
math = [50,60,70]

df = pd.DataFrame({
    'name':name, 'kor':kor, 'eng':eng, 'math':math
})
print(df)

#csv로 저장하기
df.to_csv("./Data/student.csv",index=False)
#xlsx로 저장하기
df.to_excel("./Data/student.xlsx")
print("파일저장완")