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


val_scores = [] #학습한 평가를 차례로 저장하기 위한 리스트 val_scores를 만들자
num_fold = 1 #훈련한 횟수 증기시키기 위한 변수

#교차검증을 위해 학습데이터를 훈련데이터와 검증데이터로 분리하여 인덱스 알려주는 모델을 읽어들이기
from sklearn.model_selection import KFold
kfold = KFold(n_splits=5, shuffle=True, random_state=1234)
#n_splits=5 : 전체 데이터를 5개로 분할하겟다는 소리-> 교차검증을 5번 하겠다는 소리

#kfold.split(X_train,y_train)은 학습데이터의 문제와 답을 매개변수로 전달받아
# 훈련데이터의 인덱스와 검증데이터의 인덱스를 반환
for tr_idx, val_idx in kfold.split(X_train, y_train):
    print("훈련용 인덱스",tr_idx)
    print("검증용 인덱스",val_idx)