<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Gift picture</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form class="form-horizontal" action="AddGiftPicServlet" method="post">

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="giftId">GiftId :</label>
			<div class="col-md-4">
				<textarea class="form-control" id="textarea" name="giftId"></textarea>
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="name">Name :</label>
			<div class="col-md-4">
				<textarea class="form-control" id="textarea" name="name"></textarea>
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="description">Description
				:</label>
			<div class="col-md-4">
				<textarea class="form-control" id="textarea" name="description"></textarea>

			</div>
		</div>


		<!-- File Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="filebutton">Upload
				Profile Picture</label>
			<div class="col-md-4">
				<input id="filebutton" name="giftImage" class="input-file"
					type="file">
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="submitButton"></label>
			<div class="col-md-4">
				<input type="submit" name="save" value="save" /> 
			</div>
		</div>
	</form>
</body>
</html>