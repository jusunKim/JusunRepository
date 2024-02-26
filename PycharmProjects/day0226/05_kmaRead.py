#kma.csv 파일 읽어들여 출력
f = open("./Data/kma.csv","r",encoding="utf-8")
lines = f.readlines()
for row in lines:
    print(row,end="")
f.close()