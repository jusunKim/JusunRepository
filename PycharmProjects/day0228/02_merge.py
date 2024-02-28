import numpy as np
import pandas as pd

a = pd.DataFrame({
    'name':['이순신','유관순','홍길동'],
    'kor':[100,90,80]
})
b = pd.DataFrame({
    'name':['이순신','유관순','홍길동'],
    'eng':[60,70,80]
})

print(a)
print(b)

df = pd.merge(a,b)
print(df)