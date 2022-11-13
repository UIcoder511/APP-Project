package com.org.concordia.photoapi.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.org.concordia.photoapi.util.DBConnect;

public class UserMapperImpl implements UserMapper {

	private static Connection conn = DBConnect.getDBConnection();

	@Override
	public int getUserIdByUsername(String username) {
		int userId = -1;
		Statement stmt;

		try {
			stmt = conn.createStatement();
			String userIdSql = "SELECT user_id FROM Users where username='" + username + "'";

			ResultSet rs = stmt.executeQuery(userIdSql);
			while (rs.next()) {
				userId = rs.getInt("user_id");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userId;
	}

	@Override
	public String getPasswordByUsername(String username) {
		String password = "";
		Statement stmt;

		try {
			stmt = conn.createStatement();
			String passwordSql = "SELECT password FROM Users where username='" + username + "'";

			ResultSet rs = stmt.executeQuery(passwordSql);
			while (rs.next()) {
				password = rs.getString("password");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return password;
	}

	@Override
	public boolean addUser(String username, String password) {
		try {
			String addUserSql = "INSERT INTO Users(username,password) values(?,?)" ;

			PreparedStatement pstmt = conn.prepareStatement(addUserSql);
			pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            
            return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
