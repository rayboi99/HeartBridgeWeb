<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.se452.model.*" %>
    <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Friend's Friends List</title>
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
 <c:import url="ViewFriendListController" />
 
<% List<Friendship> fsl=(List<Friendship>)session.getAttribute("FriendshipList");
List<Friendship> mfl=(List<Friendship>)session.getAttribute("MFriendshipList");
List<Friendship> nmfl=(List<Friendship>)session.getAttribute("NMFriendshipList");
%>
<%@ include file="header.html"%>

<div class="row">
		<div class="col-sm-2"><%@ include file="navBar.html"%></div>
		</br>
</br>
</br>
</br>
</br>
<div class="col-sm-10" pull-middle">
   <table width="600" border="0" cellpadding="50" >

<% if(nmfl.size()>0){%>
<%for(int i=0;i<nmfl.size();i++) {%>

<tr align="center" valign="center">
<td>
<table width="100" border="0" cellpadding="0"><td>
<img 
  src="user/image.html?id=<%=nmfl.get(i).getFriend().getUserId()%>"
  class="img-rounded" alt="Cinque Terre" width="50" height="36" />
  </td></br>
  <td><h5><%=nmfl.get(i).getFriend().getUserName() %></h5></td></table>
</td>
<td><form action="CancelFriendshipRequestController" method="post">
<button type="submit" class="btn btn-primary" name="AddButton" value="<%=fsl.get(i).getFriend().getUserId() %>">Add Friend</button>
 </form></td>
 
</tr>


<%} }%>
</table>
</div>



<div class="col-sm-10" pull-middle">
   <table width="800" border="0" cellpadding="50" >

<% if(mfl.size()>0){%>
<%for(int i=0;i<mfl.size();i++) {%>

<tr align="center" valign="center">
<td>
<table width="100" border="0" cellpadding="0"><td>
<img 
  src="user/image.html?id=<%=mfl.get(i).getFriend().getUserId()%>"
  class="img-rounded" alt="Cinque Terre" width="50" height="36" />
  </td></br>
  <td><h5><%=mfl.get(i).getFriend().getUserName() %></h5></td></table>
</td>
<td>
<button type="submit" class="btn btn-warning" name="AddButton" value="<%=fsl.get(i).getFriend().getUserId() %>">Mutual Friend</button>
 </td>
 
</tr>


<%} }%>
</table>
</div></div>
<%@ include file="footer.html"%>
</body>
</html>