	package com.tap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Programe1 {

	public static void DisplayEmployee(Connection connection) throws SQLException {
		Statement statement = null;
		ResultSet res = null;
		try {
			statement = connection.createStatement();
			res = statement.executeQuery("SELECT * from employee");
			while(res.next())
			{
				System.out.println(res.getInt("id")+","+ 
					res.getString("name") + "," +
					res.getString("email") + "," +
					res.getString("department")+ "," +
					res.getInt("salary"));
			}
		} finally {
			// Always close resources
			if(res != null) res.close();
			if(statement != null) statement.close();
		}
	}
}
