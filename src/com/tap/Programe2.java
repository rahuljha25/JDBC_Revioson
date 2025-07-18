package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Programe2 {

	private static Connection connection;
	private static Statement statement;

	public static void main(String[] args) 
	{
		
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		 String username="root";
		 String password="root";
		 String sql="Insert into employee" 
		 + "(id,name,email,department,salary) values "
		 + "(5,'beta','beta123@gmail.com','Schoolling',1000)";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,username,password);
		statement=connection.createStatement();
		 
		int i=statement.executeUpdate(sql);
		System.out.println(i);
		
	
		
	
	} 
	
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
