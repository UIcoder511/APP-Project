package com.org.concordia.photoapi.dao;

import java.util.List;

import com.org.concordia.photoapi.model.Photo;

public interface PhotosDao {
	public List<Photo> getPhotos();
	public List<Photo> getUserFavouritePhotos(int userId);
	public List<Photo> getUserLikedPhotos(int userId);
	public int getUserIdByUsername(String username);
	public String getPasswordByUsername(String username);
}
