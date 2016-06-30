var user = new User(0, "", "");
var paging = new Paging(1, 2, 0, 1, 10, parseInt($("b#total-records").text().replace(/,/g, '')));
console.log(paging);
var keyword = "";
var isLastPage = false;

//=============== Create table for displaying data ===============
$(document).ready(function() {
	$('#dataTable').DataTable({
		responsive : true,
		paging:false,
		searching: false,
		info: false
	});
});

//=============== logout function ===============
$("button#logout").click(function() {
	$.get("/FtlTutorial/logout");
	window.location.reload();
});

//=============== add new data function ===============
$("button#submitUser").click(function() {
	console.log(user);
	if (isValidUser()) {
		action = "addUser";
		var str = "<h3>Are You Sure to add this data</h3>"
		$("div#confirm-body").append(str);
		$("#confirm-modal").modal();
	} else {
		var str = "<h3>Input Error</h3>";
		$("div#response-body").append(str);
		$("#response-modal").modal();
		autoCloseModal();
	}
});

$("#new-name").keyup(function() {
	user.setName($("#new_name").val());
});

$("#new-password").keyup(function() {
	user.setPassword($("#new_password").val());
});

function isValidUser() {
	if ((user.name).indexOf(' ') >= 0 || user.name == "") {
		return false;
	} else if ((user.password).indexOf(' ') >= 0 || user.password == "") {
		return false;
	} else {
		return true;
	}
}

$("button#accept-action").click(function() {
	$.ajax({
		type : "POST",
		url : "submit-new-user",
		contentType : "application/json",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(user),
		success : function(result) {
			if (result == -1) {
				var str = "<h3>Kết nối db thất bại</h3>";
				$("div#response-body").append(str);
			} else if (result == 0) {
				var str = "<h3>Tên bị trùng</h3>";
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
});

//=============== search function ===============
$("button#search").click(function() {
	keyword = $("input#keyword").val();	
	requestForData(keyword,parseInt(0));
	paging = new Paging(1, 2, 0, 1, 10, parseInt($("b#total-records").text().replace(/,/g, '')));
	$("b#display-from").text(paging.from);
	$("b#display-to").text(paging.to);
});

//=============== Pagination ===============
$("button#btn-prev").click(function(){
	if(paging.curPage>2) {
		paging.setCurPage(paging.curPage-1);
		paging.setNextPage(paging.curPage);
		paging.setOffset(paging.curPage);
		paging.setFrom(paging.curPage);
		paging.setTo(paging.nextPage);
		requestForData(keyword, paging.offset);
		if(isLastPage) {
			$("button#btn-next").prop("disabled",false);
			isLastPage = false;
		}
	} else if(paging.curPage==2){
		paging.setCurPage(paging.curPage-1);
		paging.setNextPage(paging.curPage);
		paging.setOffset(paging.curPage);
		paging.setFrom(paging.curPage);
		paging.setTo(paging.nextPage);
		requestForData(keyword, paging.offset);
		$("button#btn-prev").prop("disabled",true);
	}
	$("b#display-from").text(paging.from);
	$("b#display-to").text(paging.to);
	console.log(paging);
})

$("button#btn-next").click(function(){
	paging.setCurPage(paging.curPage+1);
	paging.setNextPage(paging.nextPage);
	paging.setOffset(paging.curPage);
	paging.setFrom(paging.curPage);
	paging.setTo(paging.nextPage);
	requestForData(keyword, paging.offset);
	if(paging.total<paging.to) {
		paging.to = paging.total;
	}
	console.log(paging);
	if(paging.curPage*10 > paging.total) {
		$("button#btn-next").prop("disabled",true);
		isLastPage = true;
	}
	$("button#btn-prev").prop("disabled",false);
	$("b#display-from").text(paging.from);
	$("b#display-to").text(paging.to);
})


//=============== print JSON file function ===============
$("tbody#table-body").on("click",".get-data",function() {
	user.setId(parseInt($(this).val()));
	$.ajax({
		type : "POST",
		url : "getjson",
		timeout : 100000,
		data : {
			id : user.id
		},
		success : function(data) {
			var fileName = data.id + ".json";
			var content = JSON.stringify(data);
			var file = new File([ content ], fileName, {
				type : "text/plain;charset=utf-8"
			});
			saveAs(file);
		},
		error : function(data) {
			alert(data);
		}
	});
});

//=============== edit data function ===============
$("tbody#table-body").on("click",".edit-data",function() {
	console.log($(this));
	$(this).hide();
	displayElement("edit", $(this).val());
});

$("tbody#table-body").on("click",".save-data",function() {
			user.setUser(parseInt($(this).val()), $(
					"input#input-name-" + $(this).val()).val(), $(
					"input#input-password-" + $(this).val()).val());
			updateData();
			$(this).hide();
			$("button#cancel-edit-" + $(this).val()).hide();
			displayElement("save", $(this).val());
			user = new User(0, "", "");
		});

$("tbody#table-body").on("click",".cancel-edit",function() {
	displayElement("cancel", $(this).val());
	$(this).hide();
	$("button#save-data-" + $(this).val()).hide();
});

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

//=============== common functions ===============
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

function requestForData(keyword,offset){
	$.ajax({
		type : "POST",
		url : "search",
		timeout : 100000,
		data : {keyword: keyword, offset: offset},
		success : function(result) {
			document.getElementById("table-body").innerHTML = result.html;
			$('b#total-records').text(result.total);
			paging.setTotal(result.total);
		},
		error : function(result) {
			alert(result);
		}
	});
}