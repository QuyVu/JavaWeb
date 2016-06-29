function User(id, name, password) {
	this.id = id, this.name = name, this.password = password
}

User.prototype.setUser = function(id, name, password) {
	this.id = id;
	this.name = name;
	this.password = password;
}

User.prototype.setId = function(id) {
	this.id = id;
}

User.prototype.setName = function(name) {
	this.name = name;
}

User.prototype.setPassword = function(newPassword) {
	this.password = newPassword;
}

var user = new User(0, "", "");

$(document).ready(function() {
	$('#dataTable').DataTable({
		responsive : true,
		pageLength : 20
	});
});

// Edit data
function updateData() {
	console.log(user);
	$.ajax({
		type : "POST",
		url : "update-data",
		contentType : "application/json",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(user),
		success : function(result) {
			if (result == 0) {
				var str = "<h3>Tên bị trùng</h3>";
				$("div#response-body").append(str);
			} else if (result == -1) {
				var str = "<h3>Kết nối db thất bại</h3>";
				$("div#response-body").append(str);
			} else {
				var str = "<h3>Thành công</h3>";
				$("div#response-body").append(str);
			}
			$("#response-modal").modal();
			autoCloseModal();
		},
		error : function(result) {
			alert(result);
		}
	});
};

function displayElement(action, id) {
	if (action == "edit") {
		$("button#save-data-" + id).show();
		$("button#cancel-edit-" + id).show();
		$("input#input-name-" + id).show();
		$("input#input-password-" + id).show();
		$("p#p-name-" + id).hide();
		$("p#p-password-" + id).hide();
		$("button#get-data-" + id).hide();
		$("button.edit-data").prop("disabled", true);
	} else {
		$("button#edit-data-" + id).show();
		$("button#get-data-" + id).show();
		$("p#p-name-" + id).show();
		$("p#p-password-" + id).show();
		$("input#input-name-" + id).hide();
		$("input#input-password-" + id).hide();
		$("button.edit-data").prop("disabled", false);
	}
}

$("button#submit-data").click(function() {
	user.setName($("#new-name").val());
	user.setPassword(parseFloat($("#new-password").val()));
	if (validateNewCoffee()) {
		confirmCoffee("addCoffee");
	} else {
		var str = "<h3>" + string.inputError + "</h3>";
		$("div#response-body").append(str);
		$("#response-modal").modal();
		autoCloseModal();
	}
});

$("button.edit-data").click(function() {
	$(this).hide();
	displayElement("edit", $(this).val());
});

$("button.get-data").click(function() {
	user.setId(parseInt($(this).val()));
	getData();
});

function saveFile(data) {
	var fileName = data.id + ".json";
	var content = JSON.stringify(data);
	var file = new File([content], fileName, {type : "text/plain;charset=utf-8"});
	saveAs(file);
}

function getData() {
	$.ajax({
		type : "POST",
		url : "getjson",
		timeout : 100000,
		data : {
			id : user.id
		},
		success : function(result) {
			saveFile(result);
		},
		error : function(data) {
			alert(data);
		}
	});
}

$("button.save-data").click(
		function() {
			user.setUser(parseInt($(this).val()), $(
					"input#input-name-" + $(this).val()).val(), $(
					"input#input-password-" + $(this).val()).val());
			updateData();
			$(this).hide();
			$("button#cancel-edit-" + $(this).val()).hide();
			displayElement("save", $(this).val());
			user = new User(0, "", "");
		});

$("button.cancel-edit").click(function() {
	displayElement("cancel", $(this).val());
	$(this).hide();
	$("button#save-data-" + $(this).val()).hide();
});

$("button#close-modal").click(function() {
	window.location.reload();
});

function autoCloseModal() {
	setTimeout(function() {
		$("#response-modal").modal('hide');
		$("div#response-body").children().remove();
		window.location.reload();
	}, 1500);
}