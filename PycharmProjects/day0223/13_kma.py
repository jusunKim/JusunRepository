import re
import requests

url = "https://devweather.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108"
text = requests.get(url).text
# print(text)

# title = re.findall("<title>(.+)</title>",text) #뭐든 올 수 있다는 .이랑 여러자일 수 있으니까 +
# for i in title:
#     print(i)

# re.DOTALL => 찾고자 하는 시작,마지막패턴이 여러 줄에 걸쳐 있다면 이걸 씀
list = re.findall('<location wl_ver="3">(.+?)</location>', text, re.DOTALL)
# print(list)

'''
<tmEf>2024-02-26 00:00</tmEf>
<wf>맑음</wf>
<tmn>-1</tmn>
<tmx>7</tmx>
'''

for row in list:
    city = re.findall('<city>(.+)</city>',row)
    data = re.findall('<data>(.+?)</data>',row,re.DOTALL)
    for d in data:
        tmEf = re.findall('<tmEf>(.+)</tmEf>',d)
        wf = re.findall('<wf>(.+)</wf>',d)
        tmn = re.findall('<tmn>(.+)</tmn>',d)
        tmx = re.findall('<tmx>(.+)</tmx>',d)
        print(city[0], tmEf[0],tmn[0],tmx[0]) #값이 하나밖에 없어도 list로 반환을 해가지고 [0]을 해줌