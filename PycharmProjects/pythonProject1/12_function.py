# 연습) 듀 슈 매개변수로 받아서 그 중 큰 수 찾아 반환

def max(a,b):
    if a<b: a=b
    return a

print(max(4,2))

# 수 3개 받아 개중 큰 거 반환
def max3(a,b,c):
    return max(max(a,b),c)

print(max3(1,2,3))
print(max3(1,10,3))
print(max3(12,10,3))
