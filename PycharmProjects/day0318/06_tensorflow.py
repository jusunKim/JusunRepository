import tensorflow as tf

print(tf.__version__) #2.16.1

x=[-3,31, -11, 3, 0, 22,-2, -5, -25, -14]
y=[-2, 32, -10, 4, 1, 23, -1, -4, -24, -13]

import numpy as np
import pandas as pd
X_train = np.array(x).reshape(-1,1)
y_train = np.array(y)

#다층신경망을 위해 여러 레이어를 쌓아놓기 위한 틀(모델) Sequential
from tensorflow.keras import Sequential
from tensorflow.keras.layers import Dense

model = Sequential()
model.add(Dense(units=1, activation='linear', input_dim=1))
# units= 출력의 수
# activation:활성화 함수
# input_dim: 입력의 수

print(model.summary())
''' 모델의 구조를 출력햇삼. summary()
Model: "sequential"
┌─────────────────────────────────┬────────────────────────┬───────────────┐
│ Layer (type)                    │ Output Shape           │       Param # │
├─────────────────────────────────┼────────────────────────┼───────────────┤
│ dense (Dense)                   │ (None, 1)              │             2 │
└─────────────────────────────────┴────────────────────────┴───────────────┘
 Total params: 2 (8.00 B)
 Trainable params: 2 (8.00 B)
 Non-trainable params: 0 (0.00 B)
'''
#공부할 방향 정해줌
model.compile(optimizer='adam',loss='mse', metrics=['mae'])

#공부 시키기
# model.fit(X_train, y_train, epochs=1000)
#공부상황을 막 출력해줌 저절로;;
model.fit(X_train, y_train, epochs=1000, verbose=0) # 그거출력하지마
print('**학습 완료**')
#학습을 마친 가중치를 확인하기
print(model.weights)

#새로운 데이터 예측시키기
x=np.array([11,12,13]).reshape(-1,1)
y_pred = model.predict(x)
print(y_pred)
# [[11.723412]
#  [12.722916]
#  [13.72242 ]]