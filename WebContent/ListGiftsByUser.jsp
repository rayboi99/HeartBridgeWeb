<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.se452.model.Gift"%>
<%@page import="com.se452.model.UserGift"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ReviewGift page</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<%@ include file="header.html"%>>
	<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8">
			<%
				List<Gift> giftlistSE = (List<Gift>) request.getAttribute("giftListSent");
			%>
			<%
				List<Gift> giftlistRE = (List<Gift>) request.getAttribute("giftListReceived");
			%>
			<div class="col-xs-10"
				style="color: cornflowerblue; font-weight: bold; margin-left: 20px;">
				<div class="table">
					<h1>Gift Sent</h1>
					<table class="table table-hover" style="font-size: 20px;">
						<thead>
							<tr>
								<th>Gift Id</th>
								<th>Gift Name</th>
								<th>Gift Description</th>
								<th>Gift Picture</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Gift gift : giftlistSE) {
							%>
							<tr>


								<td><%=gift.getGiftId()%></td>
								<td><%=gift.getGiftName()%></td>
								<td><%=gift.getGiftDescription()%></td>
								<td><%=gift.getGiftPicture()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<h1>Gift Received</h1>
					<table class="table table-hover" style="font-size: 20px;">
						<thead>
							<tr>
								<th>Gift Id</th>
								<th>Gift Name</th>
								<th>Gift Description</th>
								<th>Gift Picture</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Gift gift : giftlistRE) {
							%>
							<tr>


								<td><%=gift.getGiftId()%></td>
								<td><%=gift.getGiftName()%></td>
								<td><%=gift.getGiftDescription()%></td>
								<td><%=gift.getGiftPicture()%></td>

							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<form action="ListFriendsServlet" method="post">
					<input type="hidden" name="pageFrom" value="ViewGifts"> <input
						type="submit" value="Create Gifts">
				</form>
			</div>


		</div>
	</div>
	<%@ include file="footer.html"%>
</body>


</html>