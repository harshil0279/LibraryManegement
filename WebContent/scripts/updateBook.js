function updateFunction()
{
	var x = document.forms["editBooks"]["book_title1"].value;
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

	var y = document.forms["editBooks"]["author1"].value;
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

	var a = document.forms["editBooks"]["price2"].value;
	console.log(a);
	var reg = /^\d+$/;
	if(a == '')
	{
		alert("please write price");
		return false;
	}
	else if(!reg.test(a))
	{
		alert("please write price in number");
		return false;
	} 
	
	var x = document.forms["editBooks"]["category1"].value;
	console.log("Value of X:"+x);
	if(x == 'Category')
	{
		alert("Please select one category");
		return false;
		console.log('hiiiii');
	}	

}