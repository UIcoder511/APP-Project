package com.org.concordia.photoapi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.util.DBConnect;

public class PhotosDaoImpl implements PhotosDao{
	
	private static Connection conn = null;
	
	@Override
	public List<Photo> getPhotos() {
		List<Photo> listOfPhotos = new ArrayList<Photo>();
		
		try
		{
			conn = DBConnect.getDBConnection();
			String photosSQL = "SELECT * FROM Photos";
			
			Statement stmt  = conn.createStatement();  
	        ResultSet rs    = stmt.executeQuery(photosSQL); 
	        while (rs.next()) {  
	            System.out.println(rs.getInt("photo_id") +  "\t" +  
	            	   rs.getInt("photographer_id")+ "\t"+
      				   rs.getString("avg_color") + "\t" +
      				   rs.getString("title") + "\t" +
      				   rs.getString("imageMediumSize") + "\t" +
      				   rs.getString("imageLargeSize") + "\t" +
      				   rs.getString("imageOrignalSize") + "\t");  
	            
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
        }
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
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

}
