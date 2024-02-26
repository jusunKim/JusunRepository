f = open("./Data/hello.txt","r",encoding="utf-8")
lines = f.readlines()
for row in lines:
    print(row,end="")
f.close()