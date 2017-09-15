package com.bridgelab.controller;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 13/09/2017
 * Purpose   : create a servlet to insert user details and create a new user account
 *             
 **/

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
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet 
{
	private static final long serialVersionUID = 1L;      
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String mobileNumber = request.getParameter("mobileNumber");
		String gender = request.getParameter("gender");
		//System.out.println("gender is"+gender);
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		
		
		
		LoginBean loginbean = new LoginBean();
		loginbean.setName(name);
		loginbean.setMobileNumber(mobileNumber);
		loginbean.setGender(gender);
		loginbean.setEmail(email);
		loginbean.setPassword(password);	
		
		if(!name.matches("[a-zA-Z]+"))
		{
			System.out.println("name contains only characters");
			response.sendRedirect("signUP.jsp");
		}				
	
		else if(!mobileNumber.matches("(?<!\\d)\\d{10}(?!\\d)"))
		{
			System.out.println("Mobile Number is invalid");
			response.sendRedirect("signUP.jsp");
		}
		else if(gender == null)
		{
			System.out.println("please enter a gender");
			response.sendRedirect("signUP.jsp");
		}		
		
		/*else if(!gender.equals("male") && !gender.equals("female"))
		{
			System.out.println("Please select gender");
			response.sendRedirect("signUP.jsp");
		}*/
		else if (email.equals("") || (email.indexOf('@') == -1))
		{
			System.out.println("Please enter a valid email address");
			response.sendRedirect("signUP.jsp");	
		}
		else if(password.length() < 6)
		{
			System.out.println("Password must be atleast 6 characters");
		}
		else
		{
		
				LoginDAO.status = LoginDAO.save(loginbean);
		}
		if(LoginDAO.status > 0)
		{	
			out.print("<p>Record Saved Successfully</p>");
			request.getRequestDispatcher("").include(request, response);		
			
		}
		else
		{
			out.println("Sorry unable to save record");
		}	
			
		
		
	}

}
