<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add MatchRequest As User</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function SetValueandSubmit() {
		document.getElementById("pageFrom").value = "MatchMakerDropDownUpdate";
		document.getElementById("myForm").submit();
	}
</script>
</head>
<body>
	<%
		String userName = (String) request.getSession(true).getAttribute("name").toString();
		String matchMakerIdSelected = request.getParameter("MatchMakerId");

		int matchMakerId = 0;
		
		if (userName == null) {
			userName = "N/A";
		}

		if (matchMakerIdSelected != null) {
			matchMakerId = Integer.parseInt(matchMakerIdSelected);
		}
	%>
	<%@ include file="header.html"%>
	<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8">
		    <div style="color:cornflowerblue;font-weight: bold; margin-left: 20px;font-size: 20px; margin-top: 100px">
		    	<h1> Add Match Request As User </h1>
			<form id="myForm" action="AddMatchRequestAsUserServlet" method="post">
				<table>
					<tr>
					<td>User</td>
						<td><%=userName%></td>
					</tr>
					<tr>
						<td>MatchMaker</td>
						<td><input type="hidden" id="pageFrom" name="pageFrom"
							value=""> <select id="MatchMakerId" name="MatchMakerId"
							onchange="SetValueandSubmit();">
								<c:forEach var="friends" items="${friendshipList}">
									<option value="${friends.friend.getUserId()}"
										${friends.friend.getUserId().toString().equals(MatchMakerId) ? 'selected' : ''}>${friends.friend.getUserName()}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>User2Id</td>
						<td><select id="User2Id" name="User2Id">
								<c:if test="${empty matchMakerfriendshipList}">
									<option>No Friends found for MatchMaker</option>
								</c:if>
								<c:forEach var="mmfriends" items="${matchMakerfriendshipList}">
									<option value="${mmfriends.friend.getUserId()}">${mmfriends.friend.getUserName()}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				<input type="submit" />
			</form>
</div>
 </div>
 </div>
	<%@ include file="footer.html"%>
</body>
</html>