import pandas as pd
import numpy as np
# 파생변수 : 의미있는 분석을 위해 주어진 변수 이용해 새로운 변수 만들
# df = pd.DataFrame({
#     'var1' : [4,3,8],
#     'var2' : [2,6,11]
# })
#
# print(df)
# df['var_total'] = df['var1']+df['var2']
# df['var_mean'] = df['var_total']/2
# print(df)

#
df = pd.read_csv("../Data/mpg.csv")
# print(df.head())
# print(df.tail())
# print(df.index)
# print(df.shape)
# print(df.columns)
# print(df.info())
# print(df.describe())

df['total'] = (df['cty'] + df['hwy'])/2
print(df)
print(df['total'].mean())
print('-'*50)

# 기준값에 따라 파생변수 만들기
print(df['total'].describe())

'''
   변수= np.where(조건식,값1, 값2)
'''
#20을 기준으로 20이상이면 패스 아니면 fail을 갖는 파생변수 test만드기
test = np.where(df['total']>=20,'pass','fail')
df['test'] = test
print(df)

#탐색적 데이터 분석 EDA
# index, columns, head, tail, info, describe, value_counts()

# 파생변수 추가 등등..

print(df['test'].value_counts())

#연습) 통합연비에 따라 등급을 위한 파생변수 grade 추가하기
df['grade'] = np.where(df['total']>=25,np.where(df['total']>=30,'A','B'),np.where(df['total']>=20,'C','D'))
print(df.head(50))
print(df['grade'].value_counts())