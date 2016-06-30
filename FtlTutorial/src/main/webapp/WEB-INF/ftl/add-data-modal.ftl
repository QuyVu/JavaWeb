<#ftl encoding='UTF-8'>
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add new Data</h4>
			</div>
			<div class="modal-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-4">name</th>
							<th class="col-md-4">password</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input id="new-name" type="text" class="form-control"></td>
							<td><input id="new-password" type="password"
								class="form-control"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button id="submitUser" class="btn btn-primary" data-dismiss="modal">OK</button>
				<button class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>