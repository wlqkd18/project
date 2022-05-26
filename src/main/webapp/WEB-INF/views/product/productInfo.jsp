<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div class="wrap">
	<div class="productInfoDiv">
		<table class="table">
			<tr><th>��ȣ</th><td>${productInfo.productNo}</td></tr>
			<tr><th>��ǰ��</th><td>${productInfo.productName}</td></tr>
			<tr><th>����</th><td>${productInfo.productPrice}</td></tr>
			<tr><th>��� ��¥</th><td>${productInfo.saveDate}</td></tr>
			<tr><th>�з�</th><td>${productInfo.productType}</td></tr>
			<tr><th>�̹��� ����</th><td>${productInfo.imageFileName}</td><td><img src="/ssg/product/imageFileDownload?imageFileName=${productInfo.imageFileName}" width="100px" height="100px"></td></tr>
			<tr>
				<td>
					<input type="button" onclick="location.href='productModify?productNo=${productInfo.productNo}'" value="����">
					<input type="button" onclick="location.href='productDelete?productNo=${productInfo.productNo}&imageFileName=${productInfo.imageFileName}'" value="����">
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>