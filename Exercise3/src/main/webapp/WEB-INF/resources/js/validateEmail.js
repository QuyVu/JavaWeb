function validateForm() {
    var inputValue = document.forms["validateEmail"]["email"].value;
    var pattern = new RegExp(/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i);
    var isValid = pattern.test(inputValue);
    if (!isValid){
    	document.getElementById("noticeContent").innerHTML= "That Is not an email";
    	return false;	
    }
    else {
    	return true;
    }
}