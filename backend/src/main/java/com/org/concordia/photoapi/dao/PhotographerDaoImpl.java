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
        "SELECT * FROM Photos p, Photographer pg where p.photographer_id = pg.photographer_id " +
        "and pg.p_name='" +
        name +
        "'";

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(photosByPhotographerNameSQL);
      while (rs.next()) {
        System.out.println(
          rs.getInt("photo_id") +
          "\t" +
          rs.getInt("photographer_id") +
          "\t" +
          rs.getString("avg_color") +
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
        photo.setPhotoId(rs.getInt("photo_id"));
        photo.setPhotographerId(rs.getInt("photographer_id"));
        photo.setAvgColor(rs.getString("avg_color"));
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
