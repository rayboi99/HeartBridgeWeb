<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.List" %>
    <%@ page import="com.se452.model.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Match Requests By MatchMaker</title>
</head>
<body>

<%List<MatchRequest> matchRequestList = (List<MatchRequest>)request.getAttribute("matchRequestList"); %>

<h1>Match Requests By MatchMaker</h1>
<%for(MatchRequest matchRequest : matchRequestList) { %>
<br><br>
Date: <%=matchRequest.getRequest_Time()%><br>
MatchMaker: <%=matchRequest.getMatchMaker_Id().getUserName()%><br>
User1: <%=matchRequest.getUser1_Id().getUserName()%><br>
User1Status: <%=matchRequest.getUser1_Request_Status()%><br>
User2: <%=matchRequest.getUser2_Id().getUserName()%><br>
User2Status: <%=matchRequest.getUser2_Request_Status()%><br>
MatchRequestStatus: <%=matchRequest.getRequest_Status()%><br>
<br><br>
<%} %>
 
 
 <form action="AddMatchRequestAsMM.jsp">
 <input type="submit" value="Create MatchRequest">
 </form>
 
</body>
</html>