package com.org.concordia.photoapi.service;

import java.util.List;

import com.org.concordia.photoapi.dao.PhotosDao;
import com.org.concordia.photoapi.dao.PhotosDaoImpl;
import com.org.concordia.photoapi.model.Photo;

public class PhotosServiceImpl implements PhotosService{
	
	private PhotosDao photosDao = new PhotosDaoImpl();
	
	@Override
	public List<Photo> getPhotos() {
		try {
			return photosDao.getPhotos();
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		return null;
	}

	@Override
	public List<Photo> getUserFavouritePhotos(int userId) {
		try {
			return photosDao.getUserFavouritePhotos(userId);
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		return null;
	}

	@Override
	public List<Photo> getUserLikedPhotos(int userId) {
		try {
			return photosDao.getUserLikedPhotos(userId);
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		return null;
	}

	@Override
	public int getUserIdByUsername(String username) {
		try {
			return photosDao.getUserIdByUsername(username);
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		return -1;
	}

	@Override
	public String getPasswordByUsername(String username) {
		try {
			return photosDao.getPasswordByUsername(username);
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		return null;
	}
}
