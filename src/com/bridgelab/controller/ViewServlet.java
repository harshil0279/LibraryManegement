package com.bridgelab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelab.dao.LoginDAO;
import com.bridgelab.model.LoginBean;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("inside view");
		response.setContentType("text/html");
		String category = request.getParameter("category");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Books List</h1>");
		List<LoginBean> list = LoginDAO.getAllBooks(category);
		printWriter.print("<table border='1' width='100%'");
		printWriter.print("<tr><th>Book_title</th><th>Author</th><th>Category</th><th>Price</th><th>Edit</th><th>Delete</th></tr>");

		for(LoginBean loginBean:list)
		{
			printWriter.print("<tr><td>"+loginBean.getBook_title()+"</td><td>"+loginBean.getAuthor()+"</td><td>"+loginBean.getCategory()+"</td><td>"+loginBean.getPrice()+"</td><td><a href='EditServlet1?id="+loginBean.getId()+"'>edit</a></td><td><a href='DeleteBook?id="+loginBean.getId()+"'>delete</a></td></tr>"); 
			
		}
		printWriter.print("</table>");
		//printWriter.close();
	}
	

}
