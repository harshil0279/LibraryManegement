<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="CSS/updatebook.css">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="scripts/updateBook.js"></script>
</head>
<body>

	<%@ page import="com.bridgelab.dao.LoginDAO"%>
	<%@ page import="com.bridgelab.model.LoginBean"%>
	
	 
	
	<p id="updateBook">Update Books</p>
	 <%
        String book_id = request.getParameter("id");
	     LoginBean loginbean = LoginDAO.getBookByID(Integer.parseInt(book_id)); 
	     request.setAttribute("loginbean", book_id);
	%>
	<form action='EditServlet2'  method='post' name="editBooks" onsubmit="return updateFunction()" >
		<table>
		   <tr><td></td><td><input type='hidden' name='id' value="<%= loginbean.getBook_id()%>"/></td></tr>
		   <tr><td>Book Name</td><td><input id="book_title" type="text" name='book_title1' value="<%= loginbean.getBook_title() %>"/> </td></tr>
		   <tr><td>Author Name</td><td><input id="book_title" type="text"name='author1' value="<%= loginbean.getAuthor()%>"/> </td></tr>
		    <tr><td>Price</td><td><input id="book_title" type="text" name='price2' value="<%= loginbean.getPrice()%>"/> </td></tr>
		    <tr><td>Country:</td><td>
		    <select name="category1" id="book_title" >
		         <option>Science</option>
		         <option>Arts</option>
		         <option>Commerce</option>
		         
		    </select>
		    </td></tr>
		     <tr> <td colspan='2'><input id="edit_button" type="submit" value='Save' /></tr>
		</table>
		</form>
</body>
</html>