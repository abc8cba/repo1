<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Page</title>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/LoginController" id="forgot_password_form">
	<input type="hidden" name="method" id="method" value="change_password"/>
	<input type="hidden" name="csrfToken" id="csrfToken" value="${csrfTokenReq}"/>
    <table border="1" cellspacing="4" cellpadding="6" bgcolor="pink" width="40%" align="center">
    	<tr bgcolor="lime">
             <td colspan="2" align="center">
                 <h2>Login Page</h2>
             </td>
        </tr>
        <tr>
            <td>New Password* </td>
            <td><input type="password" name="new_pass" id="new_pass"/></td>
        </tr>
         <tr>
            <td>Confirm New Password*</td>
            <td><input type="password" name="conf_new_pass" id="conf_new_pass" /></td>
        </tr>
         <tr>
             <td colspan="2" align="center">
                 <input type="submit" value="Change Password" />                 
             </td>
        </tr>
    </table>   
</form>
<script type="text/javascript" src="js/validation.js"></script>
</body>
</html>