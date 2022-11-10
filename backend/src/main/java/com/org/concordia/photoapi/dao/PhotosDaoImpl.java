package com.org.concordia.photoapi.dao;

import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.Photographer;
import com.org.concordia.photoapi.util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhotosDaoImpl implements PhotosDao {

  private static Connection conn = DBConnect.getDBConnection();

  //	private static List<Photo> listOfPhotos = new ArrayList<Photo>();

  @Override
  public List<Photo> getPhotos() {
    List<Photo> listOfPhotos;

    String photosSQL =
      "SELECT * FROM Photos p INNER JOIN Photographer ph ON p.photographer_id = ph.photographer_id";

    listOfPhotos = getListOfPhotosByQuery(photosSQL);

    return listOfPhotos;
  }

  @Override
  public List<Photo> getPhotos(int photoId) {
    List<Photo> listOfPhotos;

    String photosSQL =
      "SELECT * FROM Photos p INNER JOIN Photographer ph ON p.photographer_id = ph.photographer_id and p.photo_id='" +
      photoId +
      "'";

    listOfPhotos = getListOfPhotosByQuery(photosSQL);

    return listOfPhotos;
  }

  @Override
  public List<Photo> getUserFavouritePhotos(int userId) {
    List<Photo> listOfPhotos;

    String favSQL =
      "SELECT * from Photos p, Favourites f where p.photo_id=f.photo_id and f.user_id='" +
      userId +
      "'";

    //      + "(SELECT p.* FROM Photos p, Favourites f where f.user_id='" +
    //      userId +
    //      "' and p.photo_id=f.photo_id";

    listOfPhotos = getListPhotosByLikesAndFavQuery(favSQL);

    return listOfPhotos;
  }

  @Override
  public List<Photo> getUserLikedPhotos(int userId) {
    List<Photo> listOfPhotos;

    String likesSQL =
      "SELECT * from Photos p, Likes l where p.photo_id=l.photo_id and l.user_id='" +
      userId +
      "'";

    //      "SELECT p.* FROM Photos p,Likes l where l.user_id='" +
    //      userId +
    //      "' and p.photo_id=l.photo_id ";

    listOfPhotos = getListPhotosByLikesAndFavQuery(likesSQL);

    return listOfPhotos;
  }

  private static List<Photo> getListOfPhotosByQuery(String sqlQuery) {
    Statement stmt;
    List<Photo> listOfPhotos = new ArrayList<Photo>();

    try {
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sqlQuery);
      while (rs.next()) {
        System.out.println(
          rs.getInt("photo_id") +
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
        //				photo.setPhotographerId(rs.getInt("photographer_id"));
        photo.setPhotographer(
          new Photographer(
            rs.getInt("photographer_id"),
            rs.getString("p_name"),
            rs.getString("p_url")
          )
        );
        photo.setAvgColor(rs.getString("avg_color"));
        photo.setTitle(rs.getString("title"));
        photo.setImageMediumSize(rs.getString("imageMediumSize"));
        photo.setImageLargeSize(rs.getString("imageLargeSize"));
        photo.setImageOrignalSize(rs.getString("imageOrignalSize"));

        listOfPhotos.add(photo);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      //    } finally {
      //      try {
      //        if (conn != null) {
      //          conn.close();
      //        }
      //      } catch (SQLException ex) {
      //        System.out.println(ex.getMessage());
      //      }
    }

    return listOfPhotos;
  }

  private static List<Photo> getListPhotosByLikesAndFavQuery(String sqlQuery) {
    Statement stmt;
    List<Photo> listOfPhotos = new ArrayList<Photo>();

    try {
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sqlQuery);
      System.out.println("-----------------------");
      while (rs.next()) {
        System.out.println(
          rs.getInt("photo_id") +
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

        listOfPhotos.add(photo);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      //    } finally {
      //      try {
      //        if (conn != null) {
      //          conn.close();
      //        }
      //      } catch (SQLException ex) {
      //        System.out.println(ex.getMessage());
      //      }
    }

    return listOfPhotos;
  }

  @Override
  public void addUserLikedPhotos(int userId, int photoId) {
    try {
      String addUserLikedSql =
        "INSERT INTO Likes(user_id,photo_id) values(?,?)";

      PreparedStatement pstmt = conn.prepareStatement(addUserLikedSql);
      pstmt.setInt(1, userId);
      pstmt.setInt(2, photoId);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void addUserFavPhotos(int userId, int photoId) {
    try {
      String addUserFavSql =
        "INSERT INTO Favourites(user_id,photo_id) values(?,?)";

      PreparedStatement pstmt = conn.prepareStatement(addUserFavSql);
      pstmt.setInt(1, userId);
      pstmt.setInt(2, photoId);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void removeUserLikedPhotos(int userId, int photoId) {
    Statement stmt;
    try {
      stmt = conn.createStatement();
      String removeUserLikedPhotosSql =
        "DELETE FROM Likes where user_id='" +
        userId +
        "' and  photo_id='" +
        photoId +
        "'";

      //change to executeUpdate
      stmt.executeQuery(removeUserLikedPhotosSql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void removeUserFavPhotos(int userId, int photoId) {
    Statement stmt;
    try {
      stmt = conn.createStatement();
      String removeUserFavSql =
        "DELETE FROM Favourites where user_id='" +
        userId +
        "' and  photo_id='" +
        photoId +
        "'";
      stmt.executeQuery(removeUserFavSql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public int getNoOfLikesOfPhoto(int photoId) {
    Statement stmt;
    int noOfLikes = 0;
    try {
      stmt = conn.createStatement();
      String noOfLikeOfPhotoSQL =
        "SELECT photo_id FROM likes where photo_id ='" + photoId + "'";
      ResultSet rs = stmt.executeQuery(noOfLikeOfPhotoSQL);
      while (rs.next()) {
        noOfLikes++;
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return noOfLikes;
  }
}
