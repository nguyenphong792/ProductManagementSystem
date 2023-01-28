<%@page import="DataAccessObject.ProductManagementDAO"%>
<%@page import="PlainOldJavaObject.Product"%>

<%
//get all values user the enter form
String productId = request.getParameter("prodId");
String productName = request.getParameter("prodName");
String productCategory = request.getParameter("prodCategory");
Integer productPrice = Integer.parseInt(request.getParameter("prodPrice"));

//create object product
Product product = new Product(productId, productName, productCategory, productPrice);

// call method addProduct()
int status = ProductManagementDAO.addProduct(product);
if (status == 1) {
	response.sendRedirect("viewProducts.jsp");
} else {
	response.sendRedirect("error.jsp");
}
%>