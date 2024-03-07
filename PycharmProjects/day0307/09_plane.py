class Plane:
    planes = 0

    def __init__(self,pro='',model='',max=0):
        self.__pro =pro
        self.__model = model
        self.__max = max
        Plane.planes +=1

    # @value.setter
    def setPro(self,pro):
        self.__pro = pro

    def setModel(self,model):
        self.__model = model

    def setMax(self,max):
        self.__max = max

    def getPro(self):
        return self.__pro

    def getModel(self):
        return self.__model
    def getMax(self):
        return self.__max

planeA = Plane('에어버스','A380',500)
print('비행기 대수',Plane.planes)
planeB = Plane('에어버스2','A360',400)
print(planeA.getMax())
print('비행기 대수',Plane.planes)
planeA.setMax(300)
print(planeA.getMax())
print(planeB.getMax())
