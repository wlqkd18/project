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
	<div class="management">
		<table>
			<tr><th>관리</th></tr>
			<tr><th><a href="memberManage">회원관리</a></th></tr>
			<tr><th><a href="">전체 주문 내역</a></th></tr>
			<tr><th><a href="/ssg/product/productBoard">상품</a></th></tr>
		</table>
	</div>
</div>
</body>
</html>