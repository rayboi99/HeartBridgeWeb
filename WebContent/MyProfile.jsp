<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>My Profile</title>
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
	<%
		int userId = (int) session.getAttribute("userIdKey");
		String aboutMe = (String) request.getAttribute("aboutMe");
		String hobby = (String) request.getAttribute("hobby");
		String idealPartner = (String) request.getAttribute("idealPartner");
		String message = (String) request.getAttribute("message");

		if (aboutMe == null)
			aboutMe = "";
		if (hobby == null)
			hobby = "";
		if (idealPartner == null)
			idealPartner = "";
		if (message == null)
			message = "";
	%>

	<%@ include file="header.html"%>

	<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8">
			<h3><b><%=message%></b></h3><br />
			<form action="UpdateProfileServlet" method="post">
				<table>
					<tr>
						<td><br /> <img src="user/image.html?id=<%=userId%>"
							class="img-thumbnail" width="304" height="206" alt="profile pic" /><br /></td>
					</tr>

					<tr>
						<td><br />About Me:</td>
						<td><%=aboutMe%></td>
					</tr>
					<tr>
						<td><br />Hobby:</td>
						<td><%=hobby%></td>
					</tr>
					<tr>
						<td><br />Ideal Partner:</td>
						<td><%=idealPartner%></td>
					</tr>

				</table>
				<br /> <input type="submit" name="update" class="btn btn-info"
					value="update" />
			</form>
		</div>
	</div>
	<%@ include file="footer.html"%>

</body>
</html>