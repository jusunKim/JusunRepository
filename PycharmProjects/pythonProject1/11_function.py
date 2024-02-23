# 자바에서 method같은 파이썬의 function: 함수
# 함수: 문제해결을 위한 서로 관련 있는 명령어들의 집합

'''
함수 만드는 법
    def 함수이름():
        명령어들
        [return 값1, 값2, ...]
'''

#두 개의 수를 매개변수로 전달받아 더하기
# def add(a,b):
#     r = a+b
#     return r
#
# r = add(5,2)
# print(r)

# 두개 수 매개변수로 전달받아 네개연산하는 함수
def calc(a,b):
    add = a+b
    sub = a-b
    multi = a*b
    div = a//b
    return add, sub, multi, div

data = calc(5,2)
# add, sub, mul, div = calc(5,2)
# print(add, sub, mul, div)
