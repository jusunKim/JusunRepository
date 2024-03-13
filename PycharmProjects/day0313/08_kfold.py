import pandas as pd
import numpy as np
from sklearn import datasets
iris = datasets.load_iris()
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier

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
    #훈련용 문제와 검증용 문제
    X_tr, X_val = X_train.iloc[tr_idx,:], X_train.iloc[val_idx,:] #열은 전부 다
    #훈련용 답과 검증용 답
    y_tr, y_val = y_train.iloc[tr_idx], y_train.iloc[val_idx] #y는 열이 하나니까 행만 지정하면댐

    #학습을 시키기(랜덤포레스트)
    model = RandomForestClassifier(max_depth=5, random_state=20)
    model.fit(X_tr, y_tr)

    #검증하기
    from sklearn.metrics import accuracy_score
    y_val_pred = model.predict(X_val)
    val_acc = accuracy_score(y_val, y_val_pred)
    print("%d번째 교차검증의 정확도: %.4f" %(num_fold,val_acc))
    val_scores.append(val_acc) #전체 정확도 담기 위한 배열에 추가
    num_fold +=1 #몇번째 학습했는지 변수 1 증가

# 1번째 교차검증의 정확도: 0.9167
# 2번째 교차검증의 정확도: 1.0000
# 3번째 교차검증의 정확도: 0.9167
# 4번째 교차검증의 정확도: 0.9167
# 5번째 교차검증의 정확도: 1.0000

#교차검증의 정확도 전체 평균 계산해서 출력
import numpy as np
mean_score = np.mean(val_scores)
print("평균 검증 정확도: ",mean_score)
