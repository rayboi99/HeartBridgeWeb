<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add MatchRequest As MatchMaker</title>
</head>
<body>

	<form action="AddMatchRequestAsMMServlet" method="get">
		<table>
			<tr>
				<td>Match Maker</td>
				<td><%String userName = (String)session.getAttribute("name"); %></td>
			</tr>
			<!-- TO DO MAKE THIS DROP DOWN BOXES -->
			<tr>
				<td>User1Id</td>
				<td><input name="User1Id" /></td>
			</tr>
			<tr>
				<td>User2Id</td>
				<td><input name="User2Id" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form>

</body>
</html>