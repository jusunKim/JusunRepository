import numpy as np
import pandas as pd

#연습) movie, user, rating을 하나의 df로 merge해서 반환해보삼
def movies():
    users = pd.read_csv("../Data/ml-1m/users.dat", sep="::", header=None, engine='python',
                        names=['UserID', 'Gender', 'Age', 'Occupation', 'Zip-code']) #r가져올 때 한번에 하는 게 좋겟군..
    movies = pd.read_csv("../Data/ml-1m/movies.dat", sep="::",header=None,engine='python')
    ratings = pd.read_csv("../Data/ml-1m/ratings.dat", sep="::",header=None,engine='python')

    # users.columns = ['UserID','Gender','Age','Occupation','Zip-code']
    movies.columns = ['MovieID','Title','Genres']
    ratings.columns = ['UserID','MovieID','Rating','Timestamp']
    df = pd.merge(ratings,users)
    df2 = pd.merge(df,movies)
    # print(users)
    # print(movies)
    # print(ratings)
    return df

movies()