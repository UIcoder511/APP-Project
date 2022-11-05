package com.org.concordia.photoapi.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONReader {

  private final String resourceName = ".\\resources\\photos.json";
  private static Connection conn = null;

  public void selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM Photos";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
      System.out.println(
        rs.getInt("photoId") +
        "\t" +
        rs.getInt("photographerId") +
        "\t" +
        rs.getString("avgColor") +
        "\t" +
        rs.getString("title") +
        "\t" +
        rs.getString("imageMediumSize") +
        "\t" +
        rs.getString("imageLargeSize") +
        "\t" +
        rs.getString("imageOrignalSize") +
        "\t"
      );
    }

    String sql1 = "SELECT * FROM Photographer";
    Statement stmt1 = conn.createStatement();
    ResultSet rs1 = stmt1.executeQuery(sql1);
    while (rs1.next()) {
      System.out.println(
        rs1.getInt("photographerId") +
        "\t" +
        rs1.getString("p_name") +
        "\t" +
        rs1.getString("p_url")
      );
    }
  }

  public static void insertDataIntoDB(
    int photoId,
    int photographerId,
    String avgColor,
    String title,
    String imageMediumSize,
    String imageLargeSize,
    String imageOrignalSize
  ) throws SQLException {
    String photosSql =
      "INSERT INTO Photos(photoId,photographerId,avgColor,title,imageMediumSize,imageLargeSize,imageOrignalSize) VALUES(?,?,?,?,?,?,?)";

    try (PreparedStatement pstmt = conn.prepareStatement(photosSql)) {
      pstmt.setInt(1, photoId);
      pstmt.setInt(2, photographerId);
      pstmt.setString(3, avgColor);
      pstmt.setString(4, title);
      pstmt.setString(5, imageMediumSize);
      pstmt.setString(6, imageLargeSize);
      pstmt.setString(7, imageOrignalSize);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    //		String photographerSql = "INSERT INTO Photographer(photographerId,p_name,p_url) VALUES(?,?,?)";
    //		try (PreparedStatement pstmt = conn.prepareStatement(photographerSql)) {
    //            pstmt.setInt(1, photographerId);
    //            pstmt.setString(2, photographer_name);
    //            pstmt.setString(3, photographer_url);
    //            pstmt.executeUpdate();
    //        } catch (SQLException e) {
    //            System.out.println(e.getMessage());
    //        }
  }

  public void parse() throws JSONException, SQLException {
    FileReader fr = null;

    try {
      fr = new FileReader(new File(resourceName));
    } catch (FileNotFoundException e) {
      System.out.println("Cannot find resource file " + resourceName);
    }

    JSONTokener tokener = new JSONTokener(fr);
    JSONObject jsonObject = new JSONObject(tokener);

    System.out.println(jsonObject);

    JSONArray jsonArray = (JSONArray) jsonObject.get("photos");

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject photosObject = jsonArray.getJSONObject(i);

      int photoId = Integer.parseInt(photosObject.get("id").toString());
      int photographerId = Integer.parseInt(
        photosObject.get("photographerId").toString()
      );
      String avgColor = photosObject.get("avgColor").toString();
      String title = photosObject.get("title").toString();
      String imageMediumSize = photosObject.get("imageMediumSize").toString();
      String imageLargeSize = photosObject.get("imageLargeSize").toString();
      String imageOrignalSize = photosObject.get("imageOrignalSize").toString();
      //        	String photographer_name = photosObject.get("photographer").toString();
      //        	String photographer_url = photosObject.get("photographer_url").toString();

      //insertDataIntoDB(photoId,width,height,liked,photographerId,photographer_name,photographer_url);
      insertDataIntoDB(
        photoId,
        photographerId,
        avgColor,
        title,
        imageMediumSize,
        imageLargeSize,
        imageOrignalSize
      );
    }
  }

  public static void main(String[] args) throws JSONException {
    //establish connection with DB
    JSONReader jsonReader = new JSONReader();

    try {
      conn = DBConnect.getDBConnection();
      JSONReader jsonreader = new JSONReader();

      //read json
      jsonReader.parse();

      //execute select query
      jsonreader.selectAll(conn);
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
  }
}
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
	}

	public void parse() throws JSONException, SQLException
	{
		FileReader fr = null;
		
		try
		{
			fr = new FileReader(new File(resourceName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find resource file " + resourceName);
		}

	    JSONTokener tokener = new JSONTokener(fr);
        JSONObject jsonObject = new JSONObject(tokener);
        
        System.out.println(jsonObject);

        
        JSONArray jsonArray = (JSONArray) jsonObject.get("photos");
        
        for(int i=0;i<jsonArray.length();i++)
        {
        	JSONObject photosObject = jsonArray.getJSONObject(i);
        	
        	int photoId = Integer.parseInt(photosObject.get("id").toString());
        	int photographerId = Integer.parseInt(photosObject.get("photographerId").toString());
        	String avgColor = photosObject.get("avgColor").toString();
        	String title = photosObject.get("title").toString();
        	String imageMediumSize = photosObject.get("imageMediumSize").toString();
        	String imageLargeSize = photosObject.get("imageLargeSize").toString();
        	String imageOrignalSize = photosObject.get("imageOrignalSize").toString();
//        	String photographer_name = photosObject.get("photographer").toString();
//        	String photographer_url = photosObject.get("photographer_url").toString();
        	
        	//insertDataIntoDB(photoId,width,height,liked,photographerId,photographer_name,photographer_url);
        	insertDataIntoDB(photoId,photographerId,avgColor,title,imageMediumSize,imageLargeSize,imageOrignalSize);
        }
        
	}
	
	public static void main(String[] args) throws JSONException{
		
		//establish connection with DB
		JSONReader jsonReader = new JSONReader();
		
		try
		{
			
			conn = DBConnect.getDBConnection();
			JSONReader jsonreader = new JSONReader();
			
			//read json
			jsonReader.parse();
			
			//execute select query
			jsonreader.selectAll(conn);
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
	}

}
