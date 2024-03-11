import pandas as pd
import numpy as np
from sklearn import datasets
import matplotlib.pyplot as plt

iris = datasets.load_iris()
print(iris)
print(type(iris))
print(iris.keys())
print(iris['data'])
print(iris['target'])
print(iris['frame'])
print(iris['target_names'])
print(iris['DESCR'])
print(iris['feature_names'])

print(iris['data'].shape)
print(iris['target'].shape)

df = pd.DataFrame(
    iris['data'], columns=iris['feature_names']
)
print(df.head())
df.columns=['sepal_length','sepal_width','petal_length','petal_width']
print(df.head())

df['target'] = iris['target']
print(df.head())

print(df.info()) #=> 결측치 없으니까 결측치 처리 따로 안 해도 되고. 모든 속성이 숫자니까 원핫인코딩도 안해도됨

#요약통계량 정보 확인
print(df.describe())

#결측치 확인
print(df.isna().sum())

#중복된 데이터 있는지 확인
print(df.duplicated().sum())

#그게어딘지확인
print(df.loc[df.duplicated(),:])
#      sepal_length  sepal_width  petal_length  petal_width  target
# 142           5.8          2.7           5.1          1.9       2
# ==> 142번째 행이랑 같은 데이터가 어디 있는지 알아보자 (궁금하니까)
print(df.loc[(df.sepal_length==5.8) & (df.sepal_width==2.7)])

#중복된 데이터 제거하는 함수
df = df.drop_duplicates()

print(df.shape) #중복된 거 제거해서  149개 남음

#iris 품종에 가장 영향을 많이 끼치는 속성을 알아보기 위해 상관행렬을 만들어보자
print(df.corr())

#상관행렬을 시각화해 히트맵을 그려보자
import seaborn as sns
# sns.heatmap(data=df.corr(), square=True, annot=True, cbar=True)
# plt.show()

#목표 레이블ㄱ의 값의 종류별 빈도수 확인
print(df['target'].value_counts())

# petal_width의 분포를 알기 위해 히스토그램을 그려 보자
# plt.hist(x='petal_width',data=df)
# plt.show()

#seaborn의 displot함수를 이용해서도 해보자
# sns.displot(x='petal_width',kind='hist', data=df)
# plt.show()

#커널밀도함수 kde를 써보자
# sns.displot(x='petal_width',kind='kde', data=df)
# plt.show()

#품종별로 petal_width 분포를 확인
# sns.displot(x='petal_width',kind='kde', data=df, hue='target')
# plt.show()

# sns.displot(x='petal_width',kind='kde', data=df, hue='target')
# plt.show()
#여기서 별로 안중요한 변수였던 애를 x에다 주면 애들이 막 겹쳐져있음-> 구분에 별로 안중요하다는 걸 알수잇음

#서로 다른 속성끼리 상관관계 확인하기
# sns.pairplot(data = df, hue='target')
# plt.show()

from sklearn.model_selection import train_test_split
#데이터프레임으로부터 문제와 답을 분리하기
X_data = df.loc[:,'sepal_length':'petal_width']
y_data = df.loc[:,'target']
print(X_data.shape)
print(y_data.shape)

#데이터를 랜덤하게 섞고 훈련용, 테스트용 데이터로 분리합니다.
X_train, X_test, y_train, y_test = train_test_split(X_data, y_data, test_size=0.2,
                                                    shuffle=True, random_state=20)
print(X_train.shape, y_train.shape)
print(X_test.shape, y_test.shape)

#답이 두가지 중 하나인 게 아니라 어느 품종에 해당하는지 분류하기 위해 KNN을 사용
# KNN(K-Nearest Neighbours) :나와 가까이 있는 데이터 k개 가 많이 속해있는 집단에 나를 속하게 함

from sklearn.neighbors import KNeighborsClassifier
knn = KNeighborsClassifier(n_neighbors=7) #얘는 모델 이름임 걍 정함
knn.fit(X_train,y_train)    #훈련시키기. 지 안에서 함수 조정을 함
y_pred = knn.predict(X_test)
print("예측값: ",y_pred[:5])
print("실제값: ",y_test)

#성능 평가하기 - 일단 정확도만
from sklearn.metrics import accuracy_score
score = accuracy_score(y_test,y_pred)
print(score)