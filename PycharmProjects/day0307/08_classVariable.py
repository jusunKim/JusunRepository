# 클래스 변수: 모든 객체가 공동으로 사용하는 변수
# 인스턴스 변수: 객체마다 별도의 메모리 공간이 잡히는 멤버 변수

class Family:
    lastname = '김' #클래스변수

    def __init__(self,firstname):
        self.firstname = firstname #객체마다 메모리 공간 따로 잡힘

#클래스 변수에 접근하려면 클래스 이름으로 접근한다. 자바처럼

print(Family.lastname)

a = Family('철수')
b = Family('영희')
c = Family('바둑이')
print(a.firstname)
print(b.firstname)
print('-'*30)
print(a.lastname)
print(b.lastname)

print('-'*30)
Family.lastname = '홍' #이건 클래스변수 자체에 접근해서 변경 => 클래스 변수lastname이 홍으로 싹바뀜
print(a.lastname)
print(b.lastname)

print('-'*30)
a.lastname ='박' #객체에접근해서 변경 => a의 lastname만 박으로 변경
print(a.lastname)
print(b.lastname)
print(c.lastname)
#객체를 통해서도 클래스 변수 사용할 수 있다.
# 근데 이렇게 객체를 통해 클래스변수 변경할 때는 그 변수에만 해당이 되고 클래스변수에는 영햐잉 없다.

