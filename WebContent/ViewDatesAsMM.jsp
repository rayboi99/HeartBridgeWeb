<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Dates as MM</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">

<style>
#footer {
	position: absolute;
	bottom: 0;
	height: 60px;
	width: 100%;
}
</style>


</head>
<body>
	<%@page import="java.util.List"%>
	<%@page import="com.se452.model.DateInfo"%>

	<%
		List<DateInfo> listOfDates = (List<DateInfo>) request.getAttribute("listOfDates");
	%>


	<%@include file="header.html"%>
	<div class="col-sm-4">
		<%@include file="navBar.html"%>
	</div>
	<div class="col-sm-8">



		<table class="table table-hover">
			<thead>
				<tr>
					<th>Couple</th>
					<th>Location</th>
					<th>Time</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${listOfDates}" var="element">
					<tr>
						<td>${elemet.User1Id.userName}&${elemet.User2Id.userName}</td>
						<td>${elemet.location}</td>
						<td>${elemet.description}</td>
						<td>${elemet.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<form action=CreateDateServlet method="post">
		<button type="submit" class="btn btn-success" name="createDate">Create Date</button>
	</form>

	<div id="footer">
		<%@include file="footer.html"%>
	</div>


</body>
</html>