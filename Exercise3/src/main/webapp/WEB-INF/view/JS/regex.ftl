<#ftl encoding='UTF-8'>
<form name="validateEmail" action="regex" onsubmit="return validateForm()" method="post">
<h4>This example use JavaScript to prevent incorrect input from submit.</h4>
Email: <input type="text" name="email">
<input type="submit" class="btn btn-primary" value="Submit">
</form>

<div id="noticeDiv" class="alert alert-info">
	<p id="noticeContent">${email}</p>
</div>