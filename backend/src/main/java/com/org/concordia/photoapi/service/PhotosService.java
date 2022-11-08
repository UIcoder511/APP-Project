package com.org.concordia.photoapi.service;

import com.org.concordia.photoapi.model.Photo;
import java.util.List;

public interface PhotosService {
  public List<Photo> getPhotos();

  public List<Photo> getUserFavouritePhotos(int userId);

  public List<Photo> getUserLikedPhotos(int userId);

  public List<Photo> getPhotos(int photoId);

  public int getNoOfLikesOfPhoto(int photoId);

  public void addUserLikedPhotos(int userId, int photoId);

  public void addUserFavPhotos(int userId, int photoId);

  public void removeUserLikedPhotos(int userId, int photoId);

  public void removeUserFavPhotos(int userId, int photoId);
}
