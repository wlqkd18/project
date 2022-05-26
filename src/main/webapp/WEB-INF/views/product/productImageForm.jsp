<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../default/header.jsp"/>
<c:import url="../default/menu.jsp"/>
	<div class="wrap">
		<div class="productDiv">
			<div class="imageFileDiv">
				<c:forEach var="product" items="${productInfo}">
					<div class="productImageInfoDiv">
						<a href="/ssg/product/productForm?productNo=${product.productNo}"><img src="/ssg/product/imageFileDownload?imageFileName=${product.imageFileName}" width=250px height=250px></a>
						<div class="imageInfoDiv">
							<b>${product.productName}</b><br>
							<b>${product.productPrice}&#8361;</b>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>