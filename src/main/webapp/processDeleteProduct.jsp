<%@page import="DataAccessObject.ProductManagementDAO"%>
<%@page import="PlainOldJavaObject.Product"%>

<%
String productId = request.getParameter("prodId");

int status = ProductManagementDAO.deleteProduct(productId);
if (status == 1) {
	response.sendRedirect("viewProducts.jsp");
} else {
	response.sendRedirect("error.jsp");
}
%>