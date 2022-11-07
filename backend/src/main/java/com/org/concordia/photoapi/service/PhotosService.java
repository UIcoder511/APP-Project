package com.org.concordia.photoapi.service;

import java.util.List;

import com.org.concordia.photoapi.model.Photo;

public interface PhotosService {
	
	public List<Photo> getPhotos();
	public List<Photo> getUserFavouritePhotos(int userId);
	public List<Photo> getUserLikedPhotos(int userId);
	public List<Photo> getPhotos(int photoId);
	public void addUserLikedPhotos(int userId,int photoId);
	public void addUserFavPhotos(int userId, int photoId);
	public void removeUserLikedPhotos(int userId, int photoId);
	public void removeUserFavPhotos(int userId, int photoId);
}
