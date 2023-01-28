<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="DataAccessObject.ProductManagementDAO"%>
<%@page import="PlainOldJavaObject.Product"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<%
	String productId = request.getParameter("prodId");
	Product product = ProductManagementDAO.getProductById(productId);
	%>
	<div align="center">
		<form action="processEditProduct.jsp" method="post">
			<table class="productTable">
				<thead>
					<tr>
						<th colspan="2">Product Details</th>
					</tr>
				</thead>
				<tr>
					<td>Product ID</td>
					<td><input type="text" name="prodId" size="20"
						value="<%=productId%>" class="productTextField" readonly /></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td><input type="text" name="prodName" size="20"
						value="<%=product.getProductName()%>" class="productTextField" /></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><input type="text" name="prodCategory" size="20"
						value="<%=product.getProductCategory()%>" class="productTextField" /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="prodPrice" size="20"
						value="<%=product.getProductPrice()%>" class="productTextField" /></td>
				</tr>
			</table>
			<button class="actionBtn" style="margin-top: 10px">Save</button>
			<a
				style="display: inline-block; width: 62px; height: 16px; font-size: 13px; text-decoration: none; background-color: gray; padding: 10px; color: white; border: none; width: 75px; border-radius: 5px; cursor: pointer;"
				href="viewProducts.jsp">Back</a>
		</form>
	</div>
</body>
</html>