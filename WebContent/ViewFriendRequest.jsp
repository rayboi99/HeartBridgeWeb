<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.se452.model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Friendship Request List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
</head>
<body>

	<%
		List<FriendRequest> pendingReceived = (List<FriendRequest>) session.getAttribute("pendingReceived");
		List<FriendRequest> acceptReceived = (List<FriendRequest>) session.getAttribute("acceptReceived");
		List<FriendRequest> rejectReceived = (List<FriendRequest>) session.getAttribute("rejectReceived");
		List<FriendRequest> acceptSent = (List<FriendRequest>) session.getAttribute("acceptSent");
		List<FriendRequest> rejectSent = (List<FriendRequest>) session.getAttribute("rejectSent");
		List<FriendRequest> pendingSent = (List<FriendRequest>) session.getAttribute("pendingSent");
		List<FriendRequest> frReceivedList = (List<FriendRequest>) session.getAttribute("frReceivedList");
		List<FriendRequest> frSentList = (List<FriendRequest>) session.getAttribute("frSentList");
	%>
	<%@ include file="header.html"%>

	<div class="row">
		<div class="col-sm-2"><%@ include file="navBar.html"%></div>
		</br> </br> </br>


		<div class="col-sm-10"pull-middle">

			<h5>Friend Request Received</h5>
			<table width="800" border="0" cellpadding="50"
				border-collapse="collapse">
				<tr>

				</tr>
				<%
					for (int i = 0; i < frSentList.size(); i++) {
				%>

				<%
					if (frSentList.size() > 0) {
				%>

				<tr align="center" valign="center">
					<td>
						<table width="100" border="0" cellpadding="0">
							<td><img
								src="user/image.html?id=<%=frSentList.get(i).getAu().getUserId()%>"
								class="img-rounded" alt="Cinque Terre" width="50" height="36" />
							</td>
							</br>
							<td><h5><%=frSentList.get(i).getAu().getUserName()%></h5></td>
						</table>
					</td>
					<td><h5><%=frSentList.get(i).getRequestStatus()%></h5></td>
					<%
						if (frSentList.get(i).getRequestStatus().equals("PENDING")) {
					%>
					<td><form action=ChangeFriendRequestController method="post">
							<button type="submit" class="btn btn-danger" name="accept"
								value="<%=frReceivedList.get(i).getFriend().getUserId()%>">Reject</button>
						</form></td>
					<td><form action="ChangeFriendRequestController" method="post">
							<button type="submit" class="btn btn-success" name="reject"
								value="<%=frReceivedList.get(i).getFriend().getUserId()%>">Accept</button>
						</form></td>
					<%
						}
					%>
				</tr>
				<%
					}
					}
				%>
			</table>
		</div>



		<div class="col-sm-10"pull-middle">

			<h5>Friend Request Sent</h5>
			<table width="800" border="0" cellpadding="50"
				border-collapse="collapse">
				<tr>

				</tr>
				<%
					for (int i = 0; i < frReceivedList.size(); i++) {
				%>

				<%
					if (frReceivedList.size() > 0) {
				%>

				<tr align="center" valign="center">
					<td>
						<table width="100" border="0" cellpadding="0">
							<td><img
								src="user/image.html?id=<%=frReceivedList.get(i).getAu().getUserId()%>"
								class="img-rounded" alt="Cinque Terre" width="50" height="36" />
							</td>
							</br>
							<td><h5><%=frReceivedList.get(i).getAu().getUserName()%></h5></td>
						</table>
					</td>
					<td><h5><%=frReceivedList.get(i).getRequestStatus()%></h5></td>
					<%
						if (frReceivedList.get(i).getRequestStatus().equals("PENDING")) {
					%>
					<td><form action="CancelFriendshipRequestController"
							method="post">
							<button type="submit" class="btn btn-danger" name="changeStatus"
								value="<%=frReceivedList.get(i).getAu().getUserId()%>">Cancel</button>
						</form></td>

					<%
						}
					%>
				</tr>
				<%
					}
					}
				%>
			</table>
		</div>





	</div>
	<%@ include file="footer.html"%>
</body>
</html>