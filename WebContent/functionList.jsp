<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User function List</title>
</head>
<body>
<form action="ViewUniversityListController" method="post">
<input type="submit" value="View Your University List" />
</form>
<form action="AddUniversity.jsp">
<input type="submit" value="Add Your University" />

</form>
<form action="ViewUniversityListController" method="post">
<input type="submit" value="Delete Your University" />
</form>
</form>
<form action="ViewAllUserController" method="post">
<input type="submit" value="View Other User" />
</form>
<form action="ViewPendingFriendRequestController" method="post">
<input type="submit" value="View Pending Friend Request Received" />
</form>
<form action="ViewCompleteFriendRequestController" method="post">
<input type="submit" value="View Complete Friend Request Received" />
</form>
<form action="ViewFriendRequestSentController" method="post">
<input type="submit" value="View Friend Request Sent not done" />
</form>
<form action="ViewFriendRequestSentPendingController" method="post">
<input type="submit" value="View Friend Request send pending not done" />
</form>
<form action="ViewFriendListController" method="post">
<input type="submit" value="View Friend List" />
</form>
<form action="ViewFriendRequestSentPendingController" method="post">
<input type="submit" value="Cancel Pending Friend Request Reveived Not Done" />
</form>
<form action="AddMessage.jsp" method="post">
<input type="submit" value="Add a New Message" />
</form>
<form action="ListMessagesServlet" method="post">
<input type="submit" value="View Messages" />
</form>
</body>
</html>