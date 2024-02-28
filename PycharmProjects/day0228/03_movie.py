import numpy as np
import pandas as pd

def getMovies():
    users = pd.read_csv("../Data/ml-1m/users.dat", sep="::", header=None, engine='python',
                        names=['UserID', 'Gender', 'Age', 'Occupation', 'Zip-code']) #r가져올 때 한번에 하는 게 좋겟군..
    movies = pd.read_csv("../Data/ml-1m/movies.dat", sep="::",header=None,engine='python',
                         names=['MovieID','Title','Genres'])
    ratings = pd.read_csv("../Data/ml-1m/ratings.dat", sep="::",header=None,engine='python',
                          names= ['UserID','MovieID','Rating','Timestamp'])
    df = pd.merge(pd.merge(ratings,users),movies)
    return df

df = getMovies()
print(df)