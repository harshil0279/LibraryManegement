package com.bridgelab.dao;  

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 13/09/2017
 * Purpose   : It contains all the methods to save,insert and update the book data.
 *             
 **/
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bridgelab.controller.Provider;
import com.bridgelab.model.LoginBean;



public class LoginDAO 
{  
	
	public static int status;

	
	/**
	 * @return connectionObject
	 * @ It is used to create new connection.
	 */
	public static Connection getConnection()
	{
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/users","root","root");
		}
		catch(Exception LoginBean)
		{
			System.out.println(LoginBean);
		}
		return connection;
	}

	/**
	 * @param beanObject
	 * @return status
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @ It is used to validate email-id and password of user
	 */
	public static int validate(LoginBean bean) 
			throws ClassNotFoundException, SQLException
	{  
		boolean status=false;  
		Connection con = null;
		System.out.println("Inside bean");
		int user_id= -1;
		try
		{  
			Class.forName(Provider.DRIVER);
			con=DriverManager.getConnection(Provider.CONNECTION_URL, Provider.USERNAME, Provider.PASSWORD);
			System.out.println("connection opened");

			PreparedStatement ps=con.prepareStatement(  
					"select * from use_details where email=? and password=?");
			
            System.out.println("Email " + bean.getPassword());
			ps.setString(1,bean.getEmail());  
			ps.setString(2, bean.getPassword()); 
			//fetch = rs.getInt("user_id");
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next()){
		
				user_id = rs.getInt("user_id");
				System.out.println("USER_id is"+user_id);
				System.out.println("statement executed");
				status=rs.next();
				System.out.println("status: "+status);
			}
		
		}
		finally 
		{
			if(con!= null)
				con.close();
		}

		return user_id	;  

	}  
	
	/**
	 * @param loginbean
	 * @return status
	 * @ it saves the user data into database
	 */
	public static int save(LoginBean loginbean)
	{
		int status=0;
		try
		{
			Connection con=LoginDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into use_details(name,password,email,mobileNumber"
					+ ",gender)"
					+ " values (?,?,?,?,?)");
			ps.setString(1,loginbean.getName());
			ps.setString(2,loginbean.getPassword());
			ps.setString(3,loginbean.getEmail());
			ps.setString(4,loginbean.getMobileNumber());
			ps.setString(5,loginbean.getGender());

			status=ps.executeUpdate();

			con.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return status;
	}
	
	/**
	 * @param loginbeanObject
	 * @return status
	 * @ it saves the book datails into database
	 */
	public static int saveBookData(LoginBean loginbean)
	{
		int status = 0;
		try
		{
			Connection connection = LoginDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into book_details"
					+ "(book_title,author,category,price,name,user_id)values(?,?,?,?,?,?)");
			ps.setString(1, loginbean.getBook_title());
			ps.setString(2,loginbean.getAuthor());
			ps.setString(3,loginbean.getCategory());
			ps.setInt(4,loginbean.getPrice());
			ps.setString(5,loginbean.getEmail());
			ps.setInt(6, loginbean.getUser_id());
			
			status = ps.executeUpdate();
			connection.close();
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	
	/**
	 * @param input id
	 * @return loginBeanObject
	 * @ It fetch the book datails according by its id    
	 */
	public static LoginBean getBookByID(int id)
	{
		LoginBean loginBean = new LoginBean();
		
		try
		{
			Connection con = LoginDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book_details"
					+ " where book_id=? ");
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				loginBean.setBook_id(rs.getInt(1));
				loginBean.setBook_title(rs.getString(2));
				loginBean.setAuthor(rs.getString(3));
				loginBean.setCategory(rs.getString(4));
				loginBean.setEmail(rs.getString(5));
				loginBean.setPrice(rs.getInt(6));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return loginBean;
	}
	
	
	/**
	 * @param input category
	 * @return listObject
	 * @ It fetch the book details according to its id.
	 */
	public static List<LoginBean> getAllBooks(String category,int user_id)
	{
		List<LoginBean> list=new ArrayList<LoginBean>();

		try
		{    
			
			Connection con=LoginDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from book_details where category=? and user_id=?");
		    ps.setString(1,category);
		    ps.setInt(2, user_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			     LoginBean loginBean = new LoginBean();
			     loginBean.setBook_id(rs.getInt(1));
			     loginBean.setBook_title(rs.getString(2));
			     loginBean.setAuthor(rs.getString(3));
			     loginBean.setCategory(rs.getString(4));
			     loginBean.setPrice(rs.getInt(6));
				list.add(loginBean);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}

		return list;
	}
	
	/**
	 * @param input id
	 * @return status
	 * @ It delete the book details according to its id
	 */
	public static int delete (int id)
	{
		int status = 0;
		try
		{
			Connection con=LoginDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from book_details where book_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	
	/**
	 * @param loginBeanObject
	 * @return status
	 * @ It update the book details into database
	 */
	public static int update(LoginBean loginBean)
	{
		System.out.println("book id " + loginBean.getBook_id());
		int status=0;
		try
		{
			Connection con=LoginDAO.getConnection();
			PreparedStatement preparetatement=con.prepareStatement
					("update book_details set book_title=?,author=?,category=?,price=? where book_id=?");
			System.out.println("booktilte"+loginBean.getAuthor());
			preparetatement.setString(1,loginBean. getBook_title());
			preparetatement.setString(2,loginBean.getAuthor());
			preparetatement.setString(3,loginBean.getCategory());
			preparetatement.setInt(4,loginBean.getPrice());
			preparetatement.setInt(5,loginBean.getBook_id());
			
			status = preparetatement.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	
	
}  