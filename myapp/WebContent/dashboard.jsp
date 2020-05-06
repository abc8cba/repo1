<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
	</head>
	<body>
		<h3 style="color: green;font-size: 15px; <c:if test="${empty msg}">display:none</c:if>" align="center">${msg}</h3>
		<form method="post" action="">
			<input type="hidden" name="method" id="method" value=""/>
			<input type="hidden" name="csrfToken" id="csrfToken" value="${csrfTokenReq}"/>
			<a href="LoginController?method=logout&csrfToken=${csrfTokenReq}">Logout</a>
		</form>
	</body>
</html>