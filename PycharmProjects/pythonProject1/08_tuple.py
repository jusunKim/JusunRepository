# 튜플은 리스트의 상수버전임
a = [1,3,5,7]
b = (1,3,5,7)
print(a,type(a))
print(b,type(b))

# for i in b:
#     print(i)

b=list(b)
print(type(b))
b[0] = 100;
b = tuple(b)
print(b, type(b))