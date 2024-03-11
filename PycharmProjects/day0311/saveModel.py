import seaborn as sns
import pandas as pd
from sklearn.model_selection import train_test_split
import sklearn.metrics as metrics
import joblib

titanic = sns.load_dataset('titanic')
print(titanic.head())

df = titanic.copy()
df = df.drop(columns=["class","adult_male","deck","embark_town","survived","alone"])
df = df.dropna(subset=['age', 'embarked'])
target = df['alive']
df = df.drop(columns=['alive'])
print(df.iloc[5])
print(target.iloc[5])
print('--------------------------')



# df = pd.get_dummies(df)
# df['alive'] = target
#
# df_train, df_test = train_test_split(
#     df,
#     test_size=0.3,
#     random_state=1234,
#     stratify=df['alive'],
#     shuffle=True
# )
#
# from sklearn import tree
# clf = tree.DecisionTreeClassifier(random_state=1234, max_depth=7)
# train_x = df_train.drop(columns = ['alive'])
# train_y = df_train['alive']
#
# clf.fit(X=train_x, y = train_y) #일케 하면 학습한 정보 갱신됨
#
# test_x = df_test.drop(columns = ['alive'])
# test_y = df_test['alive']
#
# pred = clf.predict(test_x) #pred는 예측한 데이터
#
# acc = metrics.accuracy_score(y_true=test_y, y_pred=pred)
# prec = metrics.precision_score(y_true=test_y, y_pred=pred, pos_label='yes')
# recall = metrics.recall_score(y_true=test_y, y_pred=pred, pos_label='yes')
# f1 = metrics.f1_score(y_true=test_y, y_pred=pred, pos_label='yes')
#
# print(acc,prec, recall,f1)
#
#
# #학습한 성능평가를 해서 만족할 결과가 나왔으면 이걸 어플리케이션에 활용하기 위해 학습한 결과를 저장
# # 저장하기 위해 joblib.dump 함수를 이용하고 확장자는 pkl
# # 학습한 모델 저장하기
# joblib.dump(clf,"../Data/titanic.pkl")
# print('학슴모델을 저장했습니다/.')