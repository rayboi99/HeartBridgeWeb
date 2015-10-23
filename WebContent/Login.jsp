<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<style>
	h5 {
    color: blue;
	}
</style>
</head>
<body>
	<%
		String message = (String) request.getAttribute("message");

		if (message == null) {
			message = "";
		}
	%>

	<h4>Login</h4>
	<h5><%=message%></h5>
	<form action="LoginController" method="post">
	<table>
		<tr>
			<td>User Name:</td>
			<td><input type="text" name="user_name" /></td>
		</tr>
		
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		
	</table>
		 <input type="submit" value="Login" />
	</form>
	<br/>
	<form action="ForgetPasswordController" method="post">
		<input type="submit" value="Forget Password" />
	</form>
	<form action="Register.jsp" method="post">
		<input type="submit" value="Register" />
	</form>
</body>
</html>