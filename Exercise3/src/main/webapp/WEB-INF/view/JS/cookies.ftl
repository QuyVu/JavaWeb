<#ftl encoding='UTF-8'>
<div class="row">
	<div class="col-md-4">
		<form action="cookies" method="post">
			<fieldset>
				<legend>Add a cookie:</legend>
				<input class="form-control" type="text" name="cname" id="cname" placeholder="name">
				<br>
				<input class="form-control" type="text" name="cvalue" id="cvalue" placeholder="value">
				<br>
				<input class="form-control" type="text" name="cexpire" id="cexpire" placeholder="expire">
				<br>
				<input type="submit" class="btn btn-primary btn-block" onclick="createCookie()" value="Submit">
			</fieldset>
			<p>${notice}</p>
		</form>
	</div>
	<div class="col-md-4">
		<button class="btn btn-primary btn-block" onclick="getCookie()">Show
			All Cookies</button>
		<ul id="cList"></ul>
	</div>
	<div class="col-md-4">
		<button class="btn btn-danger btn-block" onclick="deleteCookie()">Delete
			All Cookies</button>
	</div>
</div>
