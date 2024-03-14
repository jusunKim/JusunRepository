import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn import datasets
data_url = "http://lib.stat.cmu.edu/datasets/boston"
raw_df = pd.read_csv(data_url, sep="\s+", skiprows=22, header=None)
data = np.hstack([raw_df.values[::2, :], raw_df.values[1::2, :2]])
target = raw_df.values[1::2, 2]
df = pd.DataFrame(data)
df.columns=[ 'CRIM','ZN','INDUS', 'CHAS' ,'NOX', 'RM' ,'AGE','DIS','RAD','TAX','PTRATIO' ,'B' ,'LSTAT'  ]

# 데이터프레임에 타겟을 설정하자
df_target = pd.DataFrame(target)
df_target.columns = ['Target']
df = pd.concat([df, df_target],axis=1) #합치기
df_corr = df.corr()
plt.figure(figsize=(10,10))
corr_order = df.corr().loc[:'LSTAT',"Target"].abs().sort_values(ascending=False)
#집값에 가장 영향을 많이 끼치는 4개 피처 'LSTAT','RM','PTRATIO','INDUS'
plot_cols = ['Target','LSTAT','RM','PTRATIO','INDUS']
plot_df = df.loc[:,plot_cols]
#피처 스케일링
from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()
df_scaler = df.iloc[:,:-1]
scaler.fit(df_scaler)
df_scaler = scaler.transform(df_scaler)
df.iloc[:,:-1] = df_scaler[:,:]

from sklearn.model_selection import train_test_split
X_data = df.loc[:,['LSTAT','RM']] #전체데이터로부터 학습시킬 문제에 해당하는 속성만 추출(type:DF)
y_data = df.loc[:,'Target'] #전체데이터로부터 학습시킬 답에 해당하는 속성 추출 (type:series)
#학습문제, 테스트문제, 학습답, 테스트답으로 split
X_train, X_test, y_train, y_test = train_test_split(X_data, y_data,
                                                    test_size=0.2, shuffle=True,random_state=20 )

#---------------------------------------------------------------
#그럼 차수에 따른 그래프를 확인해보자-실제데이터와 예측데이터의 산점도 비교
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures
import matplotlib.pyplot as plt
plt.figure(figsize=(15,5))
for idx, deg in enumerate([1,2,15]):
    ax1 = plt.subplot(1,3, idx+1)
    pf = PolynomialFeatures(degree=deg)
    X_train_poly = pf.fit_transform(X_train.loc[:,['LSTAT']])
    X_test_poly = pf.fit_transform(X_test.loc[:,['LSTAT']])
    model = LinearRegression()
    model.fit(X_train_poly,y_train)
    y_test_pred = model.predict(X_test_poly)
    #실제값 그래프 그리기
    plt.scatter(X_test.loc[:,"LSTAT"],y_test,label='target')
    #예측값 그래프 그리기
    plt.scatter(X_test.loc[:,"LSTAT"],y_test_pred,label='predict')
    #제목설정하기
    plt.title("Degree %d"% deg)
    #범례
    plt.legend()
plt.show()
