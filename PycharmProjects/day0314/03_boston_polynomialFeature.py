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
#훈련데이터를 다항식으로 변경해보자
print(X_train.shape) #(404, 2)
print(X_train.head())
from sklearn.preprocessing import PolynomialFeatures
# pf = PolynomialFeatures(degree=2) #2차로 만들게삳
pf = PolynomialFeatures(degree=15) #2차로 만들게삳
X_train_poly = pf.fit_transform(X_train)
print(type(X_train_poly)) #<class 'numpy.ndarray'>
print(X_train_poly.shape) #(404, 6)
print(X_train_poly[:5,:])
# #[[1.         0.48068433 0.50028741 0.23105742 0.24048032 0.25028749]
#  [1.         0.03945916 0.74899406 0.00155703 0.02955468 0.5609921 ]
#  [1.         0.098234   0.60662962 0.00964992 0.05959165 0.3679995 ]
#  [1.         0.575883   0.41233953 0.33164123 0.23745933 0.17002389]
#  [1.         0.4334989  0.61084499 0.18792129 0.26480063 0.3731316 ]]

#다항식으로 변환된 문제를 갖고 공부시키기
from sklearn.linear_model import LinearRegression
model = LinearRegression()
model.fit(X_train_poly, y_train)

#예측시키려면테스트데이터도 다항식으로 바꾸고 나서 해야댐
X_test_poly = pf.fit_transform(X_test)

#공부한 데이터 예측시키기
y_train_pred = model.predict(X_train_poly)
#공부안한데이터 예측시키기. 이 두 차이가 작어야 좋은거
y_test_pred = model.predict(X_test_poly)

from sklearn.metrics import mean_squared_error
#공부한 데이터의 mse
train_mse = mean_squared_error(y_train,y_train_pred)
#공부안한데이터의 mse
test_mse = mean_squared_error(y_test,y_test_pred)

print(train_mse) #20.827788491560497
print(test_mse) #19.561734273954958

# 어제 일차항으로 했을 때는 31, 26 정도씩 나왔었음. 차이가 줄엇삼.
#=> 일반적으로 차수 높이면 성능이 좋긴한데
# 근데 degree를 15로 바꾸면 59이랑 3059306 이정도의 차이가 남. 과대적합이 일어낫삼.
# 냅다 높인다고좋은건아님