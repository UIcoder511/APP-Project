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
}
