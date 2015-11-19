<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><@tiles.insertAttribute name="title" /></title>
<link rel='stylesheet' href='resources/css/custom.css'>
<link rel='stylesheet' href='resources/css/bootstrap.min.css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
 <@tiles.insertAttribute name="header" />
 <div class="main">
   <@tiles.insertAttribute name="body" />
 </div>
<@tiles.insertAttribute name="footer" />
</body>
</html>