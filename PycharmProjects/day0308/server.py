from flask import Flask
from flask import render_template
import memberDAO as dao
import myutil.sist as st

app = Flask(__name__) #__name__은 이 모듈의 이름을 알려준대

@app.route('/hello')
@app.route('/hello/<irum>') #hello를 요청할 때 irum을 전달해 줄 수도 있고
def hello(irum=None): #name이 안 오면 기본값은 None이야
    return render_template('hello.html',name=irum, age=20) #model같은 거임. 상태유지하는거

#listMember라고 요청하면 모등 고객목록 출력하는 웹페이지만들어바
@app.route('/listMember')
def listMemberShow(list = None):
    list = dao.listMember()
    return render_template('listMember.html',list=list)

@app.route('/insertMember', methods=['GET'])
def insertFormShow():
    return render_template('insertForm.html')

from flask import request
@app.route('/insertMember', methods=['POST'])
def insertSubmit():
    id = request.form['id']
    name = request.form['name']
    age = request.form['age']
    doc = {
        'id':id, 'age':age, 'name':name
    }
    dao.insertMember(doc)
    return render_template('listMember.html',list = dao.listMember())

@app.route('/makeWordCloud', methods=['GET'])
def makeWordCloudShow():
    return render_template('makeWordCloud.html')

@app.route('/makeWordCloud', methods=['POST'])
def makeWordCloudSubmit():
    textfile = request.form['textfile']
    stop_word = request.form['stop_word']
    fname = request.form['fname']
    list = stop_word.split(",")
    print(list)
    print(fname)
    st.wcmaker(textfile,list,fname)
    return render_template('showWordCloud.html', img=fname)

@app.route('/') #루트 요청하면 헤롤월드나옴
def hello_world():
    return 'Hello World!'

@app.route('/list')
def list():
    return 'list book'



if __name__ == '__main__': #여기가 출발점이라면 서버를 가동시키라는 소리
    app.run()