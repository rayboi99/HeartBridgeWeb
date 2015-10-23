<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ page import="java.util.List" %>
    <%@ page import="com.se452.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Completed Received Friend Request List</title>
</head>
<body>
<%List<FriendRequest> frl=(List<FriendRequest>)session.getAttribute("FriendRequestList"); %>
<% if(frl!=null){%>
<form >
 <%for(FriendRequest fr : frl) { %>
<tr>Send From:<%=fr.getAu().getUserName()%></tr>
<tr>Send Time:<%=fr.getRequestSendTime()%></tr>
<tr>Status:<%=fr.getRequestStatus()%></tr><BR>
 <%} %>
 <%} %>
 
 </form>
 <form action="FunctionList.jsp" >
<input type="submit" value="Go Back to Functional list" />
</form>
</body>
</html>