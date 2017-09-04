package com.bridgelab.bean;  
import java.sql.*;

import com.bridgelab.bean.LoginBean; 
public class LoginDAO 
{  
	
	public static int status;

	
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

	public static boolean validate(LoginBean bean) 
			throws ClassNotFoundException, SQLException
	{  
		boolean status=false;  
		Connection con = null;
		System.out.println("Inside bean");
		try
		{  
			Class.forName(Provider.DRIVER);
			con=DriverManager.getConnection(Provider.CONNECTION_URL, Provider.USERNAME, Provider.PASSWORD);
			System.out.println("connection opened");

			PreparedStatement ps=con.prepareStatement(  
					"select * from userData where email=? and password=?");
			System.out.println("ps created");

			ps.setString(1,bean.getEmail());  
			ps.setString(2, bean.getPassword());  

			ResultSet rs=ps.executeQuery();
			System.out.println("statement executed");
			status=rs.next();
			System.out.println("status: "+status);

		}
		finally 
		{
			if(con!= null)
				con.close();
		}

		return status;  

	}  
	
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
	
	public static int saveBookData(LoginBean loginbean)
	{
		int status = 0;
		try
		{
			Connection connection = LoginDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into book_details"
					+ "(book_title,author,category,price)values(?,?,?,?)");
			ps.setString(1, loginbean.getBook_title());
			ps.setString(2,loginbean.getAuthor());
			ps.setString(3,loginbean.getCategory());
			ps.setString(4,loginbean.getPrice());
			
			status = ps.executeUpdate();
			connection.close();
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
}  