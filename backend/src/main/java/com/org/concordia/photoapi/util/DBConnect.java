package com.org.concordia.photoapi.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//use of Singleton Design Pattern to create DB connection
public class DBConnect {

  private static Connection conn = null;

  // create a singleton connection
  static {
    try {
      // get the relative path of DB file
      Path currentRelativePath = Paths.get("");
      String dbRelativePath =
        currentRelativePath.toAbsolutePath().toString() +
        "\\resources\\photos.db";
      String url = "jdbc:sqlite:" + dbRelativePath;
      System.out.println(url);
      // create a connection to the database
      conn = DriverManager.getConnection(url);

      System.out.println("Connection to SQLite has been established.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Connection getDBConnection() {
    return conn;
  }
}
