package com.trms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
private static String url;
	
	private static String username;
	
	private static String password;
	
	private static final String DB_NAME = "postgres";
	
	private static ConnectionFactory cf;
	
	ConnectionFactory() {
		url = System.getenv("URL");
		url = "jdbc:postgresql://" + url + ":5432/" + DB_NAME + "?";
		username = System.getenv("username");
		password = System.getenv("password");
		
	}
	
	private Connection createConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Unable to make connection");
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static Connection getConnection() {
		
		if (cf == null) {
			cf = new ConnectionFactory();
		}
		
		return cf.createConnection();
		
	}

}
