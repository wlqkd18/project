<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<style type="text/css">
	.wrap{
		width : 1400px; margin : auto;
	}
	.header{
		width : 400px; margin : auto;
	}
	.header a{text-decoration: none;}
	.header a:hover{text-decoration: none;}
	.title{
		font-size: 70pt;
		text-align: center;
		text-shadow: 10px 10px 15px black;
		margin-top: 0;
		padding-bottom: 20px;
		color : burlywood;
		font-family: Gabriola;	
	}
	
	nav{ background-color: gray; width: 1400px;}
	.navdiv{ width: 100%; background-color: gray; }
	
	nav ul{ list-style: none; display: flex;
				justify-content: center; }
	nav ul li{ padding: 10px; }
	nav ul li a{text-decoration: none; color: white; }
	nav ul li a:hover {
		color: orange; border-bottom:  2px solid black;
		transition: all 1.25s; padding-bottom: 3px; 
	}
	.register_form{
		width : 700px; margin: auto;
	}
	.loginTable{
		width: 183px;
		border: 1px solid black;
	}
	.myPageDiv{
		width: 183px;
		margin-top: 20px;
	}
	.infoTable{
		width: 700px; margin: auto;
	}
	.modifyTable{
		width: 700px; margin: auto;
	}		
	.memberListDiv{
		width: 700px; margin: auto;
	}
	.productBoardDiv{
		width: 700px; margin: auto;
	}
</style>
</head>
<body>
<div class="wrap">
	<div class="header">
		<a href="/ssg/"><h1 class="title">SSG</h1></a>
	</div>
</div>
<div class="navdiv">
	<div class="wrap">
		<nav>
			<ul>
				<li><a href="/ssg/product/outer">Outer</a></li>
				<li><a href="">Top</a></li>
				<li><a href="">Pants</a></li>
				<li><a href="">Shoes</a></li>
				<li><a href="">Accessory</a></li>
			</ul>
		</nav>
	</div>
</div>
</body>
</html>