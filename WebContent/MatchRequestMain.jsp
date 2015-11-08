<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Match Request Main</title>

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
		
	<form action="ViewMatchRequestByMMServlet" method="get">
		<input type="submit" value="View MatchRequests as MatchMaker"/>
	</form>
	<br><br>
	<form action="ViewMatchRequestByUserServlet" method="get">
		<input type="submit" value="View MatchRequests as User"/>
	</form>
	
	  </div>
 </div>
 	<%@ include file="footer.html"%>
</body>
</html>