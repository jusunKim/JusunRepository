# 10_employee_somethingwrong.py

class Employee:
    def __init__(self,no,name):
        self.__no = no
        self.__name = name
    def setNo(self,no):
        self.__no = no
    def getNo(self):
        return self.__no
    def setName(self,name):
        self.__name = name
    def getName(self):
        return self.__name
    def computeSalary(self):
        return 0
    # def __str__(self):
    #     return "사원번호:"+str(self.__no)+",사원이름:" + self.__name

    def __str__(self):
        return "사원번호:{},사원이름:{}".format(self.__no,
                                                self.__name)

class SalariedEmployee(Employee):
    def __init__(self,no,name,level):
        Employee.__init__(self, no, name)
        self.__level = level
        self.__base = 0
        self.__sudang = 0
        self.__salary = 0

    def computeSalary(self):
        if self.__level == 1:
            self.__base = 2000000
            self.__sudang = 200000
        elif self.__level == 2:
            self.__base = 3000000
            self.__sudang = 300000
        else:
            self.__base = 4000000
            self.__sudang = 400000
        self.__salary = self.__base + self.__sudang
        return self.__salary

    def __str__(self):
        return "{},호봉:{},기본금:{},수당:{},실수령액:{}".format(Employee.__str__(self),
                                                        self.__level,
                                                        self.__base,
                                                        self.__sudang,
                                                        self.computeSalary())

class HourlyEmployee(Employee):
    def __init__(self,no,name,base,time):
        Employee.__init__(self,no,name)
        self.__base = base
        self.__time = time
        self.__salary = 0

    def computeSalary(self):
        self.__salary = self.__base * self.__time
        return self.__salary

    def __str__(self):
        return "{},시간당임금:{},일한시간:{},실수령액:{}".format(
            Employee.__str__(self),
            self.__base,
            self.__time,
            self.__salary
        )

kim = SalariedEmployee(1000,"김유신",1)
lee = HourlyEmployee(2000, "이순신", 100000, 40)
hong = SalariedEmployee(1001, "홍길동", 2)

print(kim)
print(lee)
print(hong)

kim.computeSalary()
lee.computeSalary()
hong.computeSalary()

print("-"*50)
print(kim)
print(lee)
print(hong)

# 리스트에 데이터를 추가 append
# 위의 세명의 정보를 리스트에 담고, 실수령액을 계산하여
# 정보를 출력 해 보도록 합니다.
print("-"*30)
list = []
list.append(SalariedEmployee(1000,"김유신",1))
list.append(HourlyEmployee(2000, "이순신", 100000, 40))
list.append(SalariedEmployee(1001, "홍길동", 2))
for emp in list:
    emp.computeSalary()
    print(emp)
