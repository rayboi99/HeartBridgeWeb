<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
         
    
         <table width="800" border="0" cellpadding="5">

<tr>

<td align="center" valign="center">
<img src="http://yoursite.com/images/filename.jpg" alt="description here" />
<br />
Caption text centered under the image.
</td>

<td align="center" valign="center">
<img src="http://yoursite.com/images/filename.jpg" alt="description here" />
<br />
Caption text centered under the image.
</td>
<td align="center" valign="center">
<img src="http://yoursite.com/images/filename.jpg" alt="description here" />
<br />
Caption text centered under the image.
</td>
</tr>
<tr>

<td align="center" valign="center">
<img src="http://yoursite.com/images/filename.jpg" alt="description here" />
<br />
Caption text centered under the image.
</td>

<td align="center" valign="center">
<img src="http://yoursite.com/images/filename.jpg" alt="description here" />
<br />
Caption text centered under the image.
</td>
<td align="center" valign="center">
<img src="http://yoursite.com/images/filename.jpg" alt="description here" />
<br />
Caption text centered under the image.
</td>
</tr>

</table>
         </div>
<%@ include file="footer.html"%>
</body>
</html>