<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div class="wrap">
	<div class="memberListDiv">
		<table class="table">
			<tr>
				<th>아이디</th>	<th>이메일</th>	<th>주소</th>
			</tr>
			<c:forEach var="memberList" items="${memberList}">
				<tr>
					<td><a href="userInfo?id=${memberList.id}">${memberList.id}</a></td>	<td>${memberList.email}</td>	<td>${memberList.addr}</td>	
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>