<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.List" %>
    <%@ page import="com.se452.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Friendship List</title>
</head>
<body>
<%List<Friendship> fsl=(List<Friendship>)session.getAttribute("FriendshipList"); %>
<% if(fsl!=null){%>
<form action="HandleFrienshipController" method="post">
 <%for(Friendship fs : fsl) { %>
<input type="radio" name="frId" value=<%=fs.getFriend().getApp_user_id()%>>
<tr>Friend Name:<%=fs.getFriend().getApp_user_name()%></tr>
<tr>Friend Add Time:<%=fs.getFriendshipAddTime()%></tr><BR>
<input type="Radio" name="action" value="Delete"/>
<tr>Delete</tr><BR>
<input type="Radio" name="action" value="GetList"/>
<tr>Get friend's friend list</tr><BR>
 <%} %>
 <%} %>
 <input type="submit" value="Process Request">
 </form>
 <form action="FunctionList.jsp" >
 <input type="submit" value="Go back to function list">
 </form> 
</body>
</html>