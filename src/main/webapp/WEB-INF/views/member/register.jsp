<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript">
let bool = true
function idCheck() {
	let inputId = $("#id").val()
	$.ajax({
		url: "idCheck?id="+inputId, type: "get",
		success: function(data){
			if(data == 0){
				$("#label").html("<b style='color:blue;'>" + inputId + " 는 사용이 가능합니다</b>")
				bool = false 
			}
			else if(data == 1){
				$("#label").html("<b style='color:red;'>이미 존재하는 아이디입니다.</b>")
				bool = true
			}else{
				$("#label").html("<b style='color:red;'>사용 불가능한 아이디입니다.</b>")
				bool = true
			}
		}
	})
}

function address() {
	new daum.Postcode({
        oncomplete: function(data) {
        	var addr = ""
            if(data.userSelectedType == 'R'){
            	addr = data.roadAddress
            }else{
            	addr = data.jibunAddress
            }
        	$("#addr1").val(data.zonecode)
        	$("#addr2").val(addr)
        	$("#addr3").focus()
        }
    }).open();
}

function dataCheck() {
	console.log($("#pw").val())
	if(bool){
		alert("아이디 중복확인이 필요합니다.")
		return
	}else if($("#id").val() == "" ||
		$("#pw").val() == "" ||
		$("#email").val() == "" ||
		$("#addr1").val() == "" ||
		$("#addr2").val() == "" ||
		$("#addr3").val() == "" ){
		alert("모두 작성해주세요")
		return
	}
	rs.submit()
}
</script>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div class="wrap">
	<h3 align="center">회원가입</h3>
	<div class="register_form">
		<form id="rs" action="registerSuccess" method="post">
		<table class="table">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="id" name="id" oninput="idCheck()" maxlength="10">
					<label id=label>아이디 중복확인이 필요합니다.</label>
				</td>
			</tr>
			<tr><th>비밀번호</th><td><input id="pw" type="password" name="pw"></td></tr>
			<tr><th>이메일</th><td><input id="email" type="email" name="email"></td></tr>
			<tr>
				<th>우편번호</th>
				<td>
					<input type="text" id="addr1" name="addr" readonly>
					<input type="button" value="주소 검색" onclick="address()">
				</td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td>
					<input type="text" id="addr2" name="addr" readonly>
					<input type="text" id="addr3" name="addr" >
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="회원가입" class="btn btn-success" onclick="dataCheck()">
					<input type="button" value="취소" class="btn btn-success" onclick="history.back()">
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>
</body>
</html>