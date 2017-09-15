package com.bridgelab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelab.dao.LoginDAO;
import com.bridgelab.model.LoginBean;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);  
        String user_id1=(String)session.getAttribute("user_id");  
        int user_id = Integer.parseInt(user_id1);
		System.out.println("inside view");
		response.setContentType("text/html");
		String category = request.getParameter("category");
		//int user_id =Integer.parseInt("request.getParameter(user_id1)");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Books List</h1>");
		List<LoginBean> list = LoginDAO.getAllBooks(category,user_id);
		printWriter.print("<table border='1' width='100%'");
		printWriter.print("<tr><th>Book_title</th><th>Author</th><th>Category</th><th>Price</th></tr>");

		for(LoginBean loginBean:list)
		{
			
			System.out.println("IM=NSIDE LOGINBEAN LOOP"+loginBean);
			printWriter.print("<tr><td>"+loginBean.getBook_title()+"</td><td>"+
										 loginBean.getAuthor()+"</td><td>"+
										 loginBean.getCategory()+"</td><td>"+
										 loginBean.getPrice()+"</td><td><a class='edit-class' href='#' id='EditServlet1?book_id="+
										 loginBean.getBook_id()+"'>edit</a></td><td><a class='delete-class'  href='#' id='DeleteBook?book_id="+
										 loginBean.getBook_id()+"'>delete</a></td></tr>"); 
			
		}
		printWriter.print("</table>");
		printWriter.close();
	}
	

}
