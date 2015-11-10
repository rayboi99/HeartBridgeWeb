<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.se452.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Match Requests By MatchMaker</title>
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
		<div class="col-sm-8">

			<%
				List<MatchRequest> matchRequestList = (List<MatchRequest>) request.getAttribute("matchRequestList");
			%>

			<h1>Match Requests By MatchMaker</h1>
			<%
				for (MatchRequest matchRequest : matchRequestList) {
			%>
			<br> <br> Date:
			<%=matchRequest.getRequest_Time()%><br> MatchMaker:
			<%=matchRequest.getMatchMaker_Id().getUserName()%><br> User1:
			<%=matchRequest.getUser1_Id().getUserName()%><br> User1Status:
			<%=matchRequest.getUser1_Request_Status()%><br> User2:
			<%=matchRequest.getUser2_Id().getUserName()%><br> User2Status:
			<%=matchRequest.getUser2_Request_Status()%><br>
			MatchRequestStatus:
			<%=matchRequest.getRequest_Status()%><br> <br>
			<%
				if (matchRequest.getRequest_Status().equals("ACCEPT")) {
			%>

			<!-- Send to Naga's Create Date Servlet or Controller -->
			<form action=CreateDateController method="post">
				<button type="submit" class="btn btn-success" name="createDate"
					value="<%=matchRequest.getUser1_Id()%>">Create Date</button>
			</form>


			<%
				}
			%>

			<br> <br>
			<%
				}
			%>

			<form action="ListFriendsServlet">
				<input type="hidden" name="pageFrom" value="ViewMatchRequestByMM">
				<input type="submit" value="Create MatchRequest">
			</form>

		</div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>