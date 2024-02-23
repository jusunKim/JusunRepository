# data = [100,200,300]
# print(data)
# print(type(data))
# print(data[0])

# # 연습) 0에서 9사이의 정수 입력받아 한글표기식 출력하
# n = int(input("0에서 9 사이의 정수 입력하세여==>"))
# 
# kor = ['영','일','이','삼','사','오','율','칠','팔','구']
# print(kor[n])

# 0에서 99사이 수 입력받아 한글표기식출력
n = int(input("0에서 99 사이의 정수 입력하세여==>"))
tens= n//10
ones= n%10
word=''
kor = ['영','일','이','삼','사','오','율','칠','팔','구']

if 0 <= n <=99:
    if tens>0:
        if tens>1:
            word+=kor[tens]
        word+='십'
        if ones>0:
            word+=kor[ones]
    else:
        word+=kor[ones]
    print(word)
else:
    print("범위를 넘었습니다")
