package com.curdoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseConnection 
{
	public static Connection getConnection() 
	{
		Connection con= null;
		try 
		{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
		}
		catch(Exception e) 
		{
			 System.out.println(e);
			 return con; 
		}
		return con;
		
		public static <Emp> int save(Emp e) 
		{
			 int status=0;  
			 try 
			 {
				 Connection con=DataBaseConnection.getConnection();  
		            PreparedStatement ps=con.prepareStatement(  
		                         "insert into user905(name,password,email,country) values (?,?,?,?)");  
		            ps.setString(1,e.getName());  
		            ps.setString(2,e.getPassword());  
		            ps.setString(3,e.getEmail());  
		            ps.setString(4,e.getCountry());  
		              
		            status=ps.executeUpdate();  
		              
		            con.close();   
			 }
			 catch(Exception e) 
			 {
				 System.out.println(e);
			 }
			 return status; 
			 public static  int update(Emp e){  
			        int status=0;  
			        try{  
			            Connection con=DataBaseConnection.getConnection();  
			            PreparedStatement ps=con.prepareStatement(  
			                         "update user905 set name=?,password=?,email=?,country=? where id=?");  
			            ps.setString(1,e.getName());  
			            ps.setString(2,e.getPassword());  
			            ps.setString(3,e.getEmail());  
			            ps.setString(4,e.getCountry());  
			            ps.setInt(5,e.getId());  
			              
			            status=ps.executeUpdate();  
			              
			            con.close();  
			        }catch(Exception ex){ex.printStackTrace();}  
			          
			        return status;  
		  
	}
}
