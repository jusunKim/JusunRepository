import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

submission = pd.read_csv("./Data/submission.csv")
df = pd.read_csv('./Data/titanic_df001.csv')
print(df.head())

selected_features = ['Pclass', 'Sex', 'Age', 'SibSp', 'Parch', 'Fare', 'Title', 'AgeBin',
       'FamilySize', 'FareLog', 'Emb_Q', 'Emb_S', 'Cab_B', 'Cab_C', 'Cab_D',
       'Cab_E', 'Cab_F', 'Cab_G', 'Cab_T', 'Cab_U', 'Tic_A4', 'Tic_A5',
       'Tic_AQ3', 'Tic_AQ4', 'Tic_AS', 'Tic_C', 'Tic_CA', 'Tic_CASOTON',
       'Tic_FC', 'Tic_FCC', 'Tic_Fa', 'Tic_LINE', 'Tic_LP', 'Tic_NUM',
       'Tic_PC', 'Tic_PP', 'Tic_PPP', 'Tic_SC', 'Tic_SCA3', 'Tic_SCA4',
       'Tic_SCAH', 'Tic_SCOW', 'Tic_SCPARIS', 'Tic_SCParis', 'Tic_SOC',
       'Tic_SOP', 'Tic_SOPP', 'Tic_SOTONO2', 'Tic_SOTONOQ', 'Tic_SP',
       'Tic_STONO', 'Tic_STONO2', 'Tic_STONOQ', 'Tic_SWPP', 'Tic_WC',
       'Tic_WEP']
#전체 데이터로부터 훈련데이터의 답안을 뽑아 오기
y_tr = df.loc[df['TrainSplit']=='Train','Survived']
#전체 데이터로부터 훈련데이터의 문제 뽑아 오기
X_tr = df.loc[df['TrainSplit']=='Train',selected_features]
#전체 데이터로부터 테스트데이터의 문제 뽑아 오기
X_test = df.loc[df['TrainSplit']=='Test',selected_features]
# X_tr = df.loc[]

#피처 중요도 속성을 갖고 있는 RandomForestClassifier로 학습시키자
print(len(X_tr.columns)) #56

from sklearn.ensemble import RandomForestClassifier
model = RandomForestClassifier(random_state=1234)
model.fit(X_tr,y_tr)
y_test_pred = model.predict(X_test)
submission['Survived'] = y_test_pred.astype(int)
print(submission)
# submission.to_csv('./Data/titanic_0318_2.csv',index=False)
# print('답안파일작성완')

print(model.feature_importances_)
print(len(model.feature_importances_))

#피처 중요도를 그래프로 그려 보자
def plot_importance(model, features):
       # 학습한 모델이 가진 속성별 중요도를 importance라는 배열에 담자
       importances = model.feature_importances_
       #np.argsort: 정렬했을 때의 인덱스를 반환
       #피처별 중요도가 있는 배열을 오름차순 정렬했을 때의 순서를 저장
       indices = np.argsort(importances)
       #피처별 중요도가 있는 배열의 요소를 하나씩 꺼내와서 그 인덱스 순서대로 피처이름에 담음
       feature_names = [ features[i] for i in indices ] #오름차순이라 안중요한것부터 먼저임

       #각 피처별 중요도가 있는 배열부터 중요도 순서대로 가져와서 배열 만듦
       feature_imp = importances[indices]

       imp = feature_imp[-20:]
       names = feature_names[-20:]
       ind = indices[-20:]

       # 각 피처별 중요도를 가로 막대로 그리기
       plt.barh(range(len(ind)),imp, align='center')
       plt.yticks(range(len(ind)),names)
       plt.xlabel('Relative importance')
       plt.show()

       return list(reversed(feature_names)), list(reversed(feature_imp))

imp_features, imp_scores = plot_importance(model,selected_features)
print('feature',imp_features)
print('중요도',imp_scores)

# feature ['Sex', 'Age', 'Fare', 'FareLog', 'Title', 'FamilySize', 'Pclass', 'AgeBin', 'Cab_U', 'SibSp', 'Parch', 'Emb_S', 'Tic_NUM', 'Cab_B', 'Cab_E', 'Emb_Q', 'Cab_C', 'Cab_D', 'Tic_PC', 'Tic_STONO', 'Tic_SWPP', 'Tic_CA', 'Tic_A5', 'Tic_WC', 'Tic_SOTONOQ', 'Cab_F', 'Tic_STONO2', 'Tic_C', 'Tic_LINE', 'Tic_SOC', 'Tic_SCPARIS', 'Tic_SOPP', 'Tic_FCC', 'Tic_WEP', 'Cab_G', 'Tic_A4', 'Tic_PP', 'Tic_FC', 'Cab_T', 'Tic_SCParis', 'Tic_SC', 'Tic_SOTONO2', 'Tic_SCAH', 'Tic_SOP', 'Tic_PPP', 'Tic_SP', 'Tic_CASOTON', 'Tic_SCOW', 'Tic_SCA4', 'Tic_AS', 'Tic_Fa', 'Tic_SCA3', 'Tic_LP', 'Tic_AQ4', 'Tic_STONOQ', 'Tic_AQ3']
# 중요도 [0.17319594349926443, 0.15764641908538904, 0.12364696181326539, 0.12021329923557308, 0.09279344283366214, 0.04414890046134162, 0.043965542139981245, 0.043093533565996406, 0.03602153001801349, 0.030214937097845476, 0.020879428475744893, 0.016931726217474186, 0.012902098038852276, 0.008367692327084413, 0.008284077693544877, 0.007386810659022644, 0.006810060167198567, 0.00661128569662604, 0.0065971532307669304, 0.005849420758109802, 0.004520674197277555, 0.004432010356292792, 0.0030513861536292323, 0.002769452022686944, 0.002052957777754192, 0.0019940818061427185, 0.0019864423487049986, 0.0017148468664340444, 0.0016264496626112394, 0.001521046600312417, 0.001436532417186814, 0.0013005016504120553, 0.0010553025303339336, 0.0008213630884742652, 0.0006241780667480125, 0.0006189303095322946, 0.0005531154843572423, 0.000515971749189948, 0.00037343743703057276, 0.0003265152565138356, 0.0002797977868146796, 0.00017770248066580183, 0.00016845361607583826, 0.0001414217494062059, 9.813419988867212e-05, 8.552386646081422e-05, 4.929809583717083e-05, 4.796936472768966e-05, 4.4747584858404156e-05, 2.832519703774456e-05, 2.316726184489382e-05, 0.0, 0.0, 0.0, 0.0, 0.0]

#램덤포레스트모델이 중요하다고 인정한 10개 속성만 추출해 학습시켜보자
selected_features = imp_features[:10]
print(selected_features)
y_train = df.loc[df['TrainSplit']=='Train','Survived']
X_train = df.loc[df['TrainSplit']=='Train',selected_features]
X_test = df.loc[df['TrainSplit']=='Test',selected_features]

from sklearn.model_selection import cross_val_score
from xgboost import XGBClassifier
xgb_model = XGBClassifier(max_depth=3, random_state=1234)
auc_scores = cross_val_score(xgb_model, X_train, y_train, cv=5, scoring='roc_auc')
xgb_model.fit(X_train,y_train)


from sklearn.model_selection import cross_val_score
rf_model = RandomForestClassifier(random_state=1234)
auc_scores = cross_val_score(rf_model, X_train, y_train, cv=5, scoring='roc_auc')
rf_model.fit(X_train,y_train)

#두 모델이 예측한 걸 합쳐서 답안을 만들어보자
# auc스코어 계산 시 분류 라벨(사망0, 생존1)을 사용하는 대신 생존으로 분류될 확률값(0~1)을 써보자
#RandomForestClassifier랑 XGBoost의 각각의 생존할 확률값을 구해보자

# print(y_xgb_proba) print(y_rf_proba)
#  [0.70525    0.29475   ]
#  [1.         0.        ]
#  [0.         1.        ]
#  [0.99       0.01      ]
#  [1.         0.        ]
#  [0.09       0.91      ]] 전자가 사망일 확률, 후자가 생존할 확률

y_xgb_proba = xgb_model.predict_proba(X_test)[:,1]
y_rf_proba = rf_model.predict_proba(X_test)[:,1]

y_proba = (y_xgb_proba+y_rf_proba) /2

submission['Survived'] = y_proba
submission.to_csv(("./Data/titanic_0318_05.csv"),index=False)
print('답안파일 작성')

#80점