import pandas as pd
import numpy as np
import seaborn as sns

df = pd.read_csv("../Data/mpg.csv")
print(df.head())

#1) 배기량에 따라 고속도로 연비가 다른지(displ배기량이 4이하인자동차와 5이상인 차 중 어떤 게 hwy가 더 높을까)
print(df['displ'])
print(df['displ'].max())
print(df['displ'].min())

df1 = df[df['displ']<=4]
df2 = df[df['displ']>=5]

print(len(df1))
print(len(df2))

print(df1['hwy'].mean()) #25.96319018404908
print(df2['hwy'].mean()) #18.07894736842105

print(df.query("displ<=4")['hwy'].mean()) #25.96319018404908
print(df.query("displ>=5")['hwy'].mean()) #18.07894736842105

#2.audi와 toyota 중 어느 manufacturer의 cty평균이 높을까
# df2 = df.query('manufacturer in ["audi","toyota"]').groupby('manufacturer',as_index=False).agg(cty_mean=('cty','mean'))
df2 = df.query('manufacturer in ["audi","toyota"]').pivot_table(values='cty',index='manufacturer')
print(df2)

