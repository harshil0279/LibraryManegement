function myFunction()
{
	var x = document.forms["addNewBook"]["book_title"].value;
	var letters = /^[A-Za-z]+$/;  

	if(x == '')
	{
		alert("please write Book Name");
		return false;
	}
	else if(!letters.test(x))  
	{  
		alert("name contain only characters");  
		return false;  
	}  



	var y = document.forms["addNewBook"]["author"].value;
	if (y == "") 
	{
		alert("Author Name of book must be filled out");
		return false;
	}
	else if(!letters.test(y))  
	{  
		alert("Author name contain only characters");  
		return false;  
	}  


	var x = document.forms["addNewBook"]["category"].value;
	console.log("Value of X:"+x);
	if(x == 'Category')
	{
		alert("Please select one category");
		return false;
		console.log('hiiiii');
	}	

	var z = document.getElementById("price1").value
	console.log(z);
	var reg = /^([1-9][0-9]{,2}(,[0-9]{3})*|[0-9]+)(\.[0-9]{1,9})?$/;
	if(z == '')
	{
		alert("please write price");
		return false;
	}
	else if(!reg.test(z)){
		alert("please write price in number");
		return false;
	}
}


