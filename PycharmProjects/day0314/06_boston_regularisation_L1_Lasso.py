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
'''
    규제Regularization
모델의 복잡도를 낮추면 과대적합을 억제할 수 있다.
모 델을 설명하는 각 피처가 모델의 예측 결과에 미치는 영향력을 가중치(회귀계수)로 표현하는데,
이런 가중치들이 커지면 페널티를 부과 하여 가중치를 낮은 수준으로 유지 한다.
이처럼 모델의 구조가 복잡해지는 것을 억제하는 방법이 규제
- L2규제: 가중치의 제곱합에 패널티 sklearn.linear_model.Ridge
- L1규제: 가중치의 절대값의 합에 패널티 sklearn.linear_model.Lasso
ElasticNet: L1,L2규제를 모두 적용
'''
#<<L2규제 실습>>
from sklearn.preprocessing import PolynomialFeatures

#x를 15차항으로 변환해보자
pf = PolynomialFeatures(degree=15)
X_train_poly = pf.fit_transform(X_train.loc[:,['LSTAT']])
X_test_poly = pf.fit_transform(X_test.loc[:,["LSTAT"]])

#선형회귀모델에 +L1규제를 적용한 Lasso를 생성해 보자
from sklearn.linear_model import Lasso
model = Lasso(alpha=2.5)
model.fit(X_train_poly,y_train) #학습시키기
y_train_pred = model.predict(X_train_poly) #공부한 거에 대한 예측시키기
y_test_pred = model.predict(X_test_poly) #공부 안한 거에 대한 예측시키기

#오차 확인
from sklearn.metrics import mean_squared_error
train_mse = mean_squared_error(y_train,y_train_pred)
test_mse = mean_squared_error(y_test,y_test_pred)

print(train_mse) #89.20835426673854
print(test_mse) #65.71643121180931

