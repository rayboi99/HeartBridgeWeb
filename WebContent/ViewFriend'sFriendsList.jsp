<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ page import="java.util.List" %>
    <%@ page import="com.se452.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Friend's Friends List</title>
</head>
<body>
<%List<Friendship> fsl=(List<Friendship>)session.getAttribute("FriendList"); %>
<% if(fsl!=null){%>
<form action="MakeFriendRequestController" method="post">
 <%for(Friendship fs : fsl) { %>
<input type="radio" name="chosenUser" value=<%=fs.getFriend().getUserId()%>>
<tr>Friend Name:<%=fs.getFriend().getUserName()%></tr>
 <%} %>
 <%} %>
 <input type="submit" value="Send Friend Request">
 </form>
 <form action="FunctionList.jsp" >
 <input type="submit" value="Go back to function list">
 </form> 
</body>
</html>