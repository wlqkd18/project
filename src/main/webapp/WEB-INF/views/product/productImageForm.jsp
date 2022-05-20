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
		<div class="imageDiv">
			<c:forEach var="name" items="${productInfo}">
				<table>
					<tr>
						<td>
							${name.productName}
						</td>
					</tr>
				</table>
			</c:forEach>
		</div>
	</div>
</body>
</html>