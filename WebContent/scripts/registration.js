function validateForm(){
	
	var name = document.getElementById("name").value;
	if(name.length < 3){
		alert("Name is too short");
		return false;
	}
	
	var email = document.getElementById("email").value;
	if(email.indexOf("@") < 2){
		alert("Invalid email address");
		return false;
	}
	if((email.indexOf(".") - email.indexOf("@")) < 2){
		alert("Invalid email address");
		return false;
	}
	if((email.length - email.indexOf(".")) < 2){
		alert("Invalid email address");
		return false;
	}
	
	var contact = document.getElementById("mobno").value;
	if(isNaN(contact)){
		alert("Invalid contact number");
		return false;
	}
	if(contact.toString().length != 10){
		alert("Contact number must have 10 digits");
		return false;
	}
	
	var male = document.getElementById("male").checked;
	var female = document.getElementById("female").checked;
	if(!male && !female){
		alert("Please select a gender");
		return false;
	}
	
	var password = document.getElementById("password").value;
	if(password.length < 8){
		alert("Password must be at least 8 characters long");
		return false;
	}
	
	return true;
}