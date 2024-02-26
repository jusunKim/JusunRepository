import json
import requests

# j1 = '{"ip":"192.163.123.1"}'
# print(j1)
# print(type(j1))
#
# j2 = json.loads(j1)
# print(j2)
# print(type(j2))
# print(j2["ip"])
#
# data = { #현재 얘는 딕셔너리
#     "no":10,"item":"재미있는자바","price":5000,"qty":20
# }
# print(data)
# print(type(data))
#
# data2 = json.dumps(data)
# print(data2)
# print(type(data2))

data='''
{
    "dno":10,
    "dname":"개발1팀",
    "dloc":"판교"
}
'''
dicData = json.loads(data)
for key in dicData:
    print(dicData[key])
