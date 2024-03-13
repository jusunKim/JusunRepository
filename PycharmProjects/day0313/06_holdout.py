import pandas as pd
import numpy as np
from sklearn import datasets
iris = datasets.load_iris()
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split

# sepal_length  sepal_width  petal_length  petal_width  Target
df = pd.DataFrame(iris['data'], columns=iris['feature_names'])
df.columns = ['sepal_length','sepal_width','petal_length','petal_width']
df['Target'] = iris['target']
df = df.drop_duplicates()
X_data = df.loc[:, 'sepal_length':'petal_width']
y_data = df.loc[:,'Target']
X_train, X_test, y_train, y_test = train_test_split(
    X_data,
    y_data,
    test_size=0.2,
    shuffle=True,
    random_state=20
) #전체데이터로부터 학습데이터/테스트데이터 분리한 상태

#학습데이터: X_train, y_train
#테스트데이터: X_test, y_test에 들어가 있는 상태임

#위의 분리된 학습 데이터를 다시 gns련데이터와 검증데이터로 분리해야 교차 검증

#학습데이터의 shape를 확인해보자
print(X_train.shape) #(119, 4)
print(y_train.shape) #(119,)
# 얘를 다시 훈련데이터랑 검증데이터로 나누자
X_tr, X_val, y_tr, y_val = train_test_split(
    X_train, y_train,
    test_size=0.2, shuffle=True, random_state=20
)
print(X_tr.shape, y_tr.shape) #(95, 4) (95,)
print(X_val.shape, y_val.shape) #(24, 4) (24,)

#학습할 모델을 생성
from sklearn.ensemble import RandomForestClassifier
model = RandomForestClassifier( max_depth=5, random_state=20) #n_estimators를 생략하면 기본이 100개임

#학습을 시키자
model.fit(X_tr,y_tr)

#공부한 데이터를 예측시키기
y_tr_pred = model.predict(X_tr) #공부한 거를 문제풀이시킴
#검증 데이터를 예측시키기
y_val_pred = model.predict(X_val) #공부 안 한거를 문제풀이시킴

#성능평가
from sklearn.metrics import accuracy_score
tr_acc = accuracy_score(y_tr, y_tr_pred) #공부한 거의 성능
val_acc = accuracy_score(y_val, y_val_pred) #공부 안한 거의 성능
print("공부한 것에 대한 성능:",tr_acc) #공부한 것에 대한 성능: 1.0
print("검증데이터에 대한 성능:",val_acc) #검증데이터에 대한 성능: 0.875

#테스트 데이터로 예측시키고 성능 확인
y_test_pred = model.predict(X_test)
test_acc = accuracy_score(y_test, y_test_pred)
print("테스트데이터에 대한 성능:",test_acc)

'''
과적합 overfit
모델이 공부한 것만 잘 맞히고 새로운 데이터에 대해서는 예측을 잘 못함

'''