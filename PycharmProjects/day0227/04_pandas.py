import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("./Data/scores.csv")
print(df)
subject = ['kor' ,'eng' ,'mat' ,'bio']
df['avg']=df[subject].sum(axis=1)/len(subject)
print(df)
print(df.head(7))

#평균 기준으로 정렬
df2 = df.sort_values('avg')
# df2 = df.sort_values('avg',ascending=False)
print(df2)
print(df)

#정렬된 데이터프레임에 인덱스를 학생 이름으로 설정하고 데이터프레임의 이름 속성 삭제
# 상위2개 데이터만 출력
df2.index = df2.name
del df2['name']
print(df2.head(2))

df2['avg'].plot(kind='bar') #판다스의 plot함수 이용
plt.show()