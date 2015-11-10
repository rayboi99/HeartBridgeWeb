<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.se452.model.*" %>
    <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Friend List</title>
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
 
<% List<Friendship> fsl=(List<Friendship>)session.getAttribute("FriendshipList");%>
<%@ include file="header.html"%>

<div class="row">
		<div class="col-sm-2"><%@ include file="navBar.html"%></div>
		</br>
</br>
</br>
</br>
</br>
<div class="col-sm-10" pull-middle">
   <table width="800" border="0" cellpadding="50" >

<% if(fsl.size()>0){%>
<%for(int i=0;i<fsl.size();i++) {%>

<tr align="center" valign="center">
<td>
<table width="100" border="0" cellpadding="0"><td>
<img 
  src="user/image.html?id=<%=fsl.get(i).getFriend().getUserId()%>"
  class="img-rounded" alt="Cinque Terre" width="50" height="36" />
  </td></br>
  <td><h5><%=fsl.get(i).getFriend().getUserName() %></h5></td></table>
</td>
<td><form action="CancelFriendshipRequestController" method="post">
<button type="submit" class="btn btn-primary" name="cancelButton" value="<%=fsl.get(i).getFriend().getUserId() %>">Delete</button>
 </form></td>
 <td><form action="ViewSecondLevelFriendListController" method="post">
<button type="submit" class="btn btn-primary" name="ffflist" value="<%=fsl.get(i).getFriend().getUserId() %>">Your friend's friend list</button>
 </form></td>
 <td><form action="ListMessagesServlet" method="post">
 
 <input type="hidden" name="pageFrom" value="ViewFriendshipList">
 <input type="hidden" name="friendIdSelected" value=<%=fsl.get(i).getFriend().getUserId()%>>
<button type="submit" class="btn btn-primary" name="button" value="3">Messages</button>
 </form></td>
  <td><form action="giftServlet" method="post">
 <input type="hidden" name="pageFrom" value="ViewFriendshipList">
  <input type="hidden" name="friendIdSelected" value=<%=fsl.get(i).getFriend().getUserId()%>>
<button type="submit" class="btn btn-primary" name="button" value="3">Gift</button>
 </form></td>
</tr>


<%} }else{%>
<div class="col-sm-6" pull-middle>
<h4>You have no friends yet.</h4>

<%} %>
</table>
</div></div>
<%@ include file="footer.html"%>
</body>
</html>