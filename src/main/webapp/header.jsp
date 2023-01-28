<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%
	if (session.getAttribute("userName") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<nav class="navbar">
		<ul class="navba-nav">
			<li><a href="home.jsp">Home</a></li>
			<li><a href="addProduct.jsp">Add Product</a></li>
			<li><a href="viewProducts.jsp">View Products</a></li>
			<li><a href="searchProduct.jsp">Search Product</a></li>
			<li><a style="float: right;margin-right: 10px" href="logout.jsp">Logout</a></li>
		</ul>
	</nav>
</body>
</html>