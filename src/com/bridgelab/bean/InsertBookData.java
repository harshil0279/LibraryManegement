package com.bridgelab.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertBookData
 */
@WebServlet("/InsertBookData")
public class InsertBookData extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	
		String book_title = request.getParameter("book_title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		String price = request.getParameter("price");

		LoginBean loginbean = new LoginBean();

		loginbean.setBook_title(book_title);
		loginbean.setAuthor(author);
		loginbean.setCategory(category);
		loginbean.setPrice(price);


		LoginDAO.status = LoginDAO.saveBookData(loginbean);
		if(LoginDAO.status > 0)
		{	
			out.print("<p>Record Saved Successfully</p>");
		    response.sendRedirect("homePage.jsp");

		}
		else
		{
			out.println("Sorry unable to save record");
		}




	}

}
