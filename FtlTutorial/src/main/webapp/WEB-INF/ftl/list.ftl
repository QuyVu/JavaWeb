<#ftl encoding='UTF-8'>
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<title>Admin Page</title>
		<!-- Bootstrap Core CSS -->
    	<link href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    	<!-- DataTables CSS -->
    	<link href="resources/bower_components/datatables/media/css/dataTables.bootstrap.min.css" rel="stylesheet">

    	<!-- Custom Fonts -->
    	<link href="resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	</head>
	<body>
    	<div id="wrapper">
			<!-- page-wrapper -->
        	<div id="page-wrapper">
        		<div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">Data</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
					<#include "response-modal.ftl">
					
                    <#include "coffee-datatable.ftl">
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
       		</div>
    	</div>
		<!-- jQuery -->
    	<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>

    	<!-- Bootstrap Core JavaScript -->
    	<script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    	<!-- DataTables JavaScript -->
    	<script src="resources/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    	<script src="resources/bower_components/datatables/media/js/dataTables.bootstrap.min.js"></script>
    	
    	<!-- File Saver JavaScript -->
    	<script src="resources/bower_components/file-saver/FileSaver.min.js"></script>

    	<!-- Custom Theme JavaScript -->
    	<script src="resources/js/manage-coffee.js"></script>
	</body>
</html>