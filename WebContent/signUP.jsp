<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
form {
    border: 3px solid #f1f1f1;
}


   p.dashed {border-style: dashed; border-color:lightgrey;}

body
{

  margin: 350px;	
   margin-top:0px;
   background-color: lightblue;
}
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    height:150px;
	width:200px;
    text-align: center;
    
}

.box
{
		
      margin-left:100px;
      margin-top:70px;
	  width:400px;
	  background-color:white;

}
.label
{

    margin-top:60px;

}
.text{

    margin-left:70px;
}

.container {
    padding: 16px;
	margin:auto;
	background-color:none;


}

.createAccountButton
{

    font-size: 150%;
	 border-radius:    8px;


}
.avatar
{
   height:150px;
	width:150px;
	margin-left:200px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
	
	#bluel{
	   
	   color: blue;
	
	}
}
</style>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
</head>
<body>

<body>



<form action="	" class="box">
 

  <div class="container">
     <h2>Create an account</h2><hr><br>
    <label><b>Enter Your Email Adderss</b></label>
    <input type="text" name="uname" required><br><br>	

    <label ><b>Password</b></label>
    <input type="password" name="psw" required><br><br>
	
	<label><b>Confirm Password</b></label>
    <input type="password"  name="psw" required>
        <p class="dashed">By clicking on the "create an account button below, you certify that you have read and agree to our terms 
	of use  and <span id="bluel">privacy policy</span></p>
    <button type="submit" class="createAccountButton">Create an account</button>
	<p class= "text"> Already have an account? <span class="blue">Sign in</span></p> 	
  
  </div>

  
</form>

</body>

</body>
</html>