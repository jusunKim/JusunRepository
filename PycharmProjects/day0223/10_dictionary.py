a = {"홍길동",20,'서울시 마포구 서교동'} #이건 set
b = {"name":"홍길동", "age":20, "addr":"마포구 서교동"} #이게 dictionary
# print(a,type(a))
# print(b,type(b))

# print(b['name'])
# print(b['age'])
# print(b['addr'])

# a,b = 5,7 파이선은 다중대입이 된다고 했잖아
# print(a)
# print(b)

# data = 5,7 #packing
# print(data)
# a,b = data #unpacking
# print(a)
# print(b)

# for row in b.items(): #items() 딕셔너리에 있는 항목 하나씩 가져오는 거. key랑 value의 한 세트.
#     #그럼 row는 키와 밸류를 패킹해서 가져온 거임
#     key, value = row #row에 있는 걸 key와 value로 unpacking하겟다는 거
#     print(key, value)

print(b.items())
print(b.keys())
print(b.values())