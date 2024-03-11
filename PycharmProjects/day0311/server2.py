from flask import Flask, render_template, request
import myutil.titanic as t
#jsonp로 포스트방식 요청 되는지/응답은 list로만 해야하는지
app = Flask(__name__)

@app.route('/titanic', methods=['GET'])
def insertForm():
    return render_template('titanic.html')

@app.route('/gettitanic' , methods=['GET'])
def insertSubmit():
    data = 'tiger'
    result = "pro('"+data+"')"
    return result


if __name__ == '__main__':
    app.run()
