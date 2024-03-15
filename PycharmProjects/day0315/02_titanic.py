# <<데이터 로딩>>
# 우선 라이브러리를 불러옵니다.
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

train = pd.read_csv("Data/train.csv") # 생존여부 포함.
test = pd.read_csv("Data/test.csv")   # 생존여부 비포함.
submission = pd.read_csv("Data/submission.csv")

# print(train['Ticket'].value_counts())
# Ticket
# 347082      7
# CA. 2343    7
# 1601        7
# 3101295     6
# CA 2144     6
#            ..
# 9234        1
# 19988       1
# 2693        1
# PC 17612    1
# 370376      1
# Name: count, Length: 681, dtype: int64

print(train.shape, test.shape, submission.shape)
#   (891, 12)       (418, 11)       (418, 2)


# 결측값의 분포를 그래프로 확인하기 위한 라이브러리 : missingno
import missingno as msno
# msno.bar(train, figsize=(10,5), color=(0.7,0.2,0.2))
# plt.show()

# matrix : missingno의 함수로 어느 위치에 결측치가 있는지 확인시켜줍니다.
# msno.matrix(train,figsize=(10,5), color=(0.7,0.2,0.2))
# plt.show()

# 자료형이 문자인 것은 제외하고 숫자인 피처들만 선택합니다. : 'PassengerId','Survived','Pclass','Age','SibSp','Parch','Fare'
# sel_col = ['PassengerId','Survived','Pclass','Age','SibSp','Parch','Fare']
# df = train.loc[:,sel_col]
# plt.figure(figsize=(8,8)) # 도화지 크기 설정.
# sns.set(font_scale=0.8) # 글자 크기 설정.
# sns.heatmap(df.corr(), annot=True, cbar=True) # seaborn의 heatmap 함수를 사용하여 df의 상관관계를 히트맵으로 시각화합니다. df.corr()는 자료형이 숫자인 피처들 간의 상관관계 행렬을 생성합니다. annot=True는 각 셀에 상관관계 값을 표시하도록 지정하고, cbar=True는 컬러 바(색상 막대)를 표시하도록 지정합니다.
# plt.show()

# train과 test를 합쳐서 타이타닉 전체 데이터셋을 준비합니다.
train["TrainSplit"] = "Train"
test["TrainSplit"] = "Test"

print(train.head())
print(test.head())

data = pd.concat([train,test],axis=0)
print(data.head())
print(data.tail())
print(data.shape) # 결과 : (1309, 13)

print(data.columns)
sel_columns = ['Pclass',  'Sex', 'Age', 'SibSp', 'Parch',
               'Fare', 'Embarked','Survived']
df = data.loc[:,sel_columns]
df['Age'] = df['Age'].fillna(df['Age'].mean())
df['Fare'] = df['Fare'].fillna(df['Fare'].mode()[0])
df['Embarked'] = df['Embarked'].fillna(df['Embarked'].mode()[0])
print(df.info())

sel_columns = ['Pclass',  'Sex', 'Age', 'SibSp', 'Parch',
               'Fare', 'Embarked']
# 훈련데이터 문제
X_train = df.loc[data["TrainSplit"]=="Train",sel_columns]
print(X_train[:20])

# 훈련데이터 답
y_train = df.loc[data["TrainSplit"]=="Train","Survived"]

# 테스트데이터 문제
X_test = df.loc[data["TrainSplit"]=="Test",sel_columns]
print(X_test.shape)

X_train = pd.get_dummies(X_train)
print(X_train.shape)


from sklearn.model_selection import train_test_split
# 테스트를 하기 전에 훈련이 잘되었는지 검증시키기 위해 훈련데이터를 학습데이터와 검증데이터로 분할합니다.
X_tr,X_val,y_tr,y_val = train_test_split(X_train,y_train, test_size=0.2,shuffle=True, random_state=1234)

# 공부방법을 정해줍니다(학습모델)
from sklearn.linear_model import LogisticRegression
model = LogisticRegression(max_iter=1000)
model.fit(X_tr,y_tr)

y_val_pred = model.predict(X_val)

from sklearn.metrics import accuracy_score, precision_score,recall_score, f1_score
print("정확도 : ",accuracy_score(y_val,y_val_pred))
print("정밀도 : ",precision_score(y_val,y_val_pred))
print("재현율 : ",recall_score(y_val,y_val_pred))
print("f1 : ",f1_score(y_val,y_val_pred))

X_test = pd.get_dummies(X_test)
y_test_pred = model.predict(X_test)

submission['Survived'] = y_test_pred.astype(int) # astype을 활용하여 예측한 결과를 int로 변환하여  submission['Survived']에 저장합니다. 기존에 submission['Survived']은 예시입니다. 즉, 진짜 답이 아니기 때문에 예측한 값으로 바꿔주는 것입니다.
submission.to_csv("./Data/titanic_001.csv",index=False) # 원하는 경로의 원하는 이름의 csv파일로 저장합니다. 이때 인덱스는 생성되지 않도록 설저한 것입니다.
print("파일을 저장하였습니다.")
'''
정확도 :  0.8379888268156425
정밀도 :  0.8596491228070176
재현율 :  0.7
f1 :  0.7716535433070866
'''