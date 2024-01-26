<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.hovered{
		background: yellow
	}
	.meclicked{
		background: pink
	}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		function loadDept(){
			$.ajax({
				url: "listDept",
				success:function(r){
					$("#list").empty()
					$.each(r, function(){
						var td1 = $("<td></td>").html(this.dno)
						var td2 = $("<td></td>").html(this.dname)
						var td3 = $("<td></td>").html(this.dloc)
						var tr = $("<tr></tr>").append(td1, td2, td3);
						/* $(tr).attr("dno",this.dno); 젛은 아이디어였지만 더 좋은 게 있었다..
						$(tr).attr("dname",this.dname);
						$(tr).attr("dloc",this.dloc); */
						$("#list").append(tr);
					});
				}
			})
		}
		
		loadDept();
		
	 	$("#btnInsert").click(function(){
			var data = $("#f").serializeArray();
			$.ajax({
				url:"insertDept",
				data: data,
				success:function(){
					loadDept();
				}
			})
			$(".input").val("");
		})
	 	$("#btnUpdate").click(function(){
			var data = $("#f").serializeArray();
			$.ajax({
				url:"updateDept",
				data: data,
				success:function(){
					loadDept();
				}
			})
			$(".input").val(""); //누르고 나면 비워주려고
		})
	 	$("#btnDelete").click(function(){
			var re = confirm("정말 삭제할까요...?"); //js에서 confirm으로 물어보는 거!!!
			if(re==true){ //confirm은 boolean을 반환
				var data = {dno:$("#dno").val()}
				$.ajax({
					url:"deleteDept",
					data: data,
					success:function(){
						loadDept();
					}
				})
				$(".input").val(""); //누르고 나면 비워주려고
			}
		})
		
		
		
		$("#list").on("mouseenter","tr", function(){
			$(this).addClass("hovered");
		}).on("mouseleave","tr",function(){
			$(this).removeClass("hovered");
		}).on("click","tr",function(){
			$("tr").removeClass("meclicked");
			$(this).addClass("meclicked");
			/* var idno = $(this).attr("dno")
			var idname = $(this).attr("dname")
			var idloc = $(this).attr("dloc")
			$("#dno").val(idno);
			$("#dname").val(idname);
			$("#dloc").val(idloc); */
			var tdList = $(this).find("td");
			$("#dno").val($(tdList[0]).html());
			$("#dname").val($(tdList[1]).html());
			$("#dloc").val($(tdList[2]).html());
		})
	});
</script>
</head>
<body>
	<h2>부서 목록</h2>
	<table border="1" width="80%">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>부서위치</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
	<hr>
	<h2>부서 등록</h2>
	<form id="f">
		부서번호: <input name="dno" id="dno" class="input"><br>
		부서명:<input name="dname" id="dname" class="input"><br>
		부서위치:<input name="dloc" id="dloc" class="input"><br>
	</form>
	<button id="btnInsert">등록</button>
	<button id="btnUpdate">수정</button>
	<button id="btnDelete">삭제</button>
</body>
</html>