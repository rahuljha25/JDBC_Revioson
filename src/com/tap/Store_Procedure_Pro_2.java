package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Store_Procedure_Pro_2 
{
	final static Scanner scan=new Scanner(System.in);
	private static Connection connection;
	private static CallableStatement prepareCall;

	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		 String username="root";
		 String password="root";
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url,username,password);
				prepareCall=connection.prepareCall("{call count_emp_salary(?)}");
				System.out.print("Enter salary threshold: ");
				prepareCall.setInt(1,scan.nextInt());
				prepareCall.registerOutParameter(1, Types.INTEGER);
				prepareCall.execute();
				int res=prepareCall.getInt(1);
				System.out.println(res);
				
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
