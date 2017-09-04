package com.bridgelab.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelab.bean.LoginBean;
import com.bridgelab.bean.LoginDAO;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;      
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String mobileNumber = request.getParameter("mobileNumber");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		LoginBean loginbean = new LoginBean();
		loginbean.setName(name);
		loginbean.setMobileNumber(mobileNumber);
		loginbean.setGender(gender);
		loginbean.setEmail(email);
		loginbean.setPassword(password);	
		
		
		LoginDAO.status = LoginDAO.save(loginbean);
	
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
