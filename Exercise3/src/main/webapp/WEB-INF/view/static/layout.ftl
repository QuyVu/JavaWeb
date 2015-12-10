<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title><@tiles.insertAttribute name="title" /></title>
<link rel='stylesheet' href='resources/css/custom.css'>
<link rel='stylesheet' href='resources/css/bootstrap.min.css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/validateEmail.js"></script>
<script src="resources/js/animation.js"></script>
<script src="resources/js/dropdownHover.js"></script>
<script src="resources/js/cookies.js"></script>
</head>
<body>
	<@tiles.insertAttribute name="header" />
	<div class="main">
		<div id="body" class="row">
   			<@tiles.insertAttribute name="body" />
   		</div>
	</div>
	<@tiles.insertAttribute name="footer" />
</body>
</html>