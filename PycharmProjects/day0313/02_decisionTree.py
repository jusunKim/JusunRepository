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
# from sklearn.linear_model import LogisticRegression #모델만 바꾸기
# model = LogisticRegression()
from sklearn.tree import DecisionTreeClassifier
model = DecisionTreeClassifier(max_depth=3, random_state=20)

model.fit(X_train, y_train)
pred = model.predict(X_test)

print(type(pred)) #<class 'numpy.ndarray'>
print(type(y_test)) #<class 'pandas.core.series.Series'>

# print(X_train.head())
# print(y_train.head())

print(pred[:5])
print(y_test.head())

from sklearn.metrics import accuracy_score
acc = accuracy_score(y_test, pred)
print("정확도:", acc)
