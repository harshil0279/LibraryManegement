function myFunction()
 {
 		var y= document.forms["myForm"]["email"].value;
	
		var atpos = y.indexOf("@");
		var dotpos = y.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2 >= y.length) 
		{
				alert("Not a valid e-mail address");
			return false;
		}	
 
 }