<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Login</title>
<script>
function validateForm() 
{
    var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	{
        alert("Not a valid e-mail address");
        return false;
    }
    
    var passw=  /^[A-Za-z]\w{7,14}$/;  
    if( document.forms["myForm"]["password"].value.match(passw))   
    {   
    alert('Correct, try another...')  
    return true;  
    }  
    else  
    {   
    alert('Wrong...!')  
    return false;  
    }  
}


</script>
<!-- Bootstrap References -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<!-- JQuery References  -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="CSS/login.css" />

</head>
<body>
	<!-- Main Script  -->
	<div class="container ">
		<div class="container justify-content-center col-6 supercontainer"
			align="center">

			<div class="row">
				<div class="col classpadding">
					<h3>Sign In</h3>
					<hr class="hrmargin" />
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6 subcontainer classpadding">
					<div class="row">
						<div class="col">
							<h4 id="faded">Use other accounts</h4>
						</div>
					</div>
					<div class="row">
						<div class="col hidden-sm-down">
							<p>you can also sign in using your</p>
							<p>Facebook Account or Google Account</p>
						</div>
					</div>
					<div class="row">
						<div class="col col-12">
							<button type="submit"
								class="btn btn-default roundbutton facebook bigbutton">Log
								in with Facebook</button>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col col-12">
							<button type="submit"
								class="btn btn-primary roundbutton bigbutton">Log in
								with Google</button>
						</div>
					</div>
				</div>

				<div class="col-sm-6 subcontainer sideborder classpadding">
					<div class="row">
						<div class="col">
							<h4 id="faded">Use your accounts</h4>
							<br />
						</div>
					</div>
					<div class="row">
						<div class="col padding">
							<form name="myForm" class="formpadding" onsubmit="return validateForm();"
							                           method="post">
								<input type="email" class="form-control" class="form-control"
									id="email" placeholder="Enter email" name="email"> 
								<input type="password" class="form-control" id="password"
									placeholder="Enter password" name="password" >
								<button type="submit" class="btn btn-success  btn-lg btn-block "
									id="submitButton">Submit</button>
								<br>
								<div id="pass">
									<a href="#">Forgot password?</a>
								</div>
								<div id="register">
									<a href="#">Register!</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>