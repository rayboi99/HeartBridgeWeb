<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>ReviewGift page</title>
   <script src="js/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/bootstrap-datetimepicker.fr.js"></script>
   <script src = "js/bootstrap-datetimepicker.js" ></script>
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
</head>
<body>
    <%
		String userName = (String)request.getSession(true).getAttribute("name").toString();

		if (userName == null) {
			userName = "N/A";
		}
	%>
	<form action = "AddGiftServlet" method = "post">
	<%@ include file = "header.html" %>
    <%@ include file = "navBar.html" %>
		<div class = "col-xs-8" style="color:cornflowerblue;font-weight: bold; margin-left: 20px;">
			<div class = "table">
			<h1 > Gift</h1>
				<table class = "table table-hover" style="font-size: 20px;">
					<thead>
						<tr>
							<th>Gift Id</th>
							<th>Gift Name</th>
							<th>Gift Description</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
					       <th> </th>
						</tr>
						<tr>
							
					</tbody>
				</table>
			
			</div>
		    <div class = "col-xs-10" style="color:cornflowerblue;font-weight: bold; margin-left: 20px;font-size: 20px;">
				  <p>Gift Id</p>
				  <input type = "text" name = "gifTId"><br><br>
				  <p>From:</p>
				  <input type = "text" name = "from"><br><br>
				  <p> To: </p>
				  <p><%=userName%></p>
				  
				  <input type = "text" name = "to"><br><br>
	  
				  <button type="button" class="btn btn-default active" style= "color: white; background-color: cornflowerblue;font-size: 20px; font-weight: bold;">Send</button>
			</div>
		 </div>
	</form>>
</body>

</html>