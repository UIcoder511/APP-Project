package com.org.concordia.photoapi.gateways;

import com.org.concordia.photoapi.model.Photo;

import java.sql.ResultSet;
import java.util.List;

public interface PhotoGateway {
  public List<Photo> getPhotos();

  public List<Photo> getUserFavouritePhotos(int userId);

  public List<Photo> getUserLikedPhotos(int userId);

  public List<Photo> getPhotos(int photoId);

  public int getNoOfLikesOfPhoto(int photoId);

  public void addUserLikedPhotos(int userId, int photoId);

  public void addUserFavPhotos(int userId, int photoId);

  public void removeUserLikedPhotos(int userId, int photoId);

  public void removeUserFavPhotos(int userId, int photoId);
  
  public ResultSet getPhotos1();

  public ResultSet getUserFavouritePhotos1(int userId);

  public ResultSet getUserLikedPhotos1(int userId);

  public ResultSet getPhotos1(int photoId);
}
