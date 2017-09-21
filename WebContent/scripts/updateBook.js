function myFunctionN()
{
	var x = document.forms["editBooks"]["book_title"].value;
	var letters = /^[A-Za-z]+$/;  

	if(x == '')
	{
		alert("please write Book Name");
		return false;
	}
	else if(!letters.test(x))  
	{  
		alert("Book Name contain only characters");  
		return false;  
	}  

	var y = document.forms["editBooks"]["author"].value;
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

	var x = document.forms["editBooks"]["category"].value;
	console.log("Value of X:"+x);
	if(x == 'Category')
	{
		alert("Please select one category");
		return false;
		console.log('hiiiii');
	}	

	var a = document.getElementById("price").value;
	console.log(a);
	var reg = /^\d+$/;
	if(a == '')
	{
		alert("please write price");
		return false;
	}
	else if(!reg.test(a)){
		alert("please write price in number");
		return false;
	}





}