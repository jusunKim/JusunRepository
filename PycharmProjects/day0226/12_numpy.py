import numpy as np

# a = [10,20,30,40,50]
# b = np.array(a)
# print(b,type(b))

def notUsed():
    a=np.arange(5)
    print(a,type(a))

    a = np.arange(10)
    b = np.arange(1,11,1)
    print(a)
    print(b)
    c=np.arange(1,21,2)
    print(c)
    d = np.arange(10,-1,-1)
    print(d)

    a=[1,2,3,4,5]
    b=[1.0,2.0,3.0,4.0,5.0]
    c=["사과","ㅠ포도","수박","오렌지"]
    d = [True,False,False,True]

    data_a = np.array(a)
    data_b = np.array(b)
    data_c = np.array(c)
    data_d = np.array(d)

    print(data_a.shape,data_a.ndim,data_a.dtype)
    print(data_b.shape,data_b.ndim,data_b.dtype)
    print(data_c.shape,data_c.ndim,data_c.dtype)
    print(data_d.shape,data_d.ndim,data_d.dtype)

    arr = [[1,2,3],[4,5,6]]
    data = np.array(arr)
    print(data.shape,data.ndim,data.dtype)

    a = [1,2,3,4,5,6,7,8,9,10]
    b = np.array(a)
    # c = b.reshape(2,5)
    c = b.reshape(-1,5) #-1을 주면 알아서 하라는 뜻
    print(c)
    print(c.shape,c.ndim)

    a = range(5)
    b = np.arange(5)
    c= np.array(a)
    print(a,type(a))
    print(b,type(b))
    print(c,type(c))

    #0-5까지 정수가 들어있는 2행3열의 배열을 만들기
    # b=np.arange(6)
    b=np.array(range(6))
    c=b.reshape(2,3)
    print(c)

    a = np.arange(6).reshape(2,3)
    b  = a.reshape(-1)
    list = list(b)
    print(list)

    a = np.arange(10)
    print(a)
    # a = a + 1
    # print(a)
    print(a+1) #broadcasting : 배열의 원소만큼 연산 수행
    print(a**2)
    print(a>1)
    print(a[a>1])

    a = [0,1,2,3,4,5,6,7,8,9]
    print(a[0],a[1]) #특정 위치에 있는 걸 가져옿는 인덱싱
    print(a[-1],a[-2]) # 맨 끝: -1
    print(a[3:7])
    print(a[::2])
    print(a[1::2])

    a = [0,1,2,3,4,5,6,7,8,9]
    print(a[::-1]) #처음부터 끝까지 역순으로

    a = np.arange(3)
    b = np.arange(3)
    print(a,b)
    print(a+1) # ==> BroadCasting : 각 배열의 원소에 1을 더함
    print(a+b) # ==> Vector Operation: 각 배열의 원소끼리 연산 => 두 배열의 원소 수 동일해야댐
    print(a>b)

#서로 연산이 가능한지?
a = np.arange(3) #[0 1 2 ]
b = np.arange(6)#[0 1 2 3 4 5]
c = np.arange(3).reshape(-1,3) #[[0 1 2]]
d = np.arange(6).reshape(-1,3) #[[0 1 2]
                                #[3 4 5]]
e = np.arange(3).reshape(3,-1) #세로 [[0]
                                  # [1]
                                  # [2]]


print(a+c) #broadcast?
print(a+d)
print(a+e)
print(b+e)
print(c+d)
print(c+e)