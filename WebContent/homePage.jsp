<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
.container-fluid {
	background-color: pink;
}

.btn btn-primary btn-lg {
	margin-left: 10px;;
}
</style>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<nav class="navbar navbar-default">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Students Library</a>
	</div>
	<ul class="nav navbar-nav">
		<li class="active"><a href="LogoutServlet" class="pull-right">Logout</a></li>
		<li><a href="#">
				<% out.print(session.getAttribute("email") + "&nbsp;&nbsp;&nbsp;&nbsp;"); %>
		</li>
		<li><a href="#"></a></li>
		<li><a href="#"></a></li>
	</ul>



</div>



</nav>


<div class="container">
	<h2>Books Category</h2>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#scienceModal" id ="category-body">Science</button>
	<!-- Modal -->
	<div class="modal fade" id="scienceModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Science Books</h4>

				</div>
				<div class="modal-body" id="body-of-modal">
					<p>Some text in the modal.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#commerceModal" id="category-commerce">Commerce</button>



	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#artsModal" id="category-arts">Arts</button>



</div>
<div class="container">
	<h2></h2>
	<!-- Trigger the modal with a button -->
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
		data-target="#myModal">Add New Book</button>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form action="InsertBookData" name="addNewBook" method="post">
					<div class="modal-header">

						<h4 class="modal-title">Add Book</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<input type="text" class="form-control" name="book_title"
								placeholder="Book Title">
						</div>

						<div class="form-group">
							<input type="text" class="form-control" name="author"
								placeholder="Author">
						</div>

						<div class="form-group">

							<select name="category" class="form-control">
								<option selected disabled>Category</option>
								<option value="Science">Science</option>
								<option value="Commerce">Commerce</option>
								<option value="Arts">Arts</option>
							</select>

						</div>

						<div class="form-group">
							<input type="number" class="form-control" name="price"
								placeholder="Price">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary btn-sm"
							data-dismiss="modal">Cancel</button>
						<input type="submit" class="btn btn-primary btn-sm" value="Save">
					</div>
			</div>

		</div>
	</div>

</div>

<script type="text/javascript">

 
 
$(document).ready(function(){
	 
	 console.log("Starting javascript");
	 //javascript code to fetch science data
	 $('#category-body').click(function(){

		 
		   $.ajax({			   
			   type:'post',
			   url: "ViewServlet",
			   data:{category:"Science"},
			   success: function(result){
					 
				  $('#body-of-modal').html(result);
				  $('#scienceModal').modal('show');
			   }
			   
		   });
			
		});

	 
	 
	 //javascript code to fetch commerce data
		$('#category-commerce').click(function(){

			 console.log("Test");
		   $.ajax({			   
			   type:'post',
			   url: "ViewServlet",
			   data:{category:"Commerce"},
			   success: function(result){
					  console.log("success");
				  $('#body-of-modal').html(result);
				  $('#scienceModal').modal('show');
			   }
			   
		   });
			
		});
		
		
		 //javascript code to fetch arts data
		$('#category-arts').click(function(){

			 console.log("Test");
		   $.ajax({			   
			   type:'post',
			   url: "ViewServlet",
			   data:{category:"Arts"},
			   success: function(result){
					  console.log("success");
				  $('#body-of-modal').html(result);
				  $('#scienceModal').modal('show');
			   }
			   
		   });
			
		});
		
		
		
		
	});
 </script>
</body>
</html>