package com.org.concordia.photoapi.service;

import com.org.concordia.photoapi.dao.PhotosDao;
import com.org.concordia.photoapi.dao.PhotosDaoImpl;
import com.org.concordia.photoapi.model.Photo;
import java.util.List;

public class PhotosServiceImpl implements PhotosService {

  private PhotosDao photosDao = new PhotosDaoImpl();

  @Override
  public List<Photo> getPhotos() {
    try {
      return photosDao.getPhotos();
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
    return null;
  }

  @Override
  public List<Photo> getPhotos(int photoId) {
    try {
      return photosDao.getPhotos(photoId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
    return null;
  }

  @Override
  public List<Photo> getUserFavouritePhotos(int userId) {
    try {
      return photosDao.getUserFavouritePhotos(userId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
    return null;
  }

  @Override
  public List<Photo> getUserLikedPhotos(int userId) {
    try {
      return photosDao.getUserLikedPhotos(userId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
    return null;
  }

  @Override
  public void addUserLikedPhotos(int userId, int photoId) {
    try {
      photosDao.addUserLikedPhotos(userId, photoId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
  }

  @Override
  public void addUserFavPhotos(int userId, int photoId) {
    try {
      photosDao.addUserFavPhotos(userId, photoId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
  }

  @Override
  public void removeUserLikedPhotos(int userId, int photoId) {
    try {
      photosDao.removeUserLikedPhotos(userId, photoId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
  }

  @Override
  public void removeUserFavPhotos(int userId, int photoId) {
    try {
      photosDao.removeUserFavPhotos(userId, photoId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
  }

  @Override
  public int getNoOfLikesOfPhoto(int photoId) {
    try {
      return photosDao.getNoOfLikesOfPhoto(photoId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
    return 0;
  }
}
