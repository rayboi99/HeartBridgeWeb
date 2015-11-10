<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Account Information</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<%String email=(String)session.getAttribute("email");
String gender =(String)session.getAttribute("gender");
String age =String.valueOf(session.getAttribute("age"));
boolean ifChangePassword = (boolean)session.getAttribute("IfSetPassword");%>
 <c:import url="UpdateAccountController" />
<%@ include file="header.html"%>

	<form role="form" action="UpdateAccountController" method="post">
		<div class="row">
					<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		</br>
</br>
</br>
</br>
</br>
			<div class="col-sm-5" pull-middle>
				
				<div class="form-group">
					<label for="pwd">Old Password:</label> <input type="password"
						class="form-control" name="oldPassword">
				</div>
				<%if(ifChangePassword==false) {%>
				 <div style="color:red">The old password does not match.</div>
				 <%} %>
<div class="form-group">
					<label for="pwd">New Password:</label> <input type="password"
						class="form-control" name="newPassword">
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" name="email" value="<%=email%>">
				</div>

				<div class="form-group">
					<label for="gender">Gender:</label> <select class="form-control"
						name="gender" >
						<option value="gender">Gender</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				<div class="form-group">
					<label for="age">Age:</label> <input type="text"
						class="form-control" name="age" value="<%=age %>" >
				</div>

				<button type="submit">Update Account</button>

			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-4"></div>
		</div>
	</form>

	<%@ include file="footer.html"%>

</body>
</html>