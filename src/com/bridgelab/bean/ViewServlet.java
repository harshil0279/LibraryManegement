package com.bridgelab.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Books List</h1>");
		List<LoginBean> list = LoginDAO.getAllBooks();
		printWriter.print("<table border='1' width='100%'");
		printWriter.print("<tr><th>Book_title</th><th>Author</th><th>Category</th><th>Price</th></tr>");

		for(LoginBean loginBean:list)
		{
			printWriter.print("<tr><td>"+loginBean.getBook_title()+"</td><td>"+loginBean.getAuthor()+"</td><td>"+loginBean.getCategory()+"</td><td>"+loginBean.getPrice()+"</td></tr>"); 
			
		}
		printWriter.print("</table>");
		printWriter.close();
	}

}
