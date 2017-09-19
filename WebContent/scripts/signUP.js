function myFunction()
{
	//logic to validate name of user	
	var x = document.forms["myForm"]["name"].value;
	if (x == "") 
	{
		alert("Name must be filled out");
		return false;
	}


	//logic to validate email

	var y= document.forms["myForm"]["email"].value;

	var atpos = y.indexOf("@");
	var dotpos = y.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=y.length) 
	{
		alert("Not a valid e-mail address");
		return false;
	}	

	//logic to validate number
	var z, text;
	console.log("Inside Console")
	// Get the value of the input field with id="numb"
	z = document.getElementById("number").value;

	// If x is Not a Number or less than one or greater than 10
	if (isNaN(z) || z.length <10 || z.length >10) 
	{
		alert(" Mobile Number is not valid")
		return false;
	}

	// document.getElementById("demo").innerHTML = text;


	//function to validate male and password
	var male = document.getElementById("male").checked;
	var female = document.getElementById("female").checked;
	if(!male && !female)
	{
		alert("Please select a gender");
		return false;
	}



	var password = document.getElementById("password").value;
	if(password.length < 6)
	{
		alert("Password must be at least 6	 characters long");
		return false;
	} 		       
}
