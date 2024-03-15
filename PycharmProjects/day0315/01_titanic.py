# <<데이터 로딩>>     
# 우선 라이브러리를 불러옵니다.
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

train = pd.read_csv("Data/train.csv") # 생존여부 포함.
test = pd.read_csv("Data/test.csv")   # 생존여부 비포함.
submission = pd.read_csv("Data/submission.csv")

print(train.shape, test.shape, submission.shape)
#   (891, 12)       (418, 11)       (418, 2)

print(train.head())
'''
   PassengerId  Survived  Pclass  ...     Fare Cabin  Embarked
0            1         0       3  ...   7.2500   NaN         S
1            2         1       1  ...  71.2833   C85         C
2            3         1       3  ...   7.9250   NaN         S
3            4         1       1  ...  53.1000  C123         S
4            5         0       3  ...   8.0500   NaN         S
'''

print(test.head())
'''
   PassengerId  Pclass  ... Cabin Embarked
0          892       3  ...   NaN        Q
1          893       3  ...   NaN        S
2          894       2  ...   NaN        Q
3          895       3  ...   NaN        S
4          896       3  ...   NaN        S
'''

print(submission.head())
'''
   PassengerId  Survived
0          892         0
1          893         1
2          894         0
3          895         0
4          896         1
'''

print(train.info())
'''
#   Column       Non-Null Count  Dtype  
---  ------       --------------  -----  
 0   PassengerId  891 non-null    int64  
 1   Survived     891 non-null    int64  
 2   Pclass       891 non-null    int64  
 3   Name         891 non-null    object 
 4   Sex          891 non-null    object 
 5   Age          714 non-null    float64   --> 결측값 존재
 6   SibSp        891 non-null    int64  
 7   Parch        891 non-null    int64  
 8   Ticket       891 non-null    object 
 9   Fare         891 non-null    float64
 10  Cabin        204 non-null    object    --> 결측값 존재
 11  Embarked     889 non-null    object    --> 결측값 존재
dtypes: float64(2), int64(5), object(5)
memory usage: 83.7+ KB
'''

print(train.describe())
'''
       PassengerId    Survived      Pclass  ...       SibSp       Parch        Fare
count   891.000000  891.000000  891.000000  ...  891.000000  891.000000  891.000000
mean    446.000000    0.383838    2.308642  ...    0.523008    0.381594   32.204208
std     257.353842    0.486592    0.836071  ...    1.102743    0.806057   49.693429
min       1.000000    0.000000    1.000000  ...    0.000000    0.000000    0.000000
25%     223.500000    0.000000    2.000000  ...    0.000000    0.000000    7.910400
50%     446.000000    0.000000    3.000000  ...    0.000000    0.000000   14.454200
75%     668.500000    1.000000    3.000000  ...    1.000000    0.000000   31.000000
max     891.000000    1.000000    3.000000  ...    8.000000    6.000000  512.329200
'''

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

# 숫자 자료형인 피처를 추출
data_num = data.loc[:,['Pclass','Age','SibSp','Parch','Fare','Survived']]
print(data_num.info())
'''
 #   Column    Non-Null Count  Dtype  
---  ------    --------------  -----  
 0   Pclass    1309 non-null   int64  
 1   Age       1046 non-null   float64  ---> 결측치를 평균(mean)으로 대체
 2   SibSp     1309 non-null   int64  
 3   Parch     1309 non-null   int64  
 4   Fare      1308 non-null   float64  ---> 결측치를 최빈값(mode)으로 대체
 5   Survived  891 non-null    float64
'''

# 결측치 처리하기
# 나이(Age)에 대한 결측치는 평균(mean)으로 변환하고, 요금(Fare)에 대한 결측치는 최빈값(mode)으로 변환합니다.
# data_num['Age'] = data_num['Age'].fillna(data_num['Age'].mean())
data_num['Age'] = data_num['Age'].fillna(data_num['Age'].mean())
data_num['Fare'] = data_num['Fare'].fillna(data_num['Fare'].mode()[0])

# print("나이의 평균==> ",data_num['Age'].mean(),type(data_num["Age"].mean()))
# print("요금의 최빈값==> ",data_num['Fare'].mode(),type(data_num["Fare"].mean()))
# '''
# 나이의 평균==>  29.881137667304014 <class 'numpy.float64'>
    # 요금의 최빈값==>  0    8.05 --> key,value의 형태로 응답하기 떄문에 value(값)만 가져오기 위해서는 인덱스를 줘야 합니다.
# '''

print(data_num.info())
''' 결과 : 판다스의 fillna를 통해 "Age"의 결측치는 평균값으로 대체하고, "Fare"의 결측치는 최빈값으로 대체하여 아래와 같이 결측치가 없는 결과가 출력되었습니다.
 #   Column    Non-Null Count  Dtype  
---  ------    --------------  -----  
 0   Pclass    1309 non-null   int64  
 1   Age       1309 non-null   float64
 2   SibSp     1309 non-null   int64  
 3   Parch     1309 non-null   int64  
 4   Fare      1309 non-null   float64
 5   Survived  891 non-null    float64
'''

# 목표변수(Target - Survived)를 제외한 설명변수들을 정한다.
selected_features = ['Pclass','Age','SibSp','Parch','Fare']

# 훈련데이터 문제
X_train = data_num.loc[data["TrainSplit"]=="Train",selected_features]

# 훈련데이터 답
y_train = data_num.loc[data["TrainSplit"]=="Train","Survived"]

# 테스트데이터 문제
X_test = data_num.loc[data["TrainSplit"]=="Test",selected_features]

print(X_train.shape, y_train.shape)
print(X_test.shape)

# 로지스틱 회귀모델을 이용하여 학습시키기
from sklearn.model_selection import train_test_split

# 테스트를 하기 전에 훈련이 잘되었는지 검증시키기 위해 훈련데이터를 학습데이터와 검증데이터로 분할합니다.
X_tr,X_val,y_tr,y_val = train_test_split(X_train,y_train, test_size=0.2,shuffle=True, random_state=1234)

# 공부방법을 정해줍니다(학습모델)
from sklearn.linear_model import LogisticRegression
model = LogisticRegression()
model.fit(X_tr,y_tr)

y_val_pred = model.predict(X_val)

#혼동행렬(confusion Matrix)
# from sklearn.metrics import confusion_matrix
# sns.heatmap(confusion_matrix(y_val,y_val_pred),annot=True)
# plt.show()

#평가지표 출력하기
from sklearn.metrics import accuracy_score, precision_score,recall_score, f1_score
print("정확도 : ",accuracy_score(y_val,y_val_pred))
print("정밀도 : ",precision_score(y_val,y_val_pred))
print("재현율 : ",recall_score(y_val,y_val_pred))
print("f1 : ",f1_score(y_val,y_val_pred))

'''
정확도 :  0.7094972067039106
정밀도 :  0.7045454545454546
재현율 :  0.44285714285714284
f1 :  0.543859649122807
'''

y_test_pred = model.predict(X_test)

submission['Survived'] = y_test_pred.astype(int) # astype을 활용하여 예측한 결과를 int로 변환하여  submission['Survived']에 저장합니다. 기존에 submission['Survived']은 예시입니다. 즉, 진짜 답이 아니기 때문에 예측한 값으로 바꿔주는 것입니다.
submission.to_csv("./Data/titanic_001.csv",index=False) # 원하는 경로의 원하는 이름의 csv파일로 저장합니다. 이때 인덱스는 생성되지 않도록 설저한 것입니다.
print("파일을 저장하였습니다.")
