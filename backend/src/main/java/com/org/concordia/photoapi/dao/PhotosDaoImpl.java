package com.org.concordia.photoapi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.util.DBConnect;

public class PhotosDaoImpl implements PhotosDao {

	private static Connection conn = DBConnect.getDBConnection();
	private static List<Photo> listOfPhotos = new ArrayList<Photo>();

	@Override
	public List<Photo> getPhotos() {
		
		String photosSQL = "SELECT * FROM Photos";
			
		listOfPhotos = getListOfPhotosByQuery(photosSQL);

		return listOfPhotos;
	}

	@Override
	public List<Photo> getUserFavouritePhotos(int userId) {
		
		String favSQL = "SELECT p.* FROM Photos p, Favourites f where f.user_id='"+userId+"' and p.photo_id=f.photo_id";

		listOfPhotos = getListOfPhotosByQuery(favSQL);
			
		return listOfPhotos;
	}

	@Override
	public List<Photo> getUserLikedPhotos(int userId) {
	  
	   String likesSQL = "SELECT p.* FROM Photos p,Likes l where l.user_id='"+userId+"' and p.photo_id=l.photo_id ";
	   
	   listOfPhotos = getListOfPhotosByQuery(likesSQL);

	    return listOfPhotos;
	}
	
	private static List<Photo>  getListOfPhotosByQuery(String sqlQuery)
	{
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				System.out.println(
						rs.getInt("photo_id") + "\t" + rs.getInt("photographer_id") + "\t" + rs.getString("avg_color")
								+ "\t" + rs.getString("title") + "\t" + rs.getString("imageMediumSize") + "\t"
								+ rs.getString("imageLargeSize") + "\t" + rs.getString("imageOrignalSize") + "\t");

				Photo photo = new Photo();
				photo.setPhoto_id(rs.getInt("photo_id"));
				photo.setPhotographer_id(rs.getInt("photographer_id"));
				photo.setAvg_color(rs.getString("avg_color"));
				photo.setTitle(rs.getString("title"));
				photo.setImageMediumSize(rs.getString("imageMediumSize"));
				photo.setImageLargeSize(rs.getString("imageLargeSize"));
				photo.setImageOrignalSize(rs.getString("imageOrignalSize"));

				listOfPhotos.add(photo);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
		
		return listOfPhotos;
		
	}

	@Override
	public int getUserIdByUsername(String username) {
		
		int userId = -1;
		Statement stmt;
		
		try {
			stmt = conn.createStatement();
			String userIdSql = "SELECT user_id FROM Users where username='"+username+"'";
			
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
			String passwordSql = "SELECT password FROM Users where username='"+username+"'";
			
			ResultSet rs = stmt.executeQuery(passwordSql);
			while (rs.next()) {
				password = rs.getString("password");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
		return password;
	}
}
