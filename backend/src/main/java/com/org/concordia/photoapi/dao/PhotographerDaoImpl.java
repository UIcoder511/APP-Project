package com.org.concordia.photoapi.dao;

import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.util.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhotographerDaoImpl implements PhotographerDao {

  private static Connection conn = null;

  @Override
  public List<Photo> getPhotosByPhotographerName(String name) {
    List<Photo> listOfPhotosByPhotographerName = new ArrayList<Photo>();

    try {
      conn = DBConnect.getDBConnection();
      String photosByPhotographerNameSQL =
        "SELECT * FROM Photos p, Photographer pg where p.photographerId = pg.photographerId " +
        "and pg.p_name='" +
        name +
        "'";

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(photosByPhotographerNameSQL);
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

        Photo photo = new Photo();
        photo.setphotoId(rs.getInt("photoId"));
        photo.setphotographerId(rs.getInt("photographerId"));
        photo.setavgColor(rs.getString("avgColor"));
        photo.setTitle(rs.getString("title"));
        photo.setImageMediumSize(rs.getString("imageMediumSize"));
        photo.setImageLargeSize(rs.getString("imageLargeSize"));
        photo.setImageOrignalSize(rs.getString("imageOrignalSize"));

        listOfPhotosByPhotographerName.add(photo);
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

    return listOfPhotosByPhotographerName;
  }
}
	}
}
