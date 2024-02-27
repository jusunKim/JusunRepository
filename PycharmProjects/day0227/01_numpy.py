import numpy as np

def f():
    a = np.zeros([5,5])
    # for i in range(5):
    #     a[i,i] = 1
    a[[0,1,2,3,4],[0,1,2,3,4]] = 1
    print(a)

    b = np.eye(5,5)
    print(b)

    c =np.zeros([5,5])
    c[range(5),range(5)]=1
    print(c)

    #해당 열위치에 1채우기
    a=[1,7,0,3,1]
    x=np.zeros([len(a),np.max(a)+1],np.int32)
    x[range(len(a)),a]=1
    print(x)

    a=[1,7,0,3,1]
    a = np.eye(5,5)[[1,2,0,1,3]]
    print(a)

# a=[1,7,0,3,1]
# # b = np.eye(len(a),np.max(a)+1)[a]
# b = np.eye(8,8)[a]
# print(b)

    a = [3,1,2]
    a.sort()
    print(a)

    b=np.array(a)
    b.sort()
    print(b)

    a = np.array([3,1,2])
    b = np.argsort(a)
    print(b)
    print(a[b])

    a = np.array([4,3,1,5,2])
    print(np.max(a)) #최대값
    print(np.argmax(a)) #최대갓의 인덱스

a = [1,2,3,4,5]
b = np.array(a)

b1 = b # 얕은 복사: 걍 동일한 변수를 참조할 뿐
b2 = b.copy() #얘가 진짜 copy: 깊은 복사
b3 = b[:] # 얕은 복사: 걍 동일한 변수를 참조할 뿐
b[0]=100
print(b)
print(b1)
print(b2)
print(b3)