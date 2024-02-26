import re

db = '''
3412    Bob 123
3834  Jonny 333
1248   Kate 634
1423   Tony 567
2567  Peter 435
3567  Alice 535
1548  Kerry 534
1548  Tiger 534
'''

# print(db)

# 숫자만 출력하기
# result = re.findall("[0-9]+",db)
# print(result)
# print(type(result))

# #이름만 출력하기
# names = re.findall("[A-Z][a-z]+",db)
# print(names)

# 전화번호만 출력하기
# phones = re.findall("[0-9]{4}",db)
# phones = re.findall("\\d{4}",db)
# phones = re.findall("^\\d+",db,re.MULTILINE)
# print(phones)

#아이디만 출력하기
# ids = re.findall("\\b[0-9]{3}\\b",db)
# ids = re.findall("\\d+$",db,re.MULTILINE)
# print(ids)

#t로시작하는 이름만 찾아서출력
# ts = re.findall("T[a-z]+",db)
# print(ts)

# T로시작하지않는이름만 찾아
# notts = re.findall("[^T][a-z]+",db)
notts = re.findall("[A-SU-Z][a-z]+",db);
print(notts)
