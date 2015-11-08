<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.se452.model.Gift"%>
<%@page import="com.se452.model.UserGift"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ReviewGift page</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<%@ include file="header.html"%>
	<div class="row">
		<div class="col-xs-2"><%@ include file="navBar.html"%></div>
		<%
			List<Gift> giftlistSE = (List<Gift>) request.getAttribute("giftListSent");
		%>
		<%
			List<Gift> giftlistRE = (List<Gift>) request.getAttribute("giftListReceived");
		%>
		<div class="col-xs-10"
			style="color: cornflowerblue; font-weight: bold; margin-left: 20px;">
			<div class="table">
				<h1>Gift Sent</h1>
				<table class="table table-hover" style="font-size: 20px;">
					<thead>
						<tr>
							<th>Gift Id</th>
							<th>Gift Name</th>
							<th>Gift Description</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<%
								for (Gift gift : giftlistSE) {
							%>

							<td><%=gift.getGiftId()%></td>
							<td><%=gift.getGiftName()%></td>
							<td><%=gift.getGiftDescription()%></td>

							<%
								}
							%>
						</tr>
					</tbody>
				</table>
				<h1>Gift Received</h1>
				<table class="table table-hover" style="font-size: 20px;">
					<thead>
						<tr>
							<th>Gift Id</th>
							<th>Gift Name</th>
							<th>Gift Description</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<%
								for (Gift gift : giftlistRE) {
							%>

							<td><%=gift.getGiftId()%></td>
							<td><%=gift.getGiftName()%></td>
							<td><%=gift.getGiftDescription()%></td>
							<%
								}
							%>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="input-append date" id="datetimepicker"
				data-date="12-02-2012 10:30" data-date-format="dd-mm-yyyy, hh:mm">
				<input class="span2" size="16" type="text" value="12-02-2012 10:30">
				<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<script type="text/javascript">
				$('.date').datetimepicker({
					weekStart : 1,
					todayBtn : 1,
					autoclose : 1,
					todayHighlight : 1,
					startView : 2,
					forceParse : 0,
					showMeridian : 1
				});
			</script>

			<form action="CreateGift.jsp" method="post">
				<div class="button" style="float: right;">
					<input type="submit" value="Create a new gift">
				</div>
			</form>
			>
		</div>
	</div>
	<%@ include file="footer.html"%>>
</body>


</html>