<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.List" %>
    <%@ page import="com.se452.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View and change Friend Request Status</title>
</head>
<body>
<%List<FriendRequest> frl=(List<FriendRequest>)session.getAttribute("FriendRequestList"); %>
<% if(frl!=null){%>
<form action="ChangeFriendRequestController" method="post">
 <%for(FriendRequest fr : frl) { %>
<input type="radio" name="pkHashCode" value=<%=fr.getFriendRequestPK().hashCode()%>>
<tr>Send From:<%=fr.getAu().getApp_user_name()%></tr>
<tr>Send Time:<%=fr.getRequestSendTime()%></tr>
<tr>Primary Key:<%=fr.getFriendRequestPK().hashCode()%></tr><BR>
<input type="radio" name=newStatus value="ACCEPT"/>
<tr>ACCEPT</tr>
<input type="radio" name=newStatus value="REJECT"/>
<tr>REJECT</tr><BR>
 <%} %>
 <%} %>
 <input type="submit" value="Change Friend Request">
 </form>
</body>
</html>