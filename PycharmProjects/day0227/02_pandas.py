import numpy as np
import pandas as pd

def f():
    s = pd.Series([5,1,2,9])
    print(s)
    # print(s.index)
    # print(s.values)
    # print(type(s.values))

    s = pd.Series([5,1,2,9], index=['kor','eng','math','com'])
    print(s)
    print(s['kor'])
    print(s[0])

    a = [10,20,30,40]
    b = {'kor':10,'eng':20,'mat':30,'com':40}
    s1= pd.Series(a)
    s2= pd.Series(b)
    print(s1)
    print(s2)

    df = pd.read_csv("./Data/scores.csv")
    print(df)
    print(type(df))
    name = df['name']
    kor = df.kor
    print(name)
    print(type(name))
    print(kor)
    print("-"*50)
    print(df.index)
    # print(df.columns)
    # print(df.values)

    df = pd.read_csv("./Data/scores.csv")
    df.kor

    df = pd.read_csv("./Data/scores.csv")
    #행(레코드)에 대한 접근
    # print(df[0]) 이렇게 하면 안됨. 오륜
    a = df.loc[0]
    print(a)

    df = pd.read_csv("./Data/scores.csv")
    print(df)
    #학생 이름을 인덱스로 설정하기
    df.index = df.name
    print(df)
    #데이터프레임에서 이름열삭제
    del df['name']
    print(df)

    a = df.loc['ben'] #문자 인덱스 접근 loc
    print(a)

    b = df.iloc[3] #숫자 인덱스 접근 iloc
    print(b)

    df = pd.read_csv("./Data/scores.csv")
    df.index = df.name
    del df['name']
    print(df)
    a = df.loc['ben':'paul']
    print(a)
    b = df.iloc[2:7]
    print(b)

df = pd.read_csv("./Data/scores.csv")
kor = df['kor']
print(kor)
print(type(kor))
# data = df[['kor','mat','eng']]
subject = ['mat','kor','eng']
data = df[subject]
print(data)
print(type(data))