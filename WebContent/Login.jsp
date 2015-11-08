<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
p {
	color: blue;
}

p.error {
	color: red;
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

	<%@ include file="header.html"%>

	<p><%=message%></p>
	<form role="form" action="LoginController" method="post">
		<div class="row" style = "margin-top:100px">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<div class="form-group">
					<label for="email">User Name:</label> <input type="text"
						class="form-control" name="user_name">
				</div>

				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" name="password"> <a
						href="Register.jsp"> don't have an account?</a>
				</div>

				<div class="checkbox">
					<label><input type="checkbox"> Remember me!</label>
				</div>

				<button type="submit">Log in</button>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</form>

	<%@ include file="footer.html"%>



</body>
</html>