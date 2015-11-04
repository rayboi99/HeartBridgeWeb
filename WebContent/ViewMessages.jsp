<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.List" %>
    <%@ page import="com.se452.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Messages</title>
</head>
<body>

<%List<Message> msgListSent = (List<Message>)session.getAttribute("messageListSent"); %>
<%List<Message> msgListReceived = (List<Message>)session.getAttribute("messageListReceived"); %>

<h1>Messages Sent</h1>
<%for(Message msg : msgListSent) { %>
<br><br>
Date:  <% msg.getDate_Sent(); %><br>
To:  <% msg.getUser_Id_To().getUserName(); %><br>
From:  <% msg.getUser_Id_From().getUserName(); %><br>
Subject:  <% msg.getSubject(); %><br>
Body:  <% msg.getMessage(); %><br>
<br><br>
<%} %>
 
<h1>Messages Received</h1>
<%for(Message msg : msgListReceived) { %>
<br><br>
Date:  <% msg.getDate_Sent(); %><br>
To:  <% msg.getUser_Id_To().getUserName(); %><br>
From:  <% msg.getUser_Id_From().getUserName(); %><br>
Subject:  <% msg.getSubject(); %><br>
Body:  <% msg.getMessage(); %><br>
<br><br>
<%} %>
 
 <form action="AddMessage.jsp">
 <input type="submit" value="Create Message">
 </form>
</body>
</html>