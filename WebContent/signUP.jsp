<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="CSS/registration.css">

</head>
<div class="container">

		<div class="row">

			<div class="col-lg-5 col-md-6 col-sm-8 col-xs-8 block">

				<h1>Create An Account</h1>
				<hr>
				<form action="InsertData" name="login" method="post">

					<div class="form-group">
						<label for="name">Full Name:</label> <input type="text"
							class="form-control" name="name" id="name">
					</div>

					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" name="email" id="email">
					</div>

					<div class="form-group">
						<label for="mobno">Enter Your Mobile Number</label> <input type="tel"
							class="form-control" name="mobileNumber" id="mobno">
					</div>
					Gender: <label class="radio-inline"> <input type="radio"
						id="male" name="gender" value="Male">Male
					</label> <label class="radio-inline"> <input type="radio"
						id="female" name="gender" value="Female">Female
					</label>

					<div class="form-group">
						<label for="password">New Password:</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>
					<div class="form-group">
						<label for="password">Conform Password</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>
					<p id="para">
						By Clicking on the "Create an account" button below, you certify
						that you have read and agreed to our <a href="#">terms of use</a>
						and <a href="#">privacy policy<a>
					</p>
					<center>
						<input type="submit" value="Create An Account"
							class="inputs btn-background text-center" id="register-button"
							onClick="return validateForm()">
					</center>
				</form>
				<p id="last-line">
					Already have an account? <a href="index.jsp">Sign in.</a>
				</p>

			</div>

		</div>

	</div>

	<script type="text/javascript" src="scripts/registration.js"></script>
</body>
</html>