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
					<th>��ȣ</th>		<th>����</th>		<th>��ȸ��</th>	<th>�̹��� ���� �̸�</th>		<th>�ۼ���¥</th>
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