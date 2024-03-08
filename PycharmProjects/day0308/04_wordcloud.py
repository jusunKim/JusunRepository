import konlpy
import re
import pandas as pd
from wordcloud import WordCloud
import matplotlib.pyplot as plt


moon = open('../Data/speech_moon.txt',encoding='UTF-8').read()
# print(moon)
moon = re.sub('[^가-힣]',' ',moon)
stop_word = ['나라','국민','우리','대통령','우리나라','대한민국']
for word in stop_word:
    moon = re.sub(word,' ',moon)
hannanum = konlpy.tag.Hannanum()
nouns = hannanum.nouns(moon)
df_word = pd.DataFrame({
    'word':nouns
})
df_word['count'] = df_word['word'].str.len()
df_word = df_word.query('count>=2')
df_word = df_word.groupby('word',as_index=False).agg(n=('word','count')).sort_values('n',ascending=False)
dic_word = df_word.set_index('word').to_dict()['n']
font = '../Data/DoHyeon-Regular.ttf'
wc = WordCloud(
    font_path=font,
    width=400,
    height=400,
    background_color='white'
)
wc = WordCloud(font_path=font, width=400, height
=400, background_color='white')
img_wordcloud = wc.generate_from_frequencies(dic_word)
plt.figure(figsize=(10,10)) #도화지 크기 설정
plt.axis('off') #축은 표시하지마
plt.imshow(img_wordcloud) #이미지 출력
# plt.show()
plt.savefig('c:/result/out.png')
print('wordcloud를 만들었습니다.')