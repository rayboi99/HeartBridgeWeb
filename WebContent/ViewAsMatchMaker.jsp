<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all dates as match maker</title>
</head>
<body>

<h2>All Dates You Have Matched</h2>

<%@page import="java.util.List" %>
<%@page import="com.se452.model.DateInfo" %>
<% List<DateInfo> dates =(List<DateInfo>)request.getAttribute("listOfDates");
   request.setAttribute("dates",dates);%>

<table>
	<tr>
		<th>Couple</th>
		<th>Location</th>
		<th>Time</th>
		<th>Status</th>
		<th>Feedback</th>
	</tr>
	
	
	<c:forEach items="${dates}" var="element">
	<tr>
		<td>${element.user1Id} & ${element.user2Id}</td>
		<td>${element.location}</td>
	</tr>
	</c:forEach>
	
</table>



</body>
</html>