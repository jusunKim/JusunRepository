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
)

# 둘중에 하나 선택하는 공부방법                      ==> 의사결정나무(DecicionTrreeClassifier)
# 여러개 중에 어디에 해당하는지 분류하는 공부방법      ==> K-최근접이웃(KNN - K Nearest Neighbrs)
#       --> 나와 가장 가까운 k를 뽑아서 그중에 가장 많은 빈도에 속하도록 하는 방법



# from sklearn.svm import SVC
# model = SVC(kernel="rbf")
from sklearn.linear_model import LogisticRegression #모델만 바꾸기
model = LogisticRegression()


model.fit(X_train, y_train)
pred = model.predict(X_test)

print(X_train.head())
print(y_train.head())

from sklearn.metrics import accuracy_score
acc = accuracy_score(y_test, pred)
print("정확도:", acc)

# 1.0 얘는 어제 svm으로 나온 거
# LogisticRegression의 결과도 1 나왓음.

# 각 품종별(클래스별) 확률값을 출력해봅시다
# model.predict_proba(문제) => 각 품종별 확률값을 알려줌
# model.predict(문제) => 결과 예측

y_pred = model.predict(X_test)              #1 분류 결과가 나옴
y_pred_prop = model.predict_proba(X_test)   #0.1 0.7 0.2 이런 식으로 나옴

print(type(y_pred)) #<class 'numpy.ndarray'>
print(type(y_pred_prop)) #<class 'numpy.ndarray'>

#앞에서 5개만 슬라이싱해서 보자
print(y_pred[:5])
print(y_pred_prop[:5])
# [0 1 1 2 1]
# [[9.83139749e-01 1.68601932e-02 5.74332917e-08]
#  [4.60549772e-03 8.41675528e-01 1.53718974e-01]
#  [1.03262525e-02 9.20317781e-01 6.93559662e-02]
#  [2.57734319e-05 5.16144309e-02 9.48359796e-01]
#  [2.39263584e-02 9.52076637e-01 2.39970044e-02]]