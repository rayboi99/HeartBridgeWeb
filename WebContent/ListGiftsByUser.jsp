<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.se452.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>ReviewGift page</title>
   <script src="js/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class = "logo" >
		<div class = "container" style = "margin-right: 30px; margin-top: 5px">
			<img src="img/2.jpg" width="400px" height="150px" style="float: right;">
		</div>	
	</div>
	<div class = "container" style = "width: auto;margin-top: 20px;">
		<div class = "col-xs-2" style= "width: auto;">
			<div class = "navbar">
				<ul class="nav nav-pills nav-stacked" style = "width: 150px; height:500px;background: aliceblue;">
   				<li class="active", style="height: 60px;"><a href="#">HOME</a></li>
   				<li style="height: 60px;"><a href="#">ACCOUNT</a></li>
 				<li style="height: 60px;"><a href="#">PROFILE</a></li>
   				<li style="height: 60px;"><a href="#">FRIENDS</a></li>
   				<li style="height: 60px;"><a href="#">MESSAGES</a></li>
   				<li style="height: 60px;"><a href="#">GIFTS</a></li>
   				<li style="height: 60px;"><a href="#">MATCH REQUESTS</a></li>
   				<li style="height: 60px;"><a href="#">DATES</a></li>
				</ul>
			</div>
		</div>
		<div class = "col-xs-10" style="color:cornflowerblue;font-weight: bold; margin-left: 20px;">
			<div class = "table">
			<% List<Gift> giftlistRE =(List<Gift>)request.getAttribute("giftlistRE");%>
			<h1 > Gift Sent</h1>
				<table class = "table table-hover" style="font-size: 20px;">
					<thead>
						<tr>
							<th>Gift Id</th>
							<th>Gift Name</th>
							<th>Gift Description</th>	
							<th>Gift Pic</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="$(giftlistRE)" var="element">
						<tr>
							<td>
							 	<c:out value = "$(element)"/> 
							</td>
						
						</tr>
						</c:forEach>
					
					</tbody>
				</table>
			<h1> Gift Received </h1>
				<table class = "table table-hover" style = "font-size: 20px;">
				 <% List<Gift> giftlistSE = (List<Gift>)request.getAttribute("giftlistSE");%>
					<thead>
						<tr>
							<th>Gift Id</th>
							<th>Gift Name</th>
							<th>Gift Description</th>	
							<th>Gift Pic</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items = "$giftlistSE" var = "element">
						<tr>
							<td>
							<c:out value = "$(element)"/>
							</td>
						</tr>
						</c:forEach>>
					</tbody>
				</table>
			</div>
			<div class = "button" style = "float: right; ">
				<button type="button" class="btn btn-default active" style= "color: white; background-color: cornflowerblue;font-size: 20px; font-weight: bold;"> Create a new gift</button>
			</div>
		</div>
	</div>
</body>
<footer style="margin-top: 200px;color: cornflowerblue;font-size:20px">
	<div class="container" style="width: auto;">
		<div class = row>
		<div class = "col-xs-3">&nbsp;</div>
		<div class = "col-xs-3">@heartbridage L.L.C.</div>
		<div class= "col-xs-3" > customer service : 800-800-8000</div>
		<div class= "col-xs-3" > contact email: heartbridge@gmail.com</div>
		</div>
		
	</div>
</footer>
</html>