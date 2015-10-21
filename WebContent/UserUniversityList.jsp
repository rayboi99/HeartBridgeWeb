<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="java.util.List" %>
    <%@ page import="com.se452.model.University" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User University List</title>
</head>
<body>
<%List<University> UniversityList=(List<University>)session.getAttribute("UUlist"); %>
<form action="DeleteUniversityController" method="post">
 <%for(University ul : UniversityList) { %>
<input type="checkbox" name=chosenUniversity value=<%=ul.getUniversityId()%>><tr>University ID: <%=ul.getUniversityId()%><tr>      University Name: <%=ul.getUniversityName()%></tr></tr><BR>
 <%} %>
 <input type="submit" value="Delete University">
 </form>
 <form action="functionList.jsp">
<input type="submit" value="Function List" />
</form>
</body>

</html>