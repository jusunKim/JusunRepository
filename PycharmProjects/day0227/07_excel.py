import pandas as pd
import numpy as np
def notf():
    df1 = pd.read_excel("./Data/excel_exam.xlsx")
    print(df1)
    print(type(df1))
    #머리글 없는 엑셀파일 읽어들이기
    df2 = pd.read_excel("./Data/excel_exam_novar.xlsx",header=None)
    # 머리글 설정하기
    df2.columns = ['no','class','kor','eng','math']
    print(df2)
    print(type(df2))

df = pd.read_excel("./Data/excel_exam.xlsx")
print(df)

#연습) 영어점수의 평균 출력

print(df['english'].mean())
print(np.mean(df['english']))