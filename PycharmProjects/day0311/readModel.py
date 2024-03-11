import seaborn as sns
import pandas as pd
from sklearn.model_selection import train_test_split
import sklearn.metrics as metrics
import joblib

'''
     pclass     sex   age  sibsp  parch     fare embarked    who
0         3    male  22.0      1      0   7.2500        S    man
얘를
     pclass   age  sibsp  parch  ...  embarked_S  who_child  who_man  who_woman
579       3  32.0      0      0  ...        True      False     True      False
이런 형태로 변환해서 예측을 시켜야함.
['pclass', 'age', 'sibsp', 'parch', 'fare', 'sex_female', 'sex_male',
       'embarked_C', 'embarked_Q', 'embarked_S', 'who_child', 'who_man',
       'who_woman']
       이런 컬럼들을 가져야 한다는 소리임
'''

x = pd.DataFrame({
    'pclass':[0],
    'age':22.0,
    'sibsp':[1],
    'parch':[0],
    'fare':[7.25],
    'sex_female':[0],
    'sex_male':[1],
    'embarked_C':[0],
    'embarked_Q':[0],
    'embarked_S':[1],
    'who_child':[0],
    'who_man':[1],
    'who_woman':[0]
})

# 위 데이터를 학습한 모델로 예측시켜 보자
# 학습모델 저장하는 게 joblib.dump, 읽어오는 게 joblib.load
model = joblib.load('../Data/titanic.pkl') #model의 자료형은 DecisionTreeClassifier
y = model.predict(x) #y는 yes나 no가 오겟지
print(y)