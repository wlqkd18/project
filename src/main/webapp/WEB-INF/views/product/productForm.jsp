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
function basket(){
	$.ajax({
		url : "basket?productNo=${productInfo.productNo}&size=" + $("#size").val(),
		type : "Get",
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success: function(data){
			if(data == "success"){
				alert("추가되었습니다.")
			}else{
				alert("이미 물건이 추가되었는지 확인해주세요.")
			}
		} 
	})
}
</script>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div class="wrap">
	<div class="productImageDiv">
		<img src="/ssg/product/imageFileDownload?imageFileName=${productInfo.imageFileName}" width="300px" height="300px">
	</div>
	<div class="productInfoDiv">
		<b>${productInfo.productName}</b><br>
		<b>${productInfo.productPrice}&#8361;</b>
	</div>
	<div class="buttonDiv">
		<input type="button" value="구매하기">
		<input type="button" onclick="basket()" value="장바구니"><br>
		<c:choose>
			<c:when test="${productInfo.productType == 'Shoes'}">
				<select id="size">				
					<option>260</option>
					<option>265</option>
					<option>270</option>
					<option>275</option>
					<option>280</option>
				</select>
			</c:when>
			<c:when test="${productInfo.productType == 'Accessory'}">
				<select id="size">				
					<option>FREE</option>
				</select>
			</c:when>
			<c:when test="${productInfo.productType != 'Shoes' || productInfo.productType != 'Accessory'}">
				<select id="size">
					<option>M</option>
					<option>L</option>
					<option>XL</option>
					<option>XXL</option>
				</select>
			</c:when>
		</c:choose>
	</div>
	<div class="sizeDiv">
		<c:choose>
			<c:when test="${productInfo.productType == 'Outer' || productInfo.productType == 'Top'}">
				<table border="1">
					<tr>
						<th>cm</th>
						<th>총장</th>
						<th>어깨너비</th>
						<th>가슴단면</th>
						<th>소매길이</th>
					</tr>
					<tr>
						<th>M</th>
						<td>70.5</td>
						<td>43.9</td>
						<td>50.5</td>
						<td>60.5</td>
					</tr>
					<tr>
						<th>L</th>
						<td>72.5</td>
						<td>45.5</td>
						<td>53</td>
						<td>62</td>
					</tr>
					<tr>
						<th>XL</th>
						<td>74.5</td>
						<td>47.1</td>
						<td>55.5</td>
						<td>63.5</td>
					</tr>
					<tr>
						<th>XXL</th>
						<td>76.5</td>
						<td>48.7</td>
						<td>58</td>
						<td>65</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${productInfo.productType == 'Pants'}">
				<table border="1">
					<tr>
						<th>cm</th>
						<th>총장</th>
						<th>허리단면</th>
						<th>허벅지단면</th>
						<th>밑위</th>
						<th>밑단단면</th>
					</tr>
					<tr>
						<th>M</th>
						<td>98</td>
						<td>31</td>
						<td>31</td>
						<td>32</td>
						<td>21</td>
					</tr>
					<tr>
						<th>L</th>
						<td>100</td>
						<td>32</td>
						<td>32</td>
						<td>33</td>
						<td>22.5</td>
					</tr>
					<tr>
						<th>XL</th>
						<td>103</td>
						<td>34.5</td>
						<td>32.5</td>
						<td>33</td>
						<td>23</td>
					</tr>
					<tr>
						<th>XXL</th>
						<td>107</td>
						<td>35.5</td>
						<td>33.5</td>
						<td>34</td>
						<td>24.5</td>
					</tr>
				</table>
			</c:when>
		</c:choose>
	</div>
</div>
</body>
</html>