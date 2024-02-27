import pandas as pd
import numpy as np
# df = pd.read_csv("../Data/exam.csv")
# print(df)
# print(df.shape)
# print(df.head())
#
# a = [10,20,30,40]
# a = np.array(a)
# print(a.shape)
#
# b = np.array([[1,2,3,4],[5,6,7,8]])
# print(b.shape)
#
# a= [10,20,30]
# print(sum(a))
# print(max(a))

df = pd.read_csv("../Data/mtcars.csv")
print(df.head())
print(df.tail())
print(df.info())
print(df.index)
print(df.columns)
print(df.shape)
print(df.describe())