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
# 의사결정나무 알고리즘으로 회귀모형을 구현
# sklearn.tree.DecisionTreeRegressor
from sklearn.tree import DecisionTreeRegressor
model = DecisionTreeRegressor(max_depth=3, random_state=20) #의사결정나무 알고리즘의 회귀모델을 생성
model.fit(X_train,y_train) #학습시키기
y_train_pred = model.predict(X_train) #공부한 데이터 예측시키디
y_test_pred = model.predict(X_test) #공부한 데이터 예측시키디

# 오차 확인
from sklearn.metrics import mean_squared_error
# 공부한 데이터의 오류
train_mse = mean_squared_error(y_train,y_train_pred)
# 공부 안한 데이터의 오류
test_mse = mean_squared_error(y_test,y_test_pred)
print(train_mse) #17.80466555013512
print(test_mse) #21.381444384707162
