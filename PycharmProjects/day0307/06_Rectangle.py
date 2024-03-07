class Rectangle:
    # def __init__(self):
    #     self.width = 2
    #     self.length = 3

    def __init__(self,width=0,length=0):
        self.width = width
        self.length = length

    def calcArea(self):
        return self.width * self.length

    def setWidth(self,width):
        self.width =width

    def setLength(self,length):
        self.length =length

    def getWidth(self):
        return self.width

    def getLength(self):
        return self.length

r = Rectangle(2,3)
print(r.calcArea())
print("width",r.getWidth())
print("width",r.getLength())
print(r.width) #이걸로도 접근이 됨. public이라는 얘기