# 사칙연산 수행하는 클래스만들업자

class FourCal:
    def __init__(self): #얘가 생성자 역할을 하는 애
        self.first = 4
        self.second = 2

    def __init__(self,first=2, second=3): #이제는 매개변수가 필요함 얘를 부를 때
        self.first = first
        self.second = second


    def add(self):
        return self.first + self.second

    def sub(self):
        return self.first - self.second

    def multi(self):
        return self.first * self.second

    def div(self):
        return self.first//self.second

n = FourCal(4,10) #객체 생성
k = FourCal()
print(k)
print(n.add())
print(n.sub())
print(n.multi())
print(n.div())

#상속하기
# FourCal을 확장해서 MoreFourCal을 만들어보자
'''
    자바에서 클래스 상속 
        class 클래스이름 extends 부모클래스이름
        
    파이썬에서 클래스 상속
        class 클래스이름(부모클래스이름)
'''
class MoreFourCal(FourCal):

    def __init__(self,first, second, third):
        FourCal.__init__(self,first,second) #자바의 super같은거. 부모거 가져와가지고
        self.third = third

    def pow(self):
        return self.first ** self.second

    def div(self): #메소드 재정의(오버라이딩) 가능
        result = 0
        if self.second != 0:
            return self.first // self.second
        return result


c= MoreFourCal(2,3,4)
print(c.pow())
print(c.add())
print(c.sub())
print(c.multi())
print(c.div())

# MoreFourCal에서 divide를 재정의핮
# 분모가 0이 아니라면 나누기를 하고 아니면 0을 반환하게

