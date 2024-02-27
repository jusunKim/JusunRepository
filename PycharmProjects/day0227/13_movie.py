import pandas as pd
import numpy as np

users = pd.read_csv("../Data/ml-1m/users.dat",sep="::",header=None,engine='python')
print(users.head())
users.columns = ['UserID','Gender','Age','Occupation','zip-code']
print(users.head())
print(users['Gender'].value_counts())

movies = pd.read_csv("../Data/ml-1m/movies.dat",sep="::",header=None,engine='python')
movies.columns = ['movieID','title','genres']
print(movies.head())
print(movies['genres'].value_counts())
