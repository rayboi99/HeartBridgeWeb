<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="java.util.List" %>
    <%@ page import="com.se452.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Friend Request</title>
</head>
<body>
<%List<AppUser> aul=(List<AppUser>)session.getAttribute("AllUserList"); %>
<form action="MakeFriendRequestController" method="post">
 <%for(AppUser au : aul) { %>
<input type="checkbox" name=chosenUser value=<%=au.getUserId()%>><tr>User Name:<%=au.getUserName()%></tr><BR>
 <%} %>
 <input type="submit" value="Make Friend Request">
 </form>

</body>
</html>