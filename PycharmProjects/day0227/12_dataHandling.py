import pandas as pd
import numpy as np

# mpg = pd.read_csv("../Data/mpg.csv")
# print(mpg.head())
# # catogory 종류는 몇가지일가?
# print(len(mpg['category'].value_counts()))
#
# # 연습) category가 compact, subcompact, 2seater이면 'small', 나머지는 'large'인 파생변수 size만들기
# mpg['size'] = np.where((mpg['category']=='compact')|(mpg['category']=='subcompact')|(mpg['category']=='2seater'),'small','large')
# print(mpg)
# print(mpg['size'].value_counts())

df_raw = pd.DataFrame({
    'var1':[1,2,1],
    'var2':[2,3,2]
})
print(df_raw)
df_new = df_raw.copy()
print(df_new)
'''
    변수(컬럼)명 바꾸기
    df.rename(columns={'원래이름':'바꿀이름',....})
    df.columns = ['컬럼1', '컬럼2', ...]
'''

# #연습) var1을 v1으로 컬럼명 바꿔보기
# df_raw = df_raw.rename(columns={'var1':'v1'})
# print(df_raw)

# 연습) df_new의 컬럼명을 kor, eng로 변경
df_new.columns = ['kor','eng']
print(df_new)