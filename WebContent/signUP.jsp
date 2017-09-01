<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<head>
<title>Registration page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>
.container {
	
}


#signin {
	background-color: #43af43
}


.column{
margin:0 auto;
background-color: white;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	function validateForm() {
		var x = document.forms["login"]["name"].value;
		if (x == "") {
			alert("Name must be filled out");
			return false;
		}	

		var genders = document.getElemetsByName("optradio");
		if (!genders[0].checked) {
			if(!genders[1].checked){
				console.log("gender check");
				alert("Please choose your Gender: Male or Female");				
			}
		}
				
			return false;
		}
		if (ErrorText = "") {
			form.submit()
		}

		var a = document.form.phone.value;
		if(a=="")
		{
		alert("Please Enter Your Mobile Number");
		document.form.phone.focus();
		return false;
		}
		
		var x = document.forms["login"]["email"].value;
	    var atpos = x.indexOf("@");
	    var dotpos = x.lastIndexOf(".");
	    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
	        alert("Not a valid e-mail address");
	        return false;
	    }
	    
	    var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirm_password").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
	
</script>



</head>
<body style="background-color: rgba(79, 222, 222, 0.72)">
	<div class="container">
		<div class ="col-lg-6 col-md-6 col-sm-6 col-xs-6 column">
		<h2>Create an Account</h2>
		<form action="InsertData" name="login" onsubmit="return validateForm()"
			method="post">
			<div class="form-group">
				<label for="fullname">Enter your full name</label> <input
					type="text" id="fullname" class="form-control"
					placeholder="Enter your full name" name="name">
			</div>
			<div class="form-group">
				<label for="gender">Gender</label>
				<div class="row">
					<div class="col-md-6">
						<div class="radio">
							<label><input type="radio" name="gender">Male</label>
						</div>
					</div>
					<div class="col-md-6">
						<div class="radio">
							<label><input type="radio" name="gender">Female</label>
						</div>
					</div>
					<div class="form-group">
						<label for="fullname">Enter your mobileNo</label> <input
							type="text" id="fullname" class="form-control"
							placeholder="Enter your mobile number" name="mobileNumber">
					</div>
					<div class="form-group">
						<label for="email">Enter your email</label><br> <input
							type="email" id="email" class="form-control"
							placeholder="Enter email" name="email">
					</div>
					<div class="form-group">
						<label for="pwd">Enter your Password</label><br> <input
							id="password" type="password" class="form-control"
							placeholder="Enter password" name="password">
					</div>
					<div class="form-group">
						<label for="pwd">Confirm Password:</label><br> <input
							id="confirm_password" type="password" class="form-control"
							placeholder="Enter password" name="password">
					</div>
					<div class="form-group">
						<p style="border-style: dotted; margin: 0; padding: 10px">
							By Clicking On the "Create an account button" bellow, yoy certify
							that you have read and agree to our <a href="">terms of use</a>
							and <a href="">privacy policy</a>
						</p>

						<br>
						<button type="submit" onclick="validateForm()"
							class="form-control"
							style="color: white; background-color: #43af43" id="signin"
							class="btn">Submit</button>
							</from>
						<p style="text-align:center">Create an account?<style></p>
					</div>
		</form>
	</div>
	</div>
	

</body>
</html>