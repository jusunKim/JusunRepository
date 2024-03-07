a=100
def add(num):
    a= 5
    print(num+1)
    print(a) #지역변수가 전역변수보다 우선순위가 높다

def sub(num):
    global a #전역변수 a를 쓸 거라고 명시하는 게 일반적.
    print(num-1)
    print(a) #얘는 전역변수 a임
    a= a+100
add(5)
sub(5)
print(a)

