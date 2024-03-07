'''
    클래스를 만들 떄에 멤버변수(속성)을 외부로부터 보호하기 위해
    변수명 앞에 __을 붙인다
'''

class Rectangle:
    # def __init__(self):
    #     self.width = 2
    #     self.length = 3

    def __init__(self,width=0,length=0):
        self.__width = width
        self.__length = length

    def calcArea(self):
        return self.__width * self.__length

    def setWidth(self,width):
        self.__width =width

    def setLength(self,length):
        self.__length =length

    def getWidth(self):
        return self.__width

    def getLength(self):
        return self.__length

r = Rectangle(2,3)
print(r.calcArea())
print("width",r.getWidth())
print("width",r.getLength())
# print(r.__width) #이제 여기는 접근이 안 됨
