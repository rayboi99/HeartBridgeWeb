<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Dates as MM</title>
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
		<div class="container">
			<form action="CreateDateServlet" method="get">

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

				<div class="container">
					<br /> <input type="submit" class="btn btn-info"
						name="createDates" value="create dates">
				</div>
			</form>
		</div>
	</div>


	<%@include file="footer.html"%>
</body>
</html>