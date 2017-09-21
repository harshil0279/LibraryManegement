package com.bridgelab.controller;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 13/09/2017
 * Purpose   : create a servlet to insert a book datails from user.
 *             
 **/


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelab.dao.LoginDAO;
import com.bridgelab.model.LoginBean;

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

		HttpSession session = request.getSession();
		String user_id1=(String)session.getAttribute("user_id");  
		int user_id = Integer.parseInt(user_id1);
		String book_title = request.getParameter("book_title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		String sprice = request.getParameter("price");
		int price = Integer.parseInt(sprice);
		String email = (String) session.getAttribute("email");
		//  int user_id = (int) session.getAttribute("user_id");
		LoginBean loginbean = new LoginBean();

		loginbean.setBook_title(book_title);
		loginbean.setAuthor(author);
		loginbean.setCategory(category);
		loginbean.setPrice(price);
		loginbean.setEmail(email);
		loginbean.setUser_id(user_id);
		String price1 = Integer.toString(price);

		if(!book_title.matches("[a-zA-Z]+"))
		{
			System.out.println("Book name contains only characters");
			response.sendRedirect("homePage.jsp");
		}
		else if(!author.matches("[a-zA-Z]+"))
		{
			System.out.println("Author name contains only characters");
			response.sendRedirect("homePage.jsp");
		}
		else if(category == null)
		{
			System.out.println("please select a category");
			response.sendRedirect("homePage.jsp");
		}
		
		
		//String price1 = Integer.toString(price);
		else if(price1.matches("[a-zA-Z]+"))
		{
			System.out.println("please write price in numbers");
			response.sendRedirect("homePage.jsp");
			
		}
		else
		{

			LoginDAO.status = LoginDAO.saveBookData(loginbean);
		}
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
