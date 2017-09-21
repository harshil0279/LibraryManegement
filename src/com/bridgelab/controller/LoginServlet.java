package com.bridgelab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelab.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
			response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("email");  
		    String p=request.getParameter("password");
		    HttpSession session=request.getSession(true);  
		    session.setAttribute("email", request.getParameter("email"));
		  
		    
		    try {
		    	int user_id=  LoginDAO.validate(n, p);
				if(user_id != -1){  
				    RequestDispatcher rd=request.getRequestDispatcher("homePage.jsp");  
				    session.setAttribute("user_id", String.valueOf(user_id));
				    rd.forward(request,response);  
				}  
				else{  
				    out.print("Sorry username or password error");  
				    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
				    rd.include(request,response);  
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	}

	

}
