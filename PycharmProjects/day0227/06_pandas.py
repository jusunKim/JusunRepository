import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("./Data/scores.csv")
print(df)
subject = ['kor','eng','mat','bio']
# df['avg'] = df[subject].sum(axis=1)/len(subject)
df['avg'] = df[subject].mean(axis=1)
dfOne = df[df['class']==1]
dfTwo = df[df['class']==2]
dfOne.index = dfOne.name
dfTwo.index = dfTwo.name
del dfOne['name']
del dfTwo['name']
print(dfOne)

# #성적을 막대그래프로 그리기
# dfOne[subject].plot(kind='bar')
# dfTwo[subject].plot(kind='bar')
dfOne[subject].plot(kind='box')
dfTwo[subject].plot(kind='box')

plt.show()