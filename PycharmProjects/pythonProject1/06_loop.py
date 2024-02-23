# 반복문: while, for
# n = 1
# while n<=3:
#     print("hello")
#     n = n+1
# print("완료")
# print(n)

# 연습)사용자에 n을 입력받아 1에서 n까지의 합을 누적해출력하기
# n = int(input("정수를 입력하세요==>"))
# total = 0
# i=1
# while i<=n:
#     total += i
#     i = i+1
# print("합계: ",total)

# 연습 1에서 10까지의 모든 수 출력
# i = 1
# while i<=10:
#     print(i, end=" ")
#     i+=1

# 사용자에 n입력받아 n!을 구해 출력
# n = int(input("n을 입력하세요==>"))
# total = 1
# i=1
# while i<=n:
#     total *= i
#     i+=1
# print(n,"! = ",total)
# n = int(input("n을 입력하세요==>"))
# r = 1
# i=n
# while i>=1:
#     r*=i
#     print(i,end=" ")
#     if i !=1:
#         print("*",end=" ")
#     i -=1
# print("=",r)

# for
'''
    for의 형식
    for 변수명 in range(시작, 종료, 증감):   //종료는 포함안됨
        명령어
'''
# 1에서 10까지 모든 수를 출력하기
# for i in range(1,11,1):
#     print(i,end=" ")

# for i in range(1,11):
#     print(i,end=" ")
# for i in range(11):
#     print(i,end=" ")

# 구구단 중 2단을 출력
# for i in range(1,10):
#     print("2 * ",i," =",2*i)
#
# # 2단부터 9단까지 출력
# for dan in range(2,10):
#     print("***",dan,"단***")
#     for i in range(1,10):
#         print(dan,"*",i,"=",dan*i)
#     print("-"*10)