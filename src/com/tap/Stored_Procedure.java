package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Stored_Procedure {

	final static Scanner scan=new Scanner(System.in);
	private static Connection connection;
	private static CallableStatement prepareCall;

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		 String username="root";
		 String password="root";
		 
		 
		 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection=DriverManager.getConnection(url,username,password);
					
					prepareCall=connection.prepareCall("{ call employee_count(?,?)}");
					
					prepareCall.setString(1, scan.next());
					prepareCall.registerOutParameter(2, Types.INTEGER);
					prepareCall.execute();
					int res=prepareCall.getInt(2);
					System.out.println(res);
					
					
					
					
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 

	}

}
