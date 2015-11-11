<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.se452.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Messages</title>
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

	<%@ include file="header.html"%>

	<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8"
			style="color: cornflowerblue; font-weight: bold; font-size: 20px;">

			<%
				List<Message> msgListSent = (List<Message>) request.getAttribute("messageListSent");
				List<Message> msgListReceived = (List<Message>) request.getAttribute("messageListReceived");
			%>
			
			
			<div class="col-xs-10"
				style="color: cornflowerblue; font-weight: bold; margin-left: 20px;">
				<div class="table">
					<h1>Messages Sent</h1>
					<table class="table table-hover" style="font-size: 20px;">
						<thead>
							<tr>
								<th>Date</th>
								<th>To</th>
								<th>From</th>
								<th>Subject</th>
								<th>Body</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Message msg : msgListSent) {
							%>
							<tr>
								<td><%=msg.getDate_Sent()%></td>
								<td><%=msg.getUser_Id_To().getUserName()%></td>
								<td><%=msg.getUser_Id_From().getUserName()%></td>
								<td><%=msg.getSubject()%></td>
								<td><%=msg.getMessage()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<h1>Messages Received</h1>
					<table class="table table-hover" style="font-size: 20px;">
						<thead>
							<tr>
								<th>Date</th>
								<th>To</th>
								<th>From</th>
								<th>Subject</th>
								<th>Body</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Message msg : msgListReceived) {
							%>
							<tr>
								<td><%=msg.getDate_Sent()%></td>
								<td><%=msg.getUser_Id_To().getUserName()%></td>
								<td><%=msg.getUser_Id_From().getUserName()%></td>
								<td><%=msg.getSubject()%></td>
								<td><%=msg.getMessage()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			<form action="ListFriendsServlet" method="post">
				<input type="hidden" name="pageFrom" value="ViewMessages"> <input
					type="submit" value="Create Message">
			</form>
		</div>
	</div>
	</div>
	<%@ include file="footer.html"%>

</body>
</html>