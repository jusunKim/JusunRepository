import numpy as np

def notUsed():
    # a = [1,2,3,4,5]
    # b = np.array(a) #파이썬 리스트 가지고 numpy 배열 만들기
    # c = np.arange(5) #순차적 배열 갖고 numpy 배열 만들기

    a = np.zeros(10, np.int32)
    print(a,type(a))

    c = np.ones(10,dtype=np.int32)
    print(c)

    e = np.zeros([3,4], np.int32)
    print(e)

    g = np.full(10,5)
    print(g)

    h = np.full([2,3],2)
    print(h)


    a = np.arange(12).reshape(-1,4)
    print(a)
    print(np.sum(a, axis=0))
    print(np.sum(a, axis=1))

    #누ㅠ적합: cumsum
    a = np.arange(4)
    print(a)
    print(np.cumsum(a,axis=0))

    a = np.arange(12).reshape(-1,4)
    print(a)
    print(np.cumsum(a, axis=0))

    a = np.arange(12).reshape(-1,4)
    b = np.zeros_like(a)
    c = np.zeros(a.shape)
    print(b)
    print(c)

    print(np.random.random(3)) #==> 0과 1사이의 난수 3개 만들어줘
    print(np.random.random([2,3])) #==>0과 1사이의 난수 2행 3열의 배열로 만들어줘

    print(np.random.uniform(size=(2,3)))
    print(np.random.normal(size=(2,3)))

    a = np.arange(10)
    print(a)

    b = np.random.choice(a,3)
    print(b)

    a = [0,1,2,3,4,5,6,7,8,9,10,11]
    print(a,type(a))
    b = np.array(a)
    print(b,type(b))
    print(a[0],b[0])
    #2차원배열을만들어보자
    a = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    b = np.array(a)
    print(a,type(a))
    print(b,type(b))
    print(a[0])
    print(b[0])
    print(a[1:])
    print(b[1:])
    print(a[0][0])
    print(b[0][0])
    print(a[-1][-1])
    print(b[-1][-1])

    a = np.arange(12)
    print(a[::-1])

    a=np.arange(12).reshape(-1,4)
    print(a[::-1])
    print(a[::-1,::-1]) #fancy indexing

    a = [80,90,65,70,92,96]
    a= np.array(a)
    print(a[a>=80])
    # arr80 = [0,1,4,5]
    arr80 = a[a>=80]
    print(arr80)

    a = np.arange(12).reshape(-1,4)
    print(a)
    row = [0,2]
    col = [1,2]
    # [[ 0  1  2  3]
    #  [ 4  5  6  7]
    #  [ 8  9 10 11]]
    b = a[row,col]
    print(b)

    a=np.arange(12).reshape(-1,4)
    print(a)
    a[0] = -1
    print(a)

    a[::]=-1
    print(a)

    a[:,0]=9
    print(a)

#테두리가 1로 채워지고 속은 0으로 채워진 5*5배열 만들기
a = np.zeros(25).reshape(5,5)
a[0,:]=1
a[-1,:]=1
a[:,0]=1
a[:,-1]=1

print(a)
print("-"*10)
b = np.ones(25).reshape(5,5)
b[1:4,1:4]=0
print(b)
