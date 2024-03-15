# <<데이터 로딩>>
# 우선 라이브러리를 불러옵니다.
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

#피처 엔지니어링
# 각 피처를 하나씩 모델 학습에 맞도록 전처리하고 모델 성능 개선할 수 있는 방법을 찾는 것

train = pd.read_csv("Data/train.csv") # 생존여부 포함.
test = pd.read_csv("Data/test.csv")   # 생존여부 비포함.
submission = pd.read_csv("Data/submission.csv")

#타깃변수의 분포 확인
print(train['Survived'].value_counts(dropna=False))

#생존자와 사망자의 분포를 시각화
# sns.countplot(x="Survived", data = train)
# plt.show()
#['PassengerId', 'Survived', 'Pclass', 'Name', 'Sex', 'Age', 'SibSp',
       # 'Parch', 'Ticket', 'Fare', 'Cabin', 'Embarked']

print(train.columns)
# sns.countplot(x='Pclass', data=train)
# plt.show()

train["TrainSplit"] = "Train"
test["TrainSplit"] = "Test"
data = pd.concat([train,test],axis=0)
# sns.countplot(x='Pclass',data=data,hue='TrainSplit')
# plt.show()

#객실 등급에 따른 생존자 비율
# sns.countplot(x='Pclass',data=train,hue='
# Survived')
# sns.countplot(x='Pclass',data=data[data['TrainSplit']=='Train'],hue='Survived')
# plt.show()

#barplot함수 이용해 객실등급별 객실요금의 중간값 분포 확인
# sns.barplot(data=train, x='Pclass', y='Fare')
# plt.show()

#barplot함수 이용해 객실등급별 객실요금의 중간값 분포 확인
# sns.barplot(data=train, x='Pclass', y='Fare', hue='Survived', estimator=np.median)
# plt.show()

# 성별은 생존에 주요한 요인일까>?
# 성별별로 생존률 분포 파악하기
# sns.histplot(x='Sex', data=train, hue='Survived', multiple='dodge')
# plt.show()

# sns.histplot(x='Sex', data=train, hue='Survived', multiple='fill')
# plt.show()
#
# sns.histplot(x='Sex', data=train, hue='Survived', multiple='stack')
# plt.show()

'''
histplot에서 hue속성 사용 시
multiple='dodge'  : 각각 분리해서 옆으로 그려주ㅠㅁ
multiple='stack' : 누적해서 그려줌
multiple='fill' : 백분율로 비율 채워줌
'''

#성별은 생존에 주요 영향을 끼치는 요인이니까 학습에 참여를 시켜야함
# -> 숫자로 변경하자
# 문자인 피처를 숫자로 변경시키기 위한 방법은 다양(원핫인코딩 등..)
# 여자는 0, 남자는 1로 해보자

data.loc[data['Sex']=='female','Sex']=0
data.loc[data['Sex']=='male','Sex']=1
data['Sex'] = data['Sex'].astype(int)
print(data['Sex'].value_counts())
print(data['Sex'].dtype)

print(data['Name'].value_counts())
'''
Name
Connolly, Miss. Kate                                   2
Kelly, Mr. James                                       2
Braund, Mr. Owen Harris                                1
Johnson, Master. Harold Theodor                        1
Gustafsson, Mr. Alfred Ossian                          1
'''
#이름에는 신분을 알려주는 단어들도 있더라
# 쉼표 뒤에 있는 애를 가져와보자
title_name = data['Name'].str.split(', ', expand=True)[1]
print('values',title_name.values)

title_name = title_name.str.split('.', expand=True)[0]
print(title_name)

#각 신분별 데이터수 확인
print(title_name.value_counts(dropna=False))
#Mr              757
# Miss            260
# Mrs             197
# Master           61
# Rev               8
# Dr                8
# Col               4
# Mlle              2
# Major             2
# Ms                2
# Lady              1
# Sir               1
# Mme               1
# Don               1
# Capt              1
# the Countess      1
# Jonkheer          1
# Dona              1

title_name = title_name.replace('Ms', 'Miss')
title_name = title_name.replace(['Mlle', 'the Countess', 'Lady', 'Don', 'Dona', 'Mme', 'Sir', 'Jonkheer'], 'Noble')
title_name = title_name.replace(['Col', 'Major', 'Capt'], 'Officer')
title_name = title_name.replace(['Dr', 'Rev'], 'Priest')
print(title_name.value_counts())

data['Title'] = np.array(title_name)
print(data['Title'].value_counts(dropna=False))
print(data.head())
'''
Mr         757
Miss       262
Mrs        197
Master      61
Priest      16
Noble        9
Officer      7
'''
# sns.violinplot(data=data.reset_index(), x="Title", y='Age', hue='Survived', split=True )
# plt.show()

#Name변수(속성,열)을 삭제하기
data = data.drop(columns='Name')
print(data.head())
print(data.columns)

#변수 나이의 결측치 수 확인
print(data['Age'].isna().sum()) #263
print(data['Title'].unique()) #['Mr' 'Mrs' 'Miss' 'Master' 'Noble' 'Priest' 'Officer']

# 결측치를 이 신분으로 나눈거별로 그 중앙값으로 넣겟다는 소리
#Mr 29.0
# Mrs 35.5
# Miss 22.0
# Master 4.0
# Noble 38.0
# Priest 44.0
# Officer 53.0
for t in data['Title'].unique():
    age_median = data.loc[data['Title']==t,'Age'].median()
    # print(data.loc[data['Title'] == t, 'Age'].isna().sum())
    data.loc[data['Title'] == t, 'Age'] = data.loc[data['Title'] == t, 'Age'].fillna(age_median)
print(data['Age'].isna().sum()) #0

# 나이별로 생존여부 분포를 확인해 보자
# sns.displot(data= data[data['TrainSplit']=='Train'], x='Age', kind='hist',hue='Survived')
# plt.show()

# 나이에 따라 생존율의 차이가 크기 때문에 이걸 학습데이터로 적용할라고 나이를 구간을 나눠보자
# 데이터를 구간으로 나누기: Binning

bins=[0,4,8,12,16,32,36,48,56,64,100]
labels=['infant', 'child1', 'child2', 'youth1', 'youth2', 'adult1', 'adult2', 'middleAged', 'senior', 'elderly']
data['AgeBin'] = pd.cut(data['Age'], bins=bins, labels=labels)
print(data.loc[:,['Age','AgeBin']].head())

# sns.countplot(x='AgeBin', hue='Survived', data=data[data['TrainSplit']=='Train'])
# plt.xticks(rotation=90)
# plt.show()

#동승한 형제 자매 배우자 수
# 별 생존율 그래프 boxplot
print(data.loc[:,['PassengerId','SibSp']])
# sns.boxplot(x='SibSp', data=data[data['TrainSplit']=='Train'], y='Age', hue='Survived')
# plt.show()

#동승한 부모자식 수

# 별 생존율 그래프 boxplot
# sns.boxplot(x='Parch', data=data[data['TrainSplit']=='Train'], y='Age', hue='Survived')
# plt.show()

#함께 탑승한 가족구서원 수: 함께 탑승한 형제수+부모자녀수+1
data['FamilySize'] = data['SibSp']+data['Parch']+1
print(data.loc[:,['PassengerId','SibSp','Parch','FamilySize']].head())

#가족구성원 수와 생존율 관계 시각화
# sns.barplot(x='FamilySize',y='Survived',data=data[data['TrainSplit']=='Train'],
#             hue='Pclass',estimator=np.mean)
# plt.show()

# 요금의 결측치 확인하기
print(data['Fare'].isna().sum()) #1개
print(data.loc[data['Fare'].isna(),['PassengerId','Pclass','Fare']])
#      PassengerId  Pclass  Fare
# 152         1044       3   NaN
#얘가 3등급이니까 3등급의 평균요금을 알아내자
p3_fare_mean = data.loc[data['Pclass']==3,'Fare'].mean()
print(p3_fare_mean) #13.302888700564973
data['Fare'] = data['Fare'].fillna(p3_fare_mean)
print(data.loc[data['PassengerId']==1044,['PassengerId','Pclass','Fare']])
#      PassengerId  Pclass       Fare
# 152         1044       3  13.302889 들어갔음을 확인

#Fare의 분포를 나타내보자
# sns.displot(x='Fare',data=data[data['TrainSplit']=='Train'], hue='Survived', kind='kde')
# plt.show()

# 비대칭 분포를 가진 데이터는 학습 효율이 떨어진대 그래서 대칭 분포로 정규화시킬거야
# 로그 변환을 하자 np.log1p()
data['FareLog'] = np.log1p(data['Fare'])
# sns.displot(x='FareLog', data=data[data['TrainSplit']=='Train'], hue='Survived', kind='hist')
# plt.show()

# stripplot:
# 각 카테고리별 데이터를 수평/수직으로 점 찍어 표현해서 데이터 분포를 쉽게 파악 가능
# sns.stripplot(x='Pclass',y='FareLog',data=data[data['TrainSplit']=='Train'], hue='Survived')
# plt.show()

#탑승항구에 결측치가 있는지 확인
print(data['Embarked'].isna().sum()) #2
print(data.loc[data['Embarked'].isna(),['PassengerId','Pclass','Fare','Embarked']])
#      PassengerId  Pclass  Fare Embarked
# 61            62       1  80.0      NaN
# 829          830       1  80.0      NaN 얘네임

#최빈값으로 변환해보자
print('탑승항구의 최빈값:',data['Embarked'].mode()[0]) #탑승항구의 최빈값: S
data['Embarked'] = data['Embarked'].fillna(data['Embarked'].mode()[0])

#탑승항구별 빈도수 출력
print(data['Embarked'].value_counts(dropna=False))
# Embarked
# S    916
# C    270
# Q    123

# catplot: 범주형데이터 시각화시 용이함. (범주형 테이터: 혈액형. 타이타닉의경우 embarked)
# sns.catplot(data=data[data['TrainSplit']=='Train'], x='Embarked', y='Survived',kind='bar')
# plt.show()

#Cabin열은 객실 구역을 나타낸다
print(data['Cabin'].unique())
# [nan 'C85' 'C123' 'E46' 'G6' 'C103' 'D56' 'A6' 'C23 C25 C27' 'B78' 'D33'
#  'B30' 'C52' 'B28' 'C83' 'F33' 'F G73' 'E31' 'A5' 'D10 D12' 'D26' 'C110'

#객실번호 첫글자를 잘라와서 객실구역으로 활용해 보자
print(data['Cabin'].str.slice(0,1).value_counts(dropna=False))

#객실번호 첫글자를 구역으로 활용할거고 결측치는 u로 설정할거야.
data['Cabin'] = data['Cabin'].str.slice(0,1)
data['Cabin'] = data['Cabin'].fillna('U')
print(data['Cabin'].value_counts())
# Cabin
# U    1014
# C      94
# B      65
# D      46
# E      41
# A      22
# F      21
# G       5
# T       1

#catplot 함수 이용해 객실구역별로 생존율을 비교해보자
# sns.catplot(x='Cabin', y='Survived', data=data[data['TrainSplit']=='Train'], kind='bar')
# plt.show()

#Ticket은 뭐 없나?
print(data['Ticket'].value_counts())
# Ticket
# CA. 2343        11
# CA 2144          8
# 1601             8
# PC 17608         7
# S.O.C. 14879     7
#=> 글자 중에 . 나 / 는 없애자
data['Ticket'] = data['Ticket'].str.replace('.','').str.replace('/','')
print(data['Ticket'].value_counts())

#티켓의 글자를 공백으로 분리해서 0번째 인덱스 가져오고 없으면 숫자로만 구성된 애니까 'NUM'으로 설정하자
#str.strip()은 자바의 trim같은 거임. 앞뒤의 공백을 없애줌
data['Ticket'] = data['Ticket'].str.strip().str.split(" ").str[0]
print(data['Ticket'].value_counts())

#숫자로만 된 애는 NUM으로 설정해주자
data.loc[data['Ticket'].str.isdigit(),'Ticket'] = 'NUM'
print(data['Ticket'].value_counts())

