function myFunction()
{

	var x = document.forms["addNewBook"]["book_title"].value;
	if (x == "") 
	{
		alert("Book Name must be filled out");
		return false;
	}

	var x = document.forms["addNewBook"]["author"].value;
	if (x == "") 
	{
		alert("Author Name of book must be filled out");
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
	var reg = /^\d+$/;
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