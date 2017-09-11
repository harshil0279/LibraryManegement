package com.bridgelab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelab.dao.LoginDAO;
import com.bridgelab.model.LoginBean;

/**
 * Servlet implementation class EditServlet1
 */
@WebServlet("/EditServlet1")
public class EditServlet1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		   			response.setContentType("text/html");
		   			PrintWriter out = response.getWriter();
		   			out.println("<h1>Update Book</h1>");
		            String sid = request.getParameter("id");
		        	int id = Integer.parseInt(sid);
		        	System.out.println("Inside edit servlet 1 ");
		        	LoginBean loginBean = LoginDAO.getBookByID(id);
		        	out.print("<form action='EditServlet2' method='post'>");
		        	out.print("<table>");
		        	out.print("<tr><td></td><td><input type='hidden' name='id' value='"+loginBean.getId()+"'/></td></tr>");
		        	out.print("<tr><td>Book Name</td><td><input type='text' name='book_title' value='"+loginBean.getBook_title()+"'/></td></tr>");
		        	out.print("<tr><td>Author Name:</td><td><input type='text' name='author' value='"+loginBean.getAuthor()+"'/></td></tr>");
		        	out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+loginBean.getPrice()+"'/></td></tr>");
		        	out.print("<tr><td>Category</td><td>");
		    		out.print("<select name='category' style='width:150px'>");
		    		out.print("<option>Science</option>");
		    		out.print("<option>Commarce</option>");
		    		out.print("<option>Arts</option>");		 
		    		out.print("</select>");
		    		out.print("</td></tr>");
		    		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		        	out.print("</table>");
		        	out.print("</form>");
			}


}
