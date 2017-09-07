package com.bridgelab.dao;  
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bridgelab.controller.Provider;
import com.bridgelab.model.LoginBean;

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
					+ "(book_title,author,category,price,name)values(?,?,?,?,?)");
			ps.setString(1, loginbean.getBook_title());
			ps.setString(2,loginbean.getAuthor());
			ps.setString(3,loginbean.getCategory());
			ps.setDouble(4,loginbean.getPrice());
			ps.setString(5,loginbean.getEmail());
			
			status = ps.executeUpdate();
			connection.close();
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	

	
	
	public static List<LoginBean> getAllBooks(String category)
	{
		List<LoginBean> list=new ArrayList<LoginBean>();

		try
		{
			Connection con=LoginDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from book_details where category=?");
		    ps.setString(1,category);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			     LoginBean loginBean = new LoginBean();
			     loginBean.setBook_title(rs.getString(2));
			     loginBean.setAuthor(rs.getString(3));
			     loginBean.setCategory(rs.getString(4));
			     loginBean.setPrice(rs.getDouble(5));
				list.add(loginBean);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}

		return list;
	}
	
	public static int delete (int id)
	{
		int status = 0;
		try
		{
			Connection con=LoginDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from book_details where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
}  