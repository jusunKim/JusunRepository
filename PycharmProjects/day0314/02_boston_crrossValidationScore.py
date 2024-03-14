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
#회귀모형도 교차검증을 할수잇음.
from sklearn.model_selection import cross_val_score

# 교차검증에 쓸 선형회귀모델을 생성
from sklearn.linear_model import LinearRegression
model = LinearRegression()

#교차검증
mse_scores = -1*cross_val_score(model, X_train, y_train, cv=5, scoring='neg_mean_squared_error')
#cv: 몇 번 교차검증할 건지
#scoring: 공부의 방향성: mean_squared_error를 줄이는 방향으로 공부하라는 소리
# cross_val_score은 음수반환해서,,[-46.17659189 -35.2914494  -25.4014603  -31.48614464 -28.79276438]
# 깅까 양수를 만들기 위해서 -1을 곱한 거임
print(mse_scores) #[46.17659189 35.2914494  25.4014603  31.48614464 28.79276438]
print(np.round(mse_scores,4))
print(np.mean(mse_scores))
