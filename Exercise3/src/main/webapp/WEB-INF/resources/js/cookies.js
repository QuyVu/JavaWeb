function createCookie() {
	var cname = document.getElementById("cname").value;
	var cvalue = document.getElementById("cvalue").value;
	var cexpire = document.getElementById("cexpire").value;
	setCookie(cname, cvalue, cexpire);
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(";");
    var list="";
    for(var i=0; i<ca.length; i++) {
        list += "<li>" + ca[i] + "</li>";
    }
    document.getElementById("cList").innerHTML=list;
}

function checkCookie() {
    var user = getCookie("username");
    if (user != "") {
        alert("Welcome again " + user);
    } else {
        user = prompt("Please enter your name:", "");
        if (user != "" && user != null) {
            setCookie("username", user, 365);
        }
    }
}

function deleteCookie() {
    var cookies = document.cookie.split(";");
    for (var i = 0; i < cookies.length; i++) {
     var cookie = cookies[i];
     var eqPos = cookie.indexOf("=");
     var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
     document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}