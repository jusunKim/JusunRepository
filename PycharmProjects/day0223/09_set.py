# set은 중복을 허용하지 않는다(자바랑 똑같이)

a = [1,3,5,7,9,7,5]
b = {1,3,5,5,5,7,9}
print(a,type(a))
print(b,type(b))

a = set(a);
print(a,type(a))