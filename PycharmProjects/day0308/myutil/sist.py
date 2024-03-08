import pandas as pd
import konlpy
import re
import matplotlib.pyplot as plt
from wordcloud import WordCloud

def wcmaker(textfile, stop_word, fname):
    txt = open('../Data/'+textfile,encoding='UTF-8').read()
    txt = re.sub('[^가-힣]',' ',txt)
    for word in stop_word:
        txt = re.sub(word, ' ', txt)
    hannanum = konlpy.tag.Hannanum()
    nouns = hannanum.nouns(txt)
    df_word = pd.DataFrame({
        'word':nouns
    })
    df_word['count'] = df_word['word'].str.len()
    df_word = df_word.query('count>=2')
    df_word = df_word.groupby('word',as_index=False).agg(n=('word','count')).sort_values('n',ascending=False)
    dic_word =df_word.set_index('word').to_dict()['n']
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
    plt.figure(figsize=(10, 10))  # 도화지 크기 설정
    plt.axis('off')  # 축은 표시하지마
    plt.imshow(img_wordcloud)  # 이미지 출력
    # plt.show()
    plt.savefig('./static/'+fname+'.png')
    print(fname+'wordcloud를 만들었습니다.')


