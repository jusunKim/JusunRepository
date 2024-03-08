# import calc
#
# a = calc.add(10,20)
# print(a)

# import calc as c
#
# data = c.add(10,20)
# print(data)

from calc import add
data = add(20,30)
print(data)
print("__name__: "+__name__) #__main__ 아라고 나옴
# 실행을 한 모듈이면 그 값이 __main__이 됨. 여기가 출발점이라는데?
# 호출을 한 곳이라서 __main__이 나온다고함,
# 실행을 한 모듈이면 ==> __main__
# ?



