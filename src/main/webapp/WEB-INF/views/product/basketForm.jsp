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
function productEA(data) {
	var ea = $("#" + data).val()
	if(ea > 10){
		$("#" + data).val(10)
	}else if(ea < 1){
		$("#" + data).val(1)
	}
}

function productRemove(data){
	var div = document.getElementById("remove" + data)
	
	$.ajax({
		url : "basketRemove?productNo=" + data,
		type : "Get",
		contentType : "application/json; charset=utf-8",
		success : function(){
			div.remove()	
		}
	})
}
</script>
</head>
<body>
<c:import url="../default/header.jsp" />
<div class="wrap">
	<div class="basketDiv">
		<table class="table">
			<c:forEach var="dto" items="${productInfo}">
				<tr id="remove${dto.productNo}">
					<td><img src="imageFileDownload?imageFileName=${dto.imageFileName}" width="100px" height="100px"></td>
					<td><a href="productForm?productNo=${dto.productNo}">${dto.productName}</a></td>
					<td>${dto.productPrice}&#8361;</td>
					<td>
						<input type="number" value="1" id="${dto.productNo}" size="1px" min="1" max="10" step="1" onchange="productEA('${dto.productNo}')">
					</td>
					<td>
						<a href="javascript:productRemove('${dto.productNo}')">X</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>