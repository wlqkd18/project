<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

function memberDelete() {
	
	if(confirm("탈퇴하시겠습니까?")){
		location.href="memberDelete?id=${userInfo.id}"
		return
	}
	return
}
</script>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div class="wrap">
	<h3 align="center">회원정보</h3>
	<div class="infoTable">
		<table class="table">
			<tr><th>아이디 : </th><td>${userInfo.id}</td></tr>
			<tr><th>비밀번호 : </th><td>*******</td></tr>
			<tr><th>이메일 : </th><td>${userInfo.email}</td></tr>
			<tr><th>우편번호 : </th><td>${addr[0]}</td></tr>
			<tr>
				<th>주소 : </th><td>${addr[1]}</td>
				<th>상세주소 : </th><td>${addr[2]}</td>
			</tr>
			<tr>
				<td><input type="button" class="btn btn-dark" onclick="location.href='memberModify?id=${userInfo.id}'" value="수정"></td>
				<td><input type="button" class="btn btn-dark" onclick="history.back()" value="취소"></td>
				<c:if test="${loginUser == 'admin'}">
					<td><input type="button" class="btn btn-dark" onclick="memberDelete()" value="탈퇴">
				</c:if>
			</tr>		
		</table>
	</div>
</div>
</body>
</html>