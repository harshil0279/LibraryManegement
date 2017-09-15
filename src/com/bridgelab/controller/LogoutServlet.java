package com.bridgelab.controller;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 13/09/2017
 * Purpose   : create a servlet for loging out the user
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

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
			{
				response.setContentType("text/html");
				PrintWriter printWriter = response.getWriter();
				request.getRequestDispatcher("index.jsp").include(request, response);  
				  HttpSession session=request.getSession();  
		            session.invalidate();  
		              
		            printWriter.print("You are successfully logged out!");  
		              
		            printWriter.close();  
			}
	    

}
