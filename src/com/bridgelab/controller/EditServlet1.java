package com.bridgelab.controller;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 13/09/2017
 * Purpose   : create a servlet to fetch a book data using the book id.
 *             
 **/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session=request.getSession(false);  
        String user_id1=(String)session.getAttribute("user_id");  
        int user_id = Integer.parseInt(user_id1);
		
		
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//out.println("<h1>Update Book</h1>");
		System.out.println("inside edit servlet 1");
		
		String sid = request.getParameter("id");
		System.out.println("sid"+sid);
		int id = Integer.parseInt(sid);
		System.out.println("id is"+id);
		LoginBean loginBean = LoginDAO.getBookByID(id);
		request.setAttribute("loginBean", loginBean);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditBook1.jsp");
		dispatcher.forward(request, response);
		
	/*	out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+loginBean.getBook_id()+"'/></td></tr>");
		out.print("<tr><td>Book Name</td><td><input type='text' name='book_title' value='"+loginBean.getBook_title()+"'/></td></tr>");
		out.print("<tr><td>Author Name:</td><td><input type='text' name='author' value='"+loginBean.getAuthor()+"'/></td></tr>");
		out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+loginBean.getPrice()+"'/></td></tr>");
		out.print("<tr><td>Category</td><td>");
		out.print("<select name='category' style='width:150px'>");	    		out.print("<option>Science</option>");
		out.print("<option>Commerce</option>");		    		out.print("<option>Arts</option>");		 
		out.print("</select>");
		out.print("</td></tr>");    	
          	out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");*/
	}


}
