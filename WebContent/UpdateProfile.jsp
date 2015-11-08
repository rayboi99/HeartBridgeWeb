<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Update Profile</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ page
		import="com.se452.service.ProfileService, com.se452.model.Profile"%>

	<%
		int userId = (int) session.getAttribute("userIdKey");
		String message = (String) session.getAttribute("message");
		ProfileService ps = new ProfileService();
		Profile profile = ps.getProfile(userId);
		String aboutMe = "";
		String hobby = "";
		String idealPartner = "";
		
		if (profile != null) {
			aboutMe = profile.getAboutMe();
			hobby = profile.getHobby();
			idealPartner = profile.getIdealPartner();
		}
		
		ps.closeConnection();
		
		if (message == null){
			message ="";
		}
	%>

	<%@include file ="header.html"%> 

	<%=message%>

	<div class="container">
		<form class="form-horizontal" action="UpdateProfileServlet"
			method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>My Profile-> Update Profile</legend>


				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="aboutMe">About
						Me :</label>
					<div class="col-md-4">
						<textarea class="form-control" id="textarea" name="aboutMe"><%=aboutMe%></textarea>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="hobby">Hobby :</label>
					<div class="col-md-4">
						<textarea class="form-control" id="textarea" name="hobby"><%=hobby%></textarea>

					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textarea">Ideal
						Partner :</label>
					<div class="col-md-4">
						<textarea class="form-control" id="textarea" name="idealPartner"><%=idealPartner%></textarea>
					</div>
				</div>


				<!-- File Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="filebutton">Upload
						Profile Picture</label>
					<div class="col-md-4">
						<input id="filebutton" name="image" class="input-file" type="file">
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submitButton"></label>
					<div class="col-md-4">
						<input type="submit" name="save" value="save" /> <input
							type="submit" name="cancel" value="cancel" />
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	
	<%@include file ="footer.html"%> 
</body>
</html>