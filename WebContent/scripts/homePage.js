$(document).ready(function(){
	 var category="";
	 console.log("Starting javascript");
	 //ajax code to fetch science data
	 $('#category-body').click(function(){

		 category="Science";
		   $.ajax({			   
			   type:'post',
			   url: "ViewServlet",
			   data:{category:"Science"},
			   success: function(result){
					 
				  $('#body-of-modal').html(result);
				  $('#scienceModal').modal('show');
				  
				  refreshClickEvent();				   
				 
				
				  
			   }
			   
		   });
			
		});

	 
	 
	 //ajax code to fetch commerce data
		$('#category-commerce').click(function(){
			 category="Commerce";
			 console.log("Test");
		   $.ajax({			   
			   type:'post',
			   url: "ViewServlet",
			   data:{category:"Commerce"},
			   success: function(result){
					  console.log("success");
				  $('#body-of-modal').html(result);
				  $('#scienceModal').modal('show');
			  
				  refreshClickEvent() 
			   
			   }
			   
		   });
			
		});
		
		
		 //ajax code to fetch arts data
		$('#category-arts').click(function(){
			 category="Arts";
			 console.log("Test");
		   $.ajax({			   
			   type:'post',
			   url: "ViewServlet",
			   data:{category:"Arts"},
			   success: function(result){
					  console.log("success");
				  $('#body-of-modal').html(result);
				  $('#scienceModal').modal('show');
			   
				  refreshClickEvent() 
			   }
			   
		   });
			
		});
		 
		 
		//function to edit the data
	     function refreshClickEvent() { 
	    	 console.log("caslled");

			$("body .edit-class").off();

			$("body .edit-class").on("click", function() {
				console.log("woah");
				var id = $(this).attr('id');
			
				id = id.replace('EditServlet1?book_id=','');
				console.log("Inside click event " +id);
				$.ajax
				({
					
					type : "post",
					url : "EditServlet1",
					data : {id:id},
					success : function(data)
					{
						$('#body-of-modal').html(data);
						
					}
				});
				
				 refreshClickEvent() 
			});
			
			
			  //function for to delete the book data
			   $("body .delete-class").off();			   
			   $("body .delete-class").on("click",function()
			    {
				   
				   var id = $(this).attr('id');
				   
				   id = id.replace('DeleteBook?book_id=','');
				   $.ajax
				   ({
					   
					   type:"post",
					   url : "DeleteBook",
					   data :{id:id},
					   success:function(data)
					   {
						   
						   loaddata();
					   }
				   });  		  		   
				 
				   
			  });  	   	      
			
			
	     }
	     
	     
		
		//function for loading data continouly
	     function loaddata(){
	    	 console.log("category " +category);
	    	 $.ajax({			   
				   type:'post',
				   url: "ViewServlet",
				   data:{category:category},
				   success: function(result){
						 
					  $('#body-of-modal').html(result);
					  $('#scienceModal').modal('show');
					  
					  refreshClickEvent();
					   
				   }
	     });
	     }    	
		  	  
	});