package com.bridgelab.controller;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 13/09/2017
 * Purpose   : create a servlet to update a book data using the book id.
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
		String book_title = request.getParameter("book_title1");
		String author = request.getParameter("author1");
		String category = request.getParameter("category1");
		String price = request.getParameter("price2");
		int sprice = Integer.parseInt(price);
		
		LoginBean loginBean = new LoginBean();
		loginBean.setBook_title(book_title);
		loginBean.setAuthor(author);
		loginBean.setCategory(category);
		loginBean.setPrice(sprice);
		loginBean.setBook_id(id);
		//int price1 = Integer.parseInt("sprice");
		String price2 = Integer.toString(sprice);

		System.out.println("Starting update method");
		
		if(!book_title.matches("[a-zA-Z]+"))
		{
			System.out.println("Book name contains only characters");
			//response.sendRedirect("homePage.jsp");
		}
		else if(!author.matches("[a-zA-Z]+"))
		{
			System.out.println("Author name contains only characters");
			//response.sendRedirect("homePage.jsp");
		}
		else if(category == null)
		{
			System.out.println("please select a category");
			//response.sendRedirect("homePage.jsp");
		}
		else if(price2.matches("[a-zA-Z]+"))
		{
			System.out.println("please write price in numbers");
			//	response.sendRedirect("homePage.jsp");
			
		}
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
