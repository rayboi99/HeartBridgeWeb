<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
        <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.se452.model.*" %>
    <%@page import="java.util.*"%>
    <%@page import="java.awt.image.BufferedImage"%>
     <%@page import="javax.imageio.ImageIO"%>
    <%@page import="java.io.ByteArrayInputStream"%>
     <%@page import="java.io.File"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 

Read more: http://javarevisited.blogspot.com/2014/11/how-to-loop-hashmap-or-hashtable-in-jsp-example.html#ixzz3qktSTDnx
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Heart Bridge</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file="header.html"%>
<div class="row">
		<div class="col-sm-2"><%@ include file="navBar.html"%></div>
		<div class="col-sm-10">
		<div class="col-sm-7 col-md-3 pull-right">
        <form class="navbar-form" role="search">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
        </div>
         <div class="col-sm-10">
         <c:import url="GetHomePageUserPicturesController" />
<%ServletContext sc=request.getSession().getServletContext(); 
			String s=sc.getRealPath("/HomePageImage");%>


   <table width="800" border="0" cellpadding="5">

<tr>
<table> 

<td align="center" valign="center">
<%String path="";%>
<% path= s+"/Image0";%>
  <img width="100px" height="100px" src="<%=path%>" 
  alt="description here" />
<br />
<br/>
<form action="ChangeFriendRequestController" method="post">
<input type="submit" value="User Profile">
 </form>
</td>

<td align="center" valign="center">

<% path= s+"/Image1";%>
  <img width="100px" height="100px" src="<%=path%>" 
  alt="description here" />
<br />
<br/>
<form action="ChangeFriendRequestController" method="post">
<input type="submit" value="User Profile">
 </form>
</td>
<td align="center" valign="center">

<% path= s+"/Image2";%>
  <img width="100px" height="100px" src="<%=path%>" 
  alt="description here" />
<br />
<br/>
<form action="ChangeFriendRequestController" method="post">
<input type="submit" value="User Profile">
 </form>
</td>
</tr>
<tr>

<td align="center" valign="center">
<% path= s+"/Image3";%>
  <img width="100px" height="100px" src="<%=path%>" 
  alt="description here" />
<br />
<br/>
<form action="ChangeFriendRequestController" method="post">
<input type="submit" value="User Profile">
 </form>
</td>

<td align="center" valign="center">
<% path= s+"/Image4";%>
  <img width="100px" height="100px" src="<%=path%>" 
  alt="description here" />
<br />
<br/>
<form action="ChangeFriendRequestController" method="post">
<input type="submit" value="User Profile">
 </form>
</td>
<td align="center" valign="center">
<% path= s+"/Image5";%>
  <img width="100px" height="100px" src="<%=path%>" 
  alt="description here" />
<br />
<br/>
<form action="ChangeFriendRequestController" method="post">
<input type="submit" value="User Profile">
 </form>
</td>
</tr>


</table>
         </div>
<%@ include file="footer.html"%>
</body>
</html>