
from flask_cors import CORS
from flask import Flask
from flask import render_template
from flask import request
import myutil.titanic as t
from flask_cors import CORS

app = Flask(__name__) #__name__은 이 모듈의 이름을 알려준대
CORS(app)


@app.route('/gettitanic' , methods=['POST'])
def insertSubmit():
    #post방식ㅇ 데이터 가져오기
    pclass = request.form['pclass']
    sex = request.form['sex']
    age = request.form['age']
    sibsp = request.form['sibsp']
    parch = request.form['parch']
    fare =request.form['fare']
    embarked = request.form['embarked']
    who = request.form['who']
    result = "'"+t.titanic_survivor(pclass, sex, age, sibsp, parch, fare, embarked, who)+"'"
    print(pclass, sex, age, sibsp, parch, fare, embarked, who, result)
    return result

if __name__ == '__main__': #여기가 출발점이라면 서버를 가동시키라는 소리
    app.run()