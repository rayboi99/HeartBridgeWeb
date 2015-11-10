<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.se452.model.*" %>
    <%@page import="java.util.*"%>

      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 


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
     <c:import url="GetHomePageUserPicturesController" />
<% int[] idList=(int[])session.getAttribute("IdList");
String [] nameList = (String[]) session.getAttribute("nameList");%>
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
        </div>
         
    
<%ServletContext sc=request.getSession().getServletContext(); 
			String s=sc.getRealPath("/HomePageImage");%>
<br />
 <br />
 <br />
 <br />
<div class="col-sm-10" pull-middle">
<h2>New User</h2>
   <table width="800" border="0" cellpadding="40" class="table table-striped table-bordered table-condensed">



<td align="center" valign="center">


  <img  src="user/image.html?id=<%=idList[0]%>"
  class="img-rounded" alt="Cinque Terre" width="204" height="136"/>
<br />
 <br />
 <h4>User Name: <%=nameList[0]%></h4>
<form action="ViewOtherUserProfileController" method="post">
<button type="submit" class="btn btn-primary" name="button" value="0">See User Profile</button>
 </form>
 <br />
<br/>
</td>

<td align="center" valign="center">


  <img   src="user/image.html?id=<%=idList[1]%>"
  class="img-rounded" alt="Cinque Terre" width="204" height="136"/>
<br/>
<br/>

 <h4>User Name: <%=nameList[1]%></h4>
<form action="ViewOtherUserProfileController" method="post">
<button type="submit" class="btn btn-primary" name="button" value="1">See User Profile</button>
 </form>
 <br />
<br/>
<br/>
</td>
<td align="center" valign="center">

  <img  src="user/image.html?id=<%=idList[2]%>"
  class="img-rounded" alt="Cinque Terre" width="204" height="136"/>
<br />
<br/>
 <h4>User Name: <%=nameList[2]%></h4>
<form action="ViewOtherUserProfileController" method="post">
<button type="submit" class="btn btn-primary" name="button" value="2">See User Profile</button>
 </form>
 <br />
<br/>
<br/>
</td>
</tr>
<tr>

<td align="center" valign="center">

  <img 
  src="user/image.html?id=<%=idList[3]%>"
  class="img-rounded" alt="Cinque Terre" width="204" height="136" />
<br />
<br/>
 <h4>User Name: <%=nameList[3]%></h4>
<form action="ViewOtherUserProfileController" method="post">
<button type="submit" class="btn btn-primary" name="button" value="3">See User Profile</button>
 </form>
 <br />
<br/>
<br/>
</td>

<td align="center" valign="center">

  <img   src="user/image.html?id=<%=idList[4]%>"
   class="img-rounded" alt="Cinque Terre" width="204" height="136"/>
<br />
<br/>
 <h4>User Name: <%=nameList[4]%></h4>
<form action="ViewOtherUserProfileController" method="post">
<button type="submit" class="btn btn-primary" name="button" value="4">See User Profile</button>
 </form>
  <br />
<br/>
<br/>
</td>
<td align="center" valign="center">

  <img   src="user/image.html?id=<%=idList[5]%>" 
  class="img-rounded" alt="Cinque Terre" width="204" height="136" />
<br />
 <br />
  <h4>User Name: <%=nameList[5]%></h4>
<form action="ViewOtherUserProfileController" method="post">
<button type="submit" class="btn btn-primary" name="button" value="5">See User Profile</button>
 </form>
  <br />
<br/>
<br/>
</td>
</tr>


</table>
         </div>
<%@ include file="footer.html"%>
</body>
</html>