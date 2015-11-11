<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.se452.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Match Requests By User</title>
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
	%>

	<%@ include file="header.html"%>

	<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8">

			<%
				List<MatchRequest> matchRequestList = (List<MatchRequest>) request.getAttribute("matchRequestList");
			%>

			<div class="col-xs-10"
				style="color: cornflowerblue; font-weight: bold; margin-left: 20px;">
				<div class="table">
					<h1>Match Requests By User</h1>

					<table class="table table-hover" style="font-size: 20px;">
						<thead>
							<tr>
								<th>Date</th>
								<th>MatchMaker</th>
								<th>User1</th>
								<th>User1Status</th>
								<th></th>
								<th>User2</th>
								<th>User2Status</th>
								<th></th>
								<th>MatchRequestStatus</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (MatchRequest matchRequest : matchRequestList) {
							%>
							<tr>
								<td><%=matchRequest.getRequest_Time()%></td>
								<td><%=matchRequest.getMatchMaker_Id().getUserName()%></td>
								<td><%=matchRequest.getUser1_Id().getUserName()%></td>
								<td><%=matchRequest.getUser1_Request_Status()%></td>

								<td>
									<%
										if (matchRequest.getUser1_Request_Status().equals("PENDING")
													&& matchRequest.getUser1_Id().getUserId() == userId) {
									%>

									<form action=UpdateMatchRequestServlet method="post">

										<input type="hidden" name="MatchMakerId"
											value="<%=matchRequest.getMatchMaker_Id().getUserId()%>">
										<input type="hidden" name="User1Id"
											value="<%=matchRequest.getUser1_Id().getUserId()%>">
										<input type="hidden" name="User2Id"
											value="<%=matchRequest.getUser2_Id().getUserId()%>">
										<input type="hidden" name="user2RequestStatus"
											value="<%=matchRequest.getUser2_Request_Status()%>">

										<button type="submit" class="btn btn-danger"
											name="user1RequestStatus" value="REJECT">Reject</button>
										<button type="submit" class="btn btn-success"
											name="user1RequestStatus" value="ACCEPT">Accept</button>
									</form> <% } %>

								</td>


								<td><%=matchRequest.getUser2_Id().getUserName()%></td>
								<td><%=matchRequest.getUser2_Request_Status()%></td>

								<td>
									<%
										if (matchRequest.getUser2_Request_Status().equals("PENDING")
													&& matchRequest.getUser2_Id().getUserId() == userId) {
									%>

									<form action=UpdateMatchRequestServlet method="post">

										<input type="hidden" name="MatchMakerId"
											value="<%=matchRequest.getMatchMaker_Id().getUserId()%>">
										<input type="hidden" name="User1Id"
											value="<%=matchRequest.getUser1_Id().getUserId()%>">
										<input type="hidden" name="User2Id"
											value="<%=matchRequest.getUser2_Id().getUserId()%>">
										<input type="hidden" name="user1RequestStatus"
											value="<%=matchRequest.getUser1_Request_Status()%>">

										<button type="submit" class="btn btn-danger"
											name="user2RequestStatus" value="REJECT">Reject</button>
										<button type="submit" class="btn btn-success"
											name="user2RequestStatus" value="ACCEPT">Accept</button>
									</form> <% } %>

								</td>
								<td><%=matchRequest.getRequest_Status()%></td>


							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<form action="ListFriendsServlet">
					<input type="hidden" name="pageFrom" value="ViewMatchRequestByUser">
					<input type="submit" value="Create MatchRequest">
				</form>
			</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>