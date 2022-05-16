<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
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

</script>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div class="wrap">
	<h3 align="center">회원 정보 수정</h3>
	<div class="modifyTable">
		<form action="modifySuccess" method="post">
			<table class="table">
				<tr><th>아이디 : </th><td><input type="text" name="id" readonly value="${userInfo.id}"></td></tr>
				<tr><th>비밀번호 : </th><td><input type="password" name="pw" value="${userInfo.pw}"></td></tr>
				<tr><th>이메일 : </th><td><input type="email" name="email" value="${userInfo.email}"></td></tr>
				<tr>
					<th>우편번호 : </th><td><input type="text" id="addr1" name="addr" readonly value="${addr[0]}"></td>
					<td><input type="button"  onclick="address()" value="주소검색"></td>
				</tr>
				<tr>
					<th>주소 : </th><td><input type="text" id="addr2" name="addr" readonly value="${addr[1]}"></td>
					<th>상세주소 : </th><td><input type="text" id="addr3" name="addr" value="${addr[2]}"></td>
				</tr>
				<tr>
					<td><input type="submit" value="확인" class="btn btn-dark"></td>
					<td><input type="button" onclick="history.back()" value="취소" class="btn btn-dark"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>