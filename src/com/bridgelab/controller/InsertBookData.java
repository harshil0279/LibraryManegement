package com.bridgelab.controller;

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
		String book_title = request.getParameter("book_title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		Double price = Double.parseDouble(request.getParameter("price"));
		String email = (String) session.getAttribute("email");

		LoginBean loginbean = new LoginBean();

		loginbean.setBook_title(book_title);
		loginbean.setAuthor(author);
		loginbean.setCategory(category);
		loginbean.setPrice(price);
		loginbean.setEmail(email);


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
