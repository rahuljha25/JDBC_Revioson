package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Acid_Properties {
	 static final Scanner scan=new Scanner(System.in);
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_class";
	private static final String username = "root";
	private static final String password = "root";
	private static Connection connection;
	private static PreparedStatement statement;

	public static void main(String[] args)
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, username, password);
			
			Programe1.DisplayEmployee(connection);
			
			connection.setAutoCommit(false);
			
			transaction();
			
			System.out.println("\n\n");
			
			Programe1.DisplayEmployee(connection);
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void transaction() throws SQLException
	{


		System.out.println("Enter sender:");
		String sender=scan.next();
		
		System.out.println("Enter Receiver:");
		String receiver=scan.next();
		
		System.out.println("Enter Amount:");
		int amount=scan.nextInt();
		
		int x=updateBalance(sender,- amount);
		int y=updateBalance(receiver,amount);
		
		if(isConfirm(x,y))
		{
			System.out.println("Transaction successfully......");
			connection.commit();
		}
		else
		{
			System.out.println("Transaction failed......");
			connection.rollback();
		}
		
		System.out.println(x + " : " + y);
		
		
		
	}

	private static boolean isConfirm(int x, int y) 
	{
		
		System.out.println("Do you want this transaction ?(yes/no)");
		String choice=scan.next();
		return choice.equalsIgnoreCase("Yes") && x==1 && y==1;
	}

	private static int updateBalance(String user, int amount) throws SQLException
	{
		String sql="UPDATE employee SET salary =salary + ? WHERE name=? ";
		 statement=connection.prepareStatement(sql);
		 statement.setInt(1, amount);
		 statement.setString(2,user);
		 
		 int i=statement.executeUpdate();
		 return i;
		
		
	}

}
