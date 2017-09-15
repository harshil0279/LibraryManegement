package com.bridgelab.controller;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 13/09/2017
 * Purpose   : create a servlet to delete the book data.
 *             
 **/

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelab.dao.LoginDAO;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		System.out.println("Inside delete servlet");
		LoginDAO.delete(id);
		//response.sendRedirect("homePage.jsp");
		
	}

}
