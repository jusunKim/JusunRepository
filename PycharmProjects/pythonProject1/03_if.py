'''
    if문의 형식

    if 조건식:
        명령어1
        명령어2
    else:
        명령어3
        명령어4
'''

# 연습) 어떤 수를 입력받아 짝수인지 홀수인지 판별하여 출력
# n = int(input("수 입력=>"))
# if n % 2 == 0:
#     print("짝수")
# else:
#     print("홀수")

# 연습)사용자에 세 개 수 입력받아 개중 가장 큰 수를 출력
# n1 = int(input("수1입력==>"))
# n2 = int(input("수2입력==>"))
# n3 = int(input("수3입력==>"))
# max=n1
# if(max<n2):
#     max=n2
#     if(max<n3):
#         max=n3
# else:
#     if(max<n3):
#         max=n3
# print(max)\

'''
    물어봐야 할 것이 많을 때 elif를 쓴다
    if 조건1:
        명령1
    elif 조건2:
        명령2
    elif 조건3:
        명령3
    else:
        명령4
'''
# 연습) 0에서 9사이의 정수 입력받아 한글표기식 출력하
n = int(input("0에서 9 사이의 정수 입력하세여==>"))
# if n == 1:
#     print("일")
# elif n==2:
#     print("이")
# elif n==3:
#     print("삼")
# elif n==4:
#     print("사")
# elif n==5:
#     print("오")
# elif n==6:
#     print("율")
# elif n==7:
#     print("칠")
# elif n==8:
#     print("팔")
# elif n==9:
#     print("구")
# elif n==0:
#     print("영")
# else:
#     print("잘못입력햇습니다.")

if n >= 0 and n <= 9:
    if n==0 : kor="영"
    elif n==1 : kor="일"
    elif n==2 : kor="이"
    elif n==3 : kor="삼"
    elif n==4 : kor="사"
    elif n==5 : kor="오"
    elif n==6 : kor="율"
    elif n==7 : kor="칠"
    elif n==8 : kor="팔"
    elif n==9 : kor="구"
    print(kor)
else:
    print("입력 범위를 넘었습니다")