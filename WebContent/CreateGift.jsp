<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<%@ include file ="header.html" %>>
		<div class="row">
		<div class="col-sm-4"><%@ include file="navBar.html"%></div>
		<div class="col-sm-8">
		<div  style="color:cornflowerblue;font-weight: bold; margin-left: 20px;">
			<div class = "table">
			<h1 > Gift</h1>
				<table class = "table table-hover" style="font-size: 20px;">
					<thead>
						<tr>
							<th>Gift Id</th>
							<th>Gift Name</th>
							<th>Gift Description</th>	
							<th>Gift Picture</th>
						</tr>
					</thead>
					<tbody>
						<tr>
					       <td>1</td>
					       <td>bear</td>
					       <td>you are so cute </td>
					       <td>
					       <img src ="img/teddybear.jpg" width= "100px">
					       </td>
						</tr>
						<tr>
							<td>2</td>
							<td>flower</td>
							<td>you are pretty</td>
							<td>
					       <img src ="img/flower.jpg" width= "100px">
					       </td>
						</tr>
						
					</tbody>
				</table>
			
			</div>
			</div>
		    <div style="color:cornflowerblue;font-weight: bold; margin-left: 20px;font-size: 20px; margin-top: 100px">
		    	<h1> Pick A Gift </h1>
		    	<table class= "table table-hover">
		    	  
		    	  <tr>
				  <td>Gift Id</td>
				  <td>
				  <select id= "giftId" name = "giftId">
				  <option>1</option>
				  <option>2</option>
				  </select>
				  </td>
				  <td>From </td>
				 
				  <td><%=userName%></td>				 
				  <td> To: </td>
				  <td>
				  <select id="friendId" name="friendId">
           		  <c:forEach var="friends" items="${friendshipList}">
                  <option value="${friends.friend.getUserId()}">${friends.friend.getUserName()}</option>
                  </c:forEach>
                  </select> 	  
                  </td>
                  </tr>	
				  </table>
			<input type= "submit" value = "Send">	  
		 	</div>
		 
		                                                                                                                                                                                                                                   
		 </div>
		</div>
		<%@ include file="footer.html"%>
	</form>>
</body>

</html>