from flask import Flask, render_template, request
import myutil.titanic as t
#jsonp로 포스트방식 요청 되는지-> get으로 해야댐
# /응답은 list로만 해야하는지 -> 문자열데이터는 홑따옴표나 쌍따로 묶어서 응답해야함
app = Flask(__name__)



@app.route('/gettitanic' , methods=['GET'])
def insertSubmit():
    print('post방식 요청입.')
    data = 'tiger'
    result = "pro('"+data+"')"
    return result


if __name__ == '__main__':
    app.run()
