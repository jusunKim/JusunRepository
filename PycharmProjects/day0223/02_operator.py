# # 연산자: 산술, 비교, 논리
a, b = 5, 2
# print(a+b)
# print(a-b)
# print(a*b)
# print(a/b)
# print(a//b)
# print(a**b)
# print(a%b)
# print("-"*50)
# a+=1
# print(a)
#
# print(a>b)
# print(a>=b)
# print(a<b)
# print(a<=b)
# print(a==b)
# print(a!=b)
#
# a = '10'
# b= '20'
# print(a+b)
# print(int(a)+int(b))

# 0이 아닌 값이 있는 상태는 True
# a=10
# b=-5
# c=0
# d='hello'
# e=3.14
# f=0.0
# print(a,bool(a))
# print(b,bool(b))
# print(c,bool(c))
# print(d,bool(d))
# print(e,bool(e))
# print(f,bool(f))

# print(int(True)) #1
# print(int(False)) #0

# name = input("이름을 입력하시오==>")
# print(name)

# # 사용자에 숫자 입력바다 1더해서 출력하기
# n = input("숫자를 입력하세여==>")
# n= int(n)+1
# print(n)

#사용자에 나이 입력받아 20살 이상인지 판별하여 True/false를 출력
# age = input("나이를 입력하세여=>")
# if int(age)>=20:
#     print("true")
# else:
#     print("False")

# age= int(input("나이를 입력하세요"))
# re= age>=20
# print(re)

# 두 사람의 나이 입력 받아 모두 스무살이상이면 True/아니면 False를 출력
# re1 = int(input("사람1 나이 입력: "))>=20
# re2 = int(input("사람2 나이 입력: "))>=20
# if re1 and re2:
#     print(True)
# else:
#     print(False)

age1 = int(input("사람1 나이 입력: "))
age2 = int(input("사람2 나이 입력: "))
re = age1 >=20 and age2>=20
print(re)