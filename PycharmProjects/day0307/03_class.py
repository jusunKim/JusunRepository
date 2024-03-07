class Calculator:
    def __init__(self): #self는 자바의 this같은 역할. 자기 자신에 접근하기 위한 변수
        self.result = 0 #이 클래스의 속성(멤버변수)는 result로 구성이 된다는 얘기

    def add(self,num):
        self.result += num
        return self.result

    def sub(self,num):
        self.result -= num
        return self.result

c1 = Calculator() #객체생성하는법
c2 = Calculator() #c1이랑 c2는 다른거임
print(c1.add(5))
print(c2.add(10))
print(c1.sub(1))
print(c2.sub(1))