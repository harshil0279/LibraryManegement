
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Login</title>


<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<link rel="stylesheet" type="text/css" href="CSS/login.css">

<body>


	

	<form action="LoginServlet" method="get" name="myForm" >
		<div class="container-fluid" id="container_fluid">
			<div class="center-block ">
				<div class="row ">
					<div class="col-sm-12  col-centered">

						<div class="row ">
							<div class="col-sm-8  .col-centered">
								<h2>Sign-in</h2>
								<hr>
							</div>
							<!-- End of col-sm-8 class -->
						</div>
						<!-- End of row1 class -->
						<div class="row ">

							<div class="col-sm-4  " id="secondSection">

								<b id="account-font">Use Other Account</b><br>
								<br>
								<p>You can also sign in using facwbook and google account.</p>
								<br>

								<button type="button" class="btn btn-primary btn-block"
									id="accountButton1">login with facebook</button>
								<button type="button" class="btn btn-primary btn-block"
									id="accountButton2">login using google</button>
								<br>

							</div>
							<!-- End of col-sm-4 class -->

							<div class="col-sm-4 ">
								
									<p class="text-center" id="account-font">
										<b>Using Your Account</b>
									</p>

									<input type="email" class="form-control" id="email"
										placeholder="Enter email" required name="email" onblur="myFunction()">
										 <input
										type="password" class="form-control" id="password"
										placeholder="Enter password" name="password" required minlength ="6"><br>
									<input type="submit" formaction="LoginServlet"
										value="Sign In" class="btn btn-primary btn-block"
										id="accountButton3"></input> 
										</p>
								
								
							</div>
							<!-- End of col-sm-4 class -->

						</div>




					</div>
					<!-- End of col-sm-12 class -->

				</div>
				<!-- End of row class -->
			</div>
			<!-- End of  class -->
		</div>
		<!-- End of  container-fluid -->

	</form>
	
	<a href="signUP.jsp" class="text-center" id="fpassword">Register</a>
     
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 <script type="text/javascript" src="scripts/index.js"></script>

</body>
</html>