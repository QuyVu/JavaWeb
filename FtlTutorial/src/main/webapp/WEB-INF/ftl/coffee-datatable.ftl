<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<div class="panel-heading">data</div>
	<!-- /.panel-heading -->
	<div class="panel-body">
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
				<tbody>
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
								style="width: 80px" class="edit-data btn btn-warning btn-sm"
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
	</div>
	<!-- /.panel-body -->
</div>
<!-- /.panel -->