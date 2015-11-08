<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add MatchRequest As MatchMaker</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>


	<%
		String userName = (String)request.getSession(true).getAttribute("name").toString();

		if (userName == null) {
			userName = "N/A";
		}
	%>
		<%@ include file="header.html"%>
	
		<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8">
	<form action="AddMatchRequestAsMMServlet" method="get">
		<table>
			<tr>
				<td>Match Maker</td>
				<td><%=userName%></td>
			</tr>
			<!-- TO DO MAKE THIS DROP DOWN BOXES -->
			<tr>
				<td>User1Id</td>
				<td>
 			<select id="User1Id" name="User1Id">
            <c:forEach var="friends" items="${friendshipList}">
                <option value="${friends.friend.getUserId()}">${friends.friend.getUserName()}</option>
            </c:forEach>
        </select>
        
        </td>
			</tr>
			<tr>
				<td>User2Id</td>
				<td>
 			<select id="User2Id" name="User2Id">
            <c:forEach var="friends" items="${friendshipList}">
                <option value="${friends.friend.getUserId()}">${friends.friend.getUserName()}</option>
            </c:forEach>
        </select>
        
        </td>
			</tr>
		</table>
		
		<input type="submit" />
	</form>
</div>
 </div>
 	<%@ include file="footer.html"%>
</body>
</html>