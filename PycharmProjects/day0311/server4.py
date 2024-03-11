from flask import Flask, render_template, request
import myutil.titanic as t
from flask_cors import CORS
#jsonp로 포스트방식 요청 되는지-> get으로 해야댐
# /응답은 list로만 해야하는지 -> 문자열데이터는 홑따옴표나 쌍따로 묶어서 응답해야함
app = Flask(__name__)

CORS(app) #다른(외부) 도메인으로부터의 ajax통신을 허용한다는 뜻



@app.route('/gettitanic' , methods=['POST'])
def insertSubmit():
    print('요청됨.')
    data = "'tiger'"
    return data


if __name__ == '__main__':
    app.run()
