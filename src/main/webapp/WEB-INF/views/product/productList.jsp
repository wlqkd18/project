<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div class="wrap">
	<div class="productListDiv">
		<table class="table table-striped">
				<tr>
					<th>번호</th>		<th>제목</th>		<th>조회수</th>	<th>이미지 파일 이름</th>		<th>작성날짜</th>
				</tr>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td>${product.productNo}</td>
					<td><a href="productInfo?productNo=${product.productNo}">${product.productName}</a></td>
					<td>${product.hit}</td>
					<td>${product.imageFileName}</td>
					<td>${product.saveDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>