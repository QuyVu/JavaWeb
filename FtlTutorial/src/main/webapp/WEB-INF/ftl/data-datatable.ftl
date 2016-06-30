<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<!-- /.panel-heading -->
	<div class="panel-body">
	<button id="new-data" class="btn btn-success" style="float:left" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> New Data</button>
	<input id="keyword" type="text" class="form-control col-md-3" style="width:30%; margin-left:50px; margin-right:5px">
	<button id="search" class="btn btn-primary"><i class="fa fa-search"></i> Search</button>
	<button id="logout" class="btn btn-default" style="float:right"><i class="fa fa-sign-out"></i> Logout</button>
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover"
				id="dataTable">
				<thead>
					<tr>
						<th class="col-md-1 text-center">id</th>
						<th class="col-md-4">username</th>
						<th class="col-md-4">password</th>
						<th class="col-md-3 text-center">action</th>
					</tr>
				</thead>
				<tbody id="table-body">
					<#list model["userList"] as data>
					<tr>
						<td class="text-center">${data.id}</td>
						<td id="data-name-${data.id}" class="data-name">
							<p id="p-name-${data.id}">${data.name}</p> 
							<input id="input-name-${data.id}" type="text"
							class="form-control input-sm" style="display: none; width: 100%"
							value="${data.name}">
						</td>
						<td id="data-password-${data.id}" class="data-password">
							<p id="p-password-${data.id}">${data.password}</p> 
							<input id="input-password-${data.id}" type="text" class="form-control input-sm" style="display: none; width: 100%"
							value="${data.password}">
						</td>
						<td class="text-center">
							<button id="edit-data-${data.id}" name="edit-data"
								style="width: 80px" class="edit edit-data btn btn-warning btn-sm"
								value="${data.id}">
								<i class="fa fa-pencil-square-o"></i> edit
							</button>
							<button id="get-data-${data.id}" name="get-data"
								style="width: 80px" class="get-data btn btn-primary btn-sm"
								value="${data.id}">
								<i class="fa fa-download"></i> data
							</button>

							<button id="save-data-${data.id}"
								style="width: 80px; display: none;"
								class="save-data btn btn-success btn-sm"
								value="${data.id}">
								<i class="fa fa-floppy-o"></i> save
							</button>

							<button id="cancel-edit-${data.id}"
								style="width: 80px; display: none;"
								class="cancel-edit btn btn-danger btn-sm"
								value="${data.id}">
								<i class="fa fa-times"></i> calcel
							</button>
						</td>
					</tr>
					</#list>
				</tbody>
			</table>
		</div>
		<div class="btn-group">
			<button id="btn-prev" class="btn btn-primary" disabled=true><i class="fa fa-angle-left"></i> Prev</button>
			<button id="display-info"class="btn btn-default" style="pointer-events: none">showing <b id="display-from">1</b> - <b id="display-to">10</b> of <b id="total-records" value="${total}">${total}</b></buton>		                 	
			<button id="btn-next"class="btn btn-primary">Next <i class="fa fa-angle-right"></i></button>
		</div>
	</div>
	<!-- /.panel-body -->
</div>
<!-- /.panel -->