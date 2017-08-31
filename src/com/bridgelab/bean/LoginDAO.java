package com.bridgelab.bean;  
import java.sql.*;  
public class LoginDAO 
{  

	public static boolean validate(LoginBean bean) 
			throws ClassNotFoundException, SQLException{  
		boolean status=false;  
		Connection con = null;
		System.out.println("Inside bean");
		try{  
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
		finally {
			if(con!= null)
			con.close();
		}

		return status;  

	}  
}  