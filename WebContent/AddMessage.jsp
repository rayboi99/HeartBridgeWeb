<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Message</title>
</head>
<body>

	<%
		String userName = (String)request.getSession(true).getAttribute("name").toString();

		if (userName == null) {
			userName = "N/A";
		}
	%>
	
	<form action="AddMessageServlet" method="post">
		<table>
			<tr>
				<!-- I need to make this a dropdown list -->
				<td>To</td>
				<td><input name="userIdTo" /></td>
			</tr>
			<tr>
				<td>From</td>
				<td><%=userName%></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><input name="subject" /></td>
			</tr>
			<tr>
				<td>Body</td>
				<td><input name="body" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form>
	
</body>
</html>