import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn import datasets
data_url = "http://lib.stat.cmu.edu/datasets/boston"
raw_df = pd.read_csv(data_url, sep="\s+", skiprows=22, header=None)
data = np.hstack([raw_df.values[::2, :], raw_df.values[1::2, :2]])
target = raw_df.values[1::2, 2]
print(type(data)) #<class 'numpy.ndarray'>
print(type(target)) #<class 'numpy.ndarray'>

print(data.shape) #(506, 13)
print(target.shape) #(506,)

#data는 문제, target은 답
#data를 가지고 dataframe을 만들자
df = pd.DataFrame(data)
print(df.head())


'''
 Variables in order:
 CRIM     per capita crime rate by town
 ZN       proportion of residential land zoned for lots over 25,000 sq.ft.
 INDUS    proportion of non-retail business acres per town
 CHAS     Charles River dummy variable (= 1 if tract bounds river; 0 otherwise)
 NOX      nitric oxides concentration (parts per 10 million)
 RM       average number of rooms per dwelling
 AGE      proportion of owner-occupied units built prior to 1940
 DIS      weighted distances to five Boston employment centres
 RAD      index of accessibility to radial highways
 TAX      full-value property-tax rate per $10,000
 PTRATIO  pupil-teacher ratio by town
 B        1000(Bk - 0.63)^2 where Bk is the proportion of blacks by town
 LSTAT    % lower status of the population
 MEDV     Median value of owner-occupied homes in $1000's
 '''
#df의 컬럼 이름을 정하자
df.columns=[ 'CRIM','ZN','INDUS', 'CHAS' ,'NOX', 'RM' ,'AGE','DIS','RAD','TAX','PTRATIO' ,'B' ,'LSTAT'  ]
print(df.head())

# 데이터프레임에 타겟을 설정하자
df_target = pd.DataFrame(target)
df_target.columns = ['Target']
print(df_target.head())

df = pd.concat([df, df_target],axis=1) #합치기
print(df.head())
'''
      CRIM    ZN  INDUS  CHAS    NOX  ...    TAX  PTRATIO       B  LSTAT  Target
0  0.00632  18.0   2.31   0.0  0.538  ...  296.0     15.3  396.90   4.98    24.0
1  0.02731   0.0   7.07   0.0  0.469  ...  242.0     17.8  396.90   9.14    21.6
2  0.02729   0.0   7.07   0.0  0.469  ...  242.0     17.8  392.83   4.03    34.7
3  0.03237   0.0   2.18   0.0  0.458  ...  222.0     18.7  394.63   2.94    33.4
4  0.06905   0.0   2.18   0.0  0.458  ...  222.0     18.7  396.90   5.33    36.2
'''

#데이터 탐색
print(df.info())
# 결측치 하나도 없고 모든 속성이 숫자라서 원핫인코딩도 안해도댐.

# 결측치 확인. 각 변수끼리 상관행렬 집값에 가장 영향을 많이 끼치는 변수 확인
# 집값에 대한 데이터 부포도 그리기

print(df.isna().sum()) #결측치 없음
print('-'*50)
df_corr = df.corr()
print(df_corr) #상관행렬 확인
plt.figure(figsize=(10,10))
# sns.heatmap(df_corr, annot=True, cbar =False)

#집값에 가장 영향을 많이 끼치는 변수 확인
# 세로로 추출할라고
corr_order = df.corr().loc[:'LSTAT',"Target"].abs().sort_values(ascending=False)
print(corr_order)
#=> 절대값 씌워서 sort_values한 결과
# LSTAT      0.737663
# RM         0.695360
# PTRATIO    0.507787
# INDUS      0.483725
# TAX        0.468536
# NOX        0.427321
# CRIM       0.388305
# RAD        0.381626
# AGE        0.376955
# ZN         0.360445
# B          0.333461
# DIS        0.249929
# CHAS       0.175260


#집값에 가장 영향을 많이 끼치는 4개 피처 'LSTAT','RM','PTRATIO','INDUS'
plot_cols = ['Target','LSTAT','RM','PTRATIO','INDUS']
plot_df = df.loc[:,plot_cols] #행은 모두 가져오고 열은 이 네 가지만 가져오겟다
print(plot_df)

#seaborn의 regplot으로 집값을 결정하는 주요 변수 4개에 대해 산점도랑 회귀선을 각각 그려보자.
#plt.figure(figsize=(10,10))
#for idx,col in enumerate(plot_cols[1:]): #인덱스도 필요하면 enumerate를 써야댐
    # ax1 = plt.subplot(2,2,idx+1) #2by2인 도화지의 부분을 ax1이라고정함 1~4
    # sns.regplot(x=col,y=plot_cols[0], data = plot_df, ax=ax1)
# plt.show()

'''
저걸 일일이 하는 방법은 이거
f1 = plt.supblot(2,2,1)...
sns.regplot(x=col,y=''Target, data = plot_df, ax=f1)...
이런 식으로 네 번
'''

#집값의 데이터 분포도를 그려고기
# sns.displot(x='Target', kind='hist',data=df)
# sns.displot(x='Target', kind='kde',data=df)
# plt.show()

#피처 스케일링
from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()
# 타깃 변수(집값) 제외한 속성들 뽑아와
df_scaler = df.iloc[:,:-1] #Target제외하고 다 모든 행 가져오라는 얘기
print(df_scaler)

#스케일링 준비
scaler.fit(df_scaler)

#스케일링 적용(변수별로 어떻게 곱하고 나눌지 수식 세운 걸 적용해봐)
df_scaler = scaler.transform(df_scaler) #transform은 numpyArray를 반환
#df_scaler가 numpyarray여가지고 얘를 df로 다시 변환하기 위해서ㅗ
# df_scaler에 있는 전부를 df에다가 맨 마지막 Target열 제외하고 싹 다 끼워넣은거
df.iloc[:,:-1] = df_scaler[:,:]
print(df.head())
'''
       CRIM    ZN     INDUS  CHAS  ...   PTRATIO         B     LSTAT  Target
0  0.000000  0.18  0.067815   0.0  ...  0.287234  1.000000  0.089680    24.0
1  0.000236  0.00  0.242302   0.0  ...  0.553191  1.000000  0.204470    21.6
2  0.000236  0.00  0.242302   0.0  ...  0.553191  0.989737  0.063466    34.7
3  0.000293  0.00  0.063050   0.0  ...  0.648936  0.994276  0.033389    33.4
4  0.000705  0.00  0.063050   0.0  ...  0.648936  1.000000  0.099338    36.2
'''

#연습) 저소득 비율과 방 수에 따른 집값을 예측하는 모델
#선형회귀 모델로..

from sklearn.model_selection import train_test_split
X_data = df.loc[:,['LSTAT','RM']] #전체데이터로부터 학습시킬 문제에 해당하는 속성만 추출(type:DF)
y_data = df.loc[:,'Target'] #전체데이터로부터 학습시킬 답에 해당하는 속성 추출 (type:series)
#학습문제, 테스트문제, 학습답, 테스트답으로 split
X_train, X_test, y_train, y_test = train_test_split(X_data, y_data,
                                                    test_size=0.2, shuffle=True,random_state=20 )
#학습 문제로 사용될 두 변수 LSTAT와 RM은 산점도, 회귀선 그려봤을 때 강한 상관관계에 있으므로(아까확인함)
# 두 데이터 사이 관계를 직선으로 나타낼 수 있음
# 학습시킬 모델로는 선형 회귀 모델이 적합하겟다.
from sklearn.linear_model import LinearRegression
model = LinearRegression()

#공부 ㄱ
model.fit(X_train,y_train)
# 이 경우에는 x가 두 개니까 이런 식을 만들겠다 y = a1x1+ a2x2 +b (x1은 LSTAT, x2는 RM)
# 공부하면서 이 데이터를 가장 잘 설명하는 a1,a2,b를 찾아냄 - 이게 학습의 목적임
# a1, a2를 회귀계수(기울기)라 함. b는 상수항
# 기울기를 알려주는 속성 coef_ , 상수항을 알려주는 속성 intercept_ (함수 아니니까 괄호를 안 씀)
print("회귀계수(기울기): ",model.coef_) #[-24.00550973  26.00322701]
print("상수항(절편): ",model.intercept_) #16.352926740402605
# 깅까 이런 거임 y = -24.00550973*LSTAT + 26.00322701*RM + 16.352926740402605
# 각각의 피처의 가중치라고도 할 수 있겟구먼...
#학습 결과 위 함수(식)을 만들어 내고 새로운 데이터 LSTAT과 RM이 주어지면 위 수식을 거쳐 집값을 예측할 수 잇다

#예측시키기
y_pred = model.predict(X_test)
#예측한 거랑 진짜 답을 비교해 보자.
# 일단 자료형을 뽑아보자
print(type(y_pred)) #<class 'numpy.ndarray'>
print(type(y_test)) #<class 'pandas.core.series.Series'>

print(y_pred[:5]) #[21.18740699 23.87676318 20.91895944 16.25292974 14.73680363]
print(y_test.head())
#498    21.2
# 94     20.6
# 150    21.5
# 221    21.7
# 423    13.4

#테스터 데이터는 새로운 데이터ㅗ니까.. 이미 공부한 데이터에 대해서는 더 잘 맞히려나?
y_train_pred = model.predict(X_train)
print(y_train_pred[:5])
print(y_train.head())

#실제값과 예측값을 산점도로 그려서 시각화해보자
# plt.figure(figsize=(10,5))
# plt.scatter(X_test['LSTAT'],y_test, label='y_test') #찐
# plt.scatter(X_test['LSTAT'],y_pred, label='y_pred', c='r') #예측한 거
# plt.legend(loc='best') #범례 위치를 니가 알아서 잘 정해줘
# plt.show()

# 선형회귀가 공부 잘 했는지 성능을 파악하기 위해서는 실제값과 예측값의 차이의 제곱의 합의 평균 MSE를 이용
# MSE 평균 제곱 오차
# 깅까 훈련데이터의 MSE와 테스트데이터의 MSE의 차이가 없다면 학습을 잘 했다고 볼 수 있다
from sklearn.metrics import mean_squared_error

#학습한 데이터의 MSE를 확인해보자
train_mse = mean_squared_error(y_train,y_train_pred)
print(train_mse) #31.50022083642191

#테스트 데이터의 MSE를 확인해보자
test_mse = mean_squared_error(y_test,y_pred)
print(test_mse) #26.782877492626124

