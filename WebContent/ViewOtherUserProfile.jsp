<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>My Profile</title>
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
		int userId =  (int)session.getAttribute("userChooseId");
		session.setAttribute("selectedId",userId);%>
	
		

<%@ include file="header.html"%>

	<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8">

	<table>
					<tr>
						<td><br /> <img src="user/image.html?id=<%=userId%>"
							class="img-thumbnail" width="304" height="206" alt="profile pic" /><br /></td>
					</tr>

					<tr>
						<td><br />About Me:</td>
						<td>${aboutMe}</td>
					</tr>
					<tr>
						<td><br />Hobby:</td>
						<td>${hobby}</td>
					</tr>
					<tr>
						<td><br />Ideal Partner:</td>
						<td>${idealPartner}</td>
					</tr>

				</table>
					</div>
					
					<form action="MakeFriendRequestController" method="post">
<button type="submit" class="btn btn-primary" name="button" value="0">Add As Friend</button>
 </form>
 <div style="color:red">${FriendRequest}</div>
	<%@ include file="footer.html"%>
				
</body>
</html>