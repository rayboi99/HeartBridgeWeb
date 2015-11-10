<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Create Date</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap-datepicker.js"></script>

</head>
<body>

	<%@include file="header.html"%>

	<div class="col-sm-4">
		<%@include file="navBar.html"%>
	</div>

	<form role="form" action="createDateServlet" method="post">
		<div class="row">
			<div class="col-sm-4">
				<legend>View As Matchmaker -> Create Date </legend>
				<div class="form-group">
					<label for="user1">User 1:</label> <select id="friendId"
						name="friendId">
						<c:forEach var="friends" items="${friendshipList}">
							<option value="${friends.friend.getUserId()}">${friends.friend.getUserName()}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="user2">User 2:</label> <select id="friendId"
						name="friendId">
						<c:forEach var="friends" items="${friendshipList}">
							<option value="${friends.friend.getUserId()}">${friends.friend.getUserName()}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="location">Location:</label> <input type="text"
						class="form-control" name="location">
				</div>

				<div class="form-group">
					<label for="date">Date & Time:</label>
					<div class='input-group date' id='datetimepicker1'>
						<input type='text' class="form-control" /> <span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>

				<div class="form-group">
					<label for="description">Description:</label> <input type="text"
						class="form-control" name="description">
				</div>

				<button type="submit">Set them up!</button>
			</div>

			<script type="text/javascript">
				$(function() {
					$('#datetimepicker1').datetimepicker();
				});
			</script>
			<div class="col-sm-4"></div>
		</div>
	</form>
	<%@include file="footer.html"%>

</body>
</html>