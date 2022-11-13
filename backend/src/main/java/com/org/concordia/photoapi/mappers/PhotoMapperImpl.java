package com.org.concordia.photoapi.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.concordia.photoapi.gateways.PhotoGateway;
import com.org.concordia.photoapi.gateways.PhotoGatewayImpl;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.Photographer;

public class PhotoMapperImpl implements PhotoMapper {
	
  private PhotoGateway photosGateway = new PhotoGatewayImpl();

  @Override
  public List<Photo> getPhotos() {
    List<Photo> listOfPhotos;
    ResultSet rs  = photosGateway.getPhotos1();
    
    listOfPhotos = getListOfPhotos(rs);
    		
    return listOfPhotos;
  }

  @Override
  public List<Photo> getPhotos(int photoId) {
    List<Photo> listOfPhotos;
    ResultSet rs  = photosGateway.getPhotos1(photoId);
    
    listOfPhotos = getListOfPhotos(rs);

    return listOfPhotos;
  }

  @Override
  public List<Photo> getUserFavouritePhotos(int userId) {
    List<Photo> listOfPhotos;

    ResultSet rs = photosGateway.getUserFavouritePhotos1(userId);
    
    listOfPhotos = getListPhotosByLikesAndFavQuery(rs);

    return listOfPhotos;
  }

  @Override
  public List<Photo> getUserLikedPhotos(int userId) {
    List<Photo> listOfPhotos;

    ResultSet rs = photosGateway.getUserLikedPhotos1(userId);
    
    listOfPhotos = getListPhotosByLikesAndFavQuery(rs);

    return listOfPhotos;
  }

  private static List<Photo> getListOfPhotos(ResultSet rs) {
	  
	  List<Photo> listOfPhotos = new ArrayList<Photo>();
	  
	  try
	  {
        Photo photo = new Photo();
        photo.setPhotoId(rs.getInt("photo_id"));
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
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return listOfPhotos;
  }

  private static List<Photo> getListPhotosByLikesAndFavQuery(ResultSet rs) {
    List<Photo> listOfPhotos = new ArrayList<Photo>();

    try {
	        Photo photo = new Photo();
	        photo.setPhotoId(rs.getInt("photo_id"));
	        photo.setPhotographerId(rs.getInt("photographer_id"));
	        photo.setAvgColor(rs.getString("avg_color"));
	        photo.setTitle(rs.getString("title"));
	        photo.setImageMediumSize(rs.getString("imageMediumSize"));
	        photo.setImageLargeSize(rs.getString("imageLargeSize"));
	        photo.setImageOrignalSize(rs.getString("imageOrignalSize"));
	
	        listOfPhotos.add(photo);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return listOfPhotos;
  }
}
