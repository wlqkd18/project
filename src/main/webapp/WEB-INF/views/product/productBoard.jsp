<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function imgURL(data){
	var file = data.files[0]
	if(file != ""){
		var reader = new FileReader()
		reader.readAsDataURL(file)
		reader.onload = function(e) {
			$("#imageView").attr("src", e.target.result)
		}
	}
}
function init(){
	if(${productInfo != null}) {
		$("#checkOption").val("${productInfo.productType}").prop("selected", true);
		$("#imageView").attr("src", "/ssg/product/imageFileDownload?imageFileName=${productInfo.imageFileName}")
	}
	return
}
</script>
</head>
<body onload="init()">
<c:import url="../default/header.jsp"/>
<div class="wrap">
	<div class="productBoardDiv">
		<form action="${productInfo eq null ? 'productSave' : 'modifySuccess'}" method="post" enctype="multipart/form-data">
			<b>상품명</b><br>
			<input type="text" name="productName" value="${productInfo.productName}">
			<hr>
			<b>가격</b><br>
			<input type="text" name="productPrice" value="${productInfo.productPrice}">
			<hr>
			<b>상품 분류</b>
			<select name="productType" id="checkOption">
				<option>Outer</option>
				<option>Top</option>
				<option>Pants</option>
				<option>Shoes</option>
				<option>Accessory</option>
			</select>
			<hr>
			<b>상품 이미지 파일</b><br>
			<input type="file" name="imageFileName" onchange="imgURL(this)">
			<img src="#" id="imageView" width="100px" height="100px">
			<hr>
			<input type="submit" value="${productInfo == null ? '상품등록' : '수정'}">
			<c:if test="${productInfo != null}">
				<input type="hidden" name="originFileName" value="${productInfo.imageFileName}">
				<input type="hidden" name="productNo" value="${productInfo.productNo}">
			</c:if>
			<input type="button" onclick="history.back()" value="취소">
		</form>
	</div>
</div>
</body>
</html>