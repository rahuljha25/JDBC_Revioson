
package com.tap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Programe4_Delete {

	public static void main(String[] args) 
	{
		String url = "jdbc:mysql://localhost:3306/jdbc_class";
		String username = "root";
		String password = "root";
		String sql = "DELETE FROM employee WHERE id = 4";

		try {
			// Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Get connection
			try (Connection connection = DriverManager.getConnection(url, username, password);
			     Statement statement = connection.createStatement()) {
				
				// Execute DELETE
				int i = statement.executeUpdate(sql);
				System.out.println("Rows deleted: " + i);
				
			} // Auto closes connection & statement
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
