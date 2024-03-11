from flask import Flask, render_template, request
import myutil.titanic as t

app = Flask(__name__)

@app.route('/titanic', methods=['GET'])
def insertForm():
    return render_template('titanic.html')

@app.route('/gettitanic' , methods=['GET'])
def insertSubmit():
    pclass = request.args.get('pclass')
    sex = request.args.get('sex')
    age = request.args.get('age')
    sibsp = request.args.get('sibsp')
    parch = request.args.get('parch')
    fare = request.args.get('fare')
    embarked = request.args.get('embarked')
    who = request.args.get('who')
    result = t.titanic_survivor(pclass, sex, age, sibsp, parch, fare, embarked, who)
    print(pclass, sex, age, sibsp, parch, fare, embarked, who, result)
    return "pro(" + str(result) + ")"

if __name__ == '__main__':
    app.run()
