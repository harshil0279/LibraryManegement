<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>




  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <link rel="stylesheet" type="text/css" href="CSS/sign-up.css">

</head>
<body>



	<div class="container-fluid ">
		<div class="center-block ">
			<div class="row ">
				<div class="col-sm-3 col-md-6 col-lg-4  block" id="raw-class">

					<h2 id="accountid">Create an account</h2>
					<hr>
					<div class="form-group">
						<label for="usr">Enter Your Name</label> <input type="text"
							class="form-control" name="name" id="name">
					</div>
					<!-- End of name form-group class -->

					<div class="form-group">
						<label for="usr">Enter your Email</label> <input type="email"
							class="form-control" name="email" id="email">
					</div>
					<!-- End of email form-group class -->
					<div class="form-group">
						<label for="usr">Enter Your Mobile Number</label> <input
							type="text" class="form-control" name="mobileNumber" id="name">
					</div>
					<!-- End of name form-group class -->
					Gender: <label class="radio-inline"> <input type="radio"
						name="optradio">Male
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">Female
					</label><br>
					<br>

					<div class="form-group">
						<label for="pwd">Enter Your Password:</label> <input
							type="password" class="form-control" name="password"
							id="password">
					</div>
					<!-- End of password form-group class -->

					<div class="form-group">
						<label for="pwd">Conform Password:</label> <input type="password"
							class="form-control" name="password" id="password">
					</div>
					<!-- End of conform password form-group class -->


					<p>
						By Clicking on the "Create an account" button below, you certify
						that you have read and agreed to our <a href="#">terms of use</a>
						and <a href="#">privacy policy<a>.
					</p>

					<button type="button" class="btn btn-primary btn-block"
						id="accountButton">create an account</button>
					<p id="last-text">Already have an account ?Sign in</p>

				</div>
				<!-- End of col-sm-3 col-md-6 col-lg-4 class -->

			</div>
			<!-- End of row class -->
		</div>
		<!-- end of center-block class  -->
	</div>
	<!-- End of  container-fluid -->




</body>
</html>