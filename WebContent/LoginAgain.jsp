<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Again.</title>
</head>
<body>
<h>Sorry, the user name or the password is not valid. Please try again.</h>
<form action="LoginController" method="post">
User Name:<input type="text" name="user_name" />
Password:<input type="password" name="password" />
<input type="submit" value="Login" />
</form>
<form action="ForgetPasswordController" method="post">
<input type="submit" value="ForgetPassword" /></form>
<form action="Register.jsp" method="post">
<input type="submit" value="Register" />
</form>
</body>
</html>