<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Login Page</title>
<link rel='stylesheet' href='/FtlTutorial/resources/bower_components/font-awesome/css/font-awesome.min.css'>
<link rel='stylesheet' href='/FtlTutorial/resources/bower_components/bootstrap/dist/css/bootstrap.min.css'>
<script src="/FtlTutorial/resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="/FtlTutorial/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin-top: 50px;">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Login</h3>
			 	</div>
			 	<#if (error??)>
			 		<div class="login-fail">UserName or Password is incorrect</div>
			 	</#if>
			  	<div class="panel-body">
			    	<form name='f' action="j_spring_security_check" method='POST'>
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder='username' name="username" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder='password' name="password" type="password">
			    		</div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value='Login'>
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
</html>