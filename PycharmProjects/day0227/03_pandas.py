import numpy as np
import pandas as pd

df = pd.DataFrame({
    'name':['이순신','유관순','김유신','홍길동'],
    'kor':[90,80,60,70],
    'eng':[90,80,60,70],
    'math':[90,60,100,97],
    'bio':[90,60,100,97],
    'com':[90,60,100,97]
})

print(df)
# # print(sum(df['eng']))
# print(df['eng'].sum())
# print(df[['eng','kor','com']].sum())
# print(df[['eng','kor','com']].sum(axis=0))
# print(df[['eng','kor','com']].sum(axis=1))
#
# data = df[['eng','kor','com']]
# print(data.sum().sum())

# #컬럼 추가하는 법
# music = [100,90,90,90]
# df["music"] = music
# print(df)

subject = ['kor','eng','math','bio','com']
avg = df[subject].sum(axis=1)/len(subject)
df["avg"] = avg
print(df)

