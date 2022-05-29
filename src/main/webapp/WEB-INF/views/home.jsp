<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function memberDelete() {
	if(${loginUser == null}) {
		alert("로그인이 필요합니다.")
	}else if(confirm("정말 탈퇴하시겠습니까?")){
		location.href="member/memberDelete?id=${loginUser}"
		location.href="member/logout"
	}
}
</script>
</head>
<body>
<c:import url="default/header.jsp"/>
<div class="wrap">
	<c:if test="${loginUser == null}">
		<form action="/ssg/member/login" method="post">
			<input type="text" name="id" placeholder="ID" size="17.5"><br>
			<input type="password" name="pw" placeholder="PASSWORD" size="17.5"><br>
			<input type="submit" value="로그인" class="btn btn-dark">
			<input type="button" value="회원가입" class="btn btn-dark" onclick="location.href='member/register'" >
		</form>
	</c:if>
	<c:if test="${loginUser != null}">
		<div class="loginTable">
		<table>
			<tr>
				<td>${loginUser}님</td>
			</tr>
			<tr>
				<td><input type="button" class="btn btn-dark" onclick="location.href='member/logout'" value="로그아웃"></td>
				<c:if test="${loginUser == 'admin'}">
					<td><input type="button" class="btn btn-dark" onclick="location.href='member/managementForm'" value="관리"></td>
				</c:if>
			</tr>
		</table>
		</div>
	</c:if>
	<div class="myPageDiv">
		<table>
			<tr><th>내정보</th></tr>
			<tr><td><a href="member/userInfo?id=${loginUser}">개인정보 수정</a></td></tr>
			<tr><th>상품</th></tr>
			<tr><td><a href="">주문 내역 조회</a></td></tr>
			<tr><td><a href="">장바구니</a></td></tr>
			<tr><td><a href="">후기</a></td></tr>
			<tr><td><a href="" onclick="memberDelete()">회원 탈퇴</a></td></tr>
		</table>
	</div>
</div>
</body>
</html>