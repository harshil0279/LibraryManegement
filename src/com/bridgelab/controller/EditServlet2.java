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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String book_title = request.getParameter("book_title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		int sprice = Integer.parseInt(price);
		
		LoginBean loginBean = new LoginBean();
		loginBean.setBook_title(book_title);
		loginBean.setAuthor(author);
		loginBean.setCategory(category);
		loginBean.setPrice(sprice);
	
		int status = LoginDAO.update(loginBean);
		if(status > 0)
		{
			response.sendRedirect("homePage.jsp");
		}
		else
		{
			out.println("sorry unable to update");
		}
	}

	

}
