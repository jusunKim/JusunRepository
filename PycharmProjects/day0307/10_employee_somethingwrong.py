class Employee:
    def __init__(self,name='',eno=1):
        self.__name = name
        self.__eno = eno

    def computeSalary(self):
        pass

    def setName(self,name):
        self.__name = name

    def setEno(self,eno):
        self.__eno = eno

    def getName(self):
        return self.__name

    def getEno(self):
        return self.__eno

    # def __str__(self):
    #     return "사원명: "+self.__name+", 사원번호: "+str(self.__eno)

    def __str__(self):
        return "사원명: {}, 사원번호: {}".format(self.__name, self.__eno)

class SalariedEmployee(Employee):
    def __init__(self,name,eno,level):
        Employee.__init__(self,name,eno)
        self.__level = level
        self.__base = 0
        self.__sudang = 0
        self.__salary = 0

    def computeSalary(self):
        if self.__level ==1:
            self.__base = 200000
            self.__sudang = 200000
        elif self.__level ==2:
            self.__base = 300000
            self.__sudang = 300000
        else:
            self.__base = 400000
            self.__sudang = 400000
        self.__salary  =self.__base + self.__sudang
        return self.__salary

    def setLevel(self, level):
        self.__level = level

    def getLevel(self):
        return self.__level


    def __str__(self):
        return "{},호봉: {}, 기본급: {},수당:{}, 실수령액:{}".format(Employee.__str__(self),
                                                          self.__level,
                                                          self.__base,
                                                          self.__sudang,
                                                          self.computeSalary())


class HourlyEmployee(Employee):
    def __init__(self, name='', eno=1, fee=1,hours=52):
        Employee.__init__(self, name, eno)
        self.__fee = fee
        self.__hours =hours

    def computeSalary(self):
        return self.__fee* self.__hours

    def setFee(self, fee):
        self.__fee= fee

    def setHours(self, hours):
        self.__hours = hours

    def getfee(self):
        return self.__fee

    def getHours(self):
        return self.__hours

    def __str__(self):
        return "{},시간당 임금:{},일한 시간:{}, 실수령액:{}".format(Employee.__str__(self),
                                                       self.__fee,
                                                       self.__hours,
                                                       self.computeSalary())

a = HourlyEmployee('김',2,1,52)
print(a.getEno())
print(a.getName())
print(a.getfee())
print(a.getHours())
print(a)

b = Employee('홍길동',100)
print(b)

c = SalariedEmployee('어쩌구',3,1)
print(c)

# 기본급이랑 수당 안나오느거 왜이러는거임 하;;; 선생님거랑비교필

#리스트에 데이터를 추가하는 거 append
# 세명 정보 리스트에담고 실수려ㅑㅇ액계산해서 정보뽑기