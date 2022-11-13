package com.org.concordia.photoapi.dao;

import com.org.concordia.photoapi.model.Photo;
import java.util.List;

public interface PhotosDao {
  public List<Photo> getPhotos();

  public Photo getPhotoById(int photoId);

  public List<Photo> getUserFavouritePhotos(int userId);

  public List<Photo> getUserLikedPhotos(int userId);

  public int getNoOfLikesOfPhoto(int photoId);

  public void addUserLikedPhotos(int userId, int photoId);

  public void addUserFavPhotos(int userId, int photoId);

  public void removeUserLikedPhotos(int userId, int photoId);

  public void removeUserFavPhotos(int userId, int photoId);
}
