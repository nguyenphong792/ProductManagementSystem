<%@page import="DataAccessObject.LoginDAO"%>
<%@page import="PlainOldJavaObject.LoginInfo"%>

<%
//get values user will enter the form
String userName = request.getParameter("userName");
String password = request.getParameter("password");

// check valid
if (LoginDAO.isUserValid(new LoginInfo(userName, password))) {
	session.setAttribute("userName", userName);
	session.setMaxInactiveInterval(200); //200s
	response.sendRedirect("home.jsp"); // send user back home
} else {
	response.sendRedirect("loginFailed.jsp");
}
%>