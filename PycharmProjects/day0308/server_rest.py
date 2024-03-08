from flask import Flask
from flask import render_template
import memberDAO as dao
import myutil.sist as st
from flask import request

app = Flask(__name__) #__name__은 이 모듈의 이름을 알려준대


#listMember라고 요청하면 모등 고객목록 출력하는 웹페이지만들어바
@app.route('/listMember')
def listMemberShow():
    data = list(dao.listMember())
    for row in data:
        del row['_id']
    print(data)
    print(type(data))

    #그냥 data로 냅다 보내면 얘를 스프링에서 못알아먹음. 함수에 싸서 보내야댐
    return "pro("+str(data)+")"


if __name__ == '__main__': #여기가 출발점이라면 서버를 가동시키라는 소리
    app.run()