<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add University Again</title>
</head>
<body>
<h>The uniersity name is already added.</h>
<form action="AddUniversityController" method="post">
University Name:<input type="text" name="uni_name" />
<input type="submit" value="Add" />
<form action="functionList.jsp">
<input type="submit" value="Function List" />
</form>
<form action="ViewUniversityListController" method="post">
<input type="submit" value="View Your University List" />
</form>
</body>
</html>