package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	private static final String DB_URL = "jdbc:mysql://localhost/Data";
    private static final String USER = "root";
    private static final String PASS = "root";
	public static Connection getConnection() {
		try {
//			load & register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded...");
			
//			Establish connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Act","root","root");
			System.out.println("Connection established...");
			return con;
		}
		catch(SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}


}
