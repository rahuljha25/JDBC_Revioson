package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Programe7_BatchFile
{

	private static Connection connection;
	private static PreparedStatement pstmt;
	private final static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) 
	{
		String url = "jdbc:mysql://localhost:3306/jdbc_class";
		String username = "root";
		String password = "root";
		String sql = "INSERT into employee(id,name,email,department,salary) values (?,?,?,?,?)";

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);

			// Display before insert
			Programe1.DisplayEmployee(connection);

			pstmt = connection.prepareStatement(sql);
			
			String choice=null;
			do {
				
				System.out.println("Enter id:");
				pstmt.setInt(1, scan.nextInt());

				System.out.println("Enter name:");
				pstmt.setString(2, scan.next());

				System.out.println("Enter email:");
				pstmt.setString(3, scan.next());

				System.out.println("Enter Department:");
				pstmt.setString(4, scan.next());

				System.out.println("Enter salary:");
				pstmt.setInt(5, scan.nextInt());

				pstmt.addBatch();
				
				//System.out.println("Inserted rows: " + i);
				
				System.out.println("Do You Want Enter More Employee Data?(Yes/No)");
				choice=scan.next();
			}
			while(choice.equalsIgnoreCase("Yes"));
			
			int []arr=pstmt.executeBatch();
			for(int i:arr)
			{
				System.out.println(i);
			}
			
			// Display after insert
			Programe1.DisplayEmployee(connection);

		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		  {
			try 
			{
				if (pstmt != null) pstmt.close();
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
