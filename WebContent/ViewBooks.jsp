<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/viewbook.css">
</head>
<body>
    
<%@ page import="com.bridgelab.dao.LoginDAO" %>
<%@ page import="com.bridgelab.model.LoginBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>


    <h1 id="book_list">Book List</h1>
    <%
    List<LoginBean> list = (List<LoginBean>)request.getAttribute("list");
		request.setAttribute("list",list);
	%>

     <table border="0" width="100%">  
<tr><th>Book_title</th><th>Author</th><th>Category</th><th>Price</th>  <th colspan="2" id="actionbutton">Action</th>
</tr>  

    <c:forEach items="${list}" var="u"> 
<tr><td>${u.getBook_title()}</td><td>${u.getAuthor()}</td><td>${u.getCategory()}</td>  
<td>${u.getPrice()}</td> 

<td><a class='edit-class' href='#' id="EditServlet1?book_id=${u.getBook_id()}">edit</a></td>

<td><a class='delete-class'  href='#' id="DeleteBook?book_id=${u.getBook_id()}">delete</a></td></tr>  
</c:forEach>  
   </table>  
</body>
</html>