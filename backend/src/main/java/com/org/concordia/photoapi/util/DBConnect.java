package com.org.concordia.photoapi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static Connection conn = null;
	private static final String url = "jdbc:sqlite:C:\\sqlite\\photos.db";
	
	public static Connection getDBConnection() {
		
		try {
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}

}
