package com.org.concordia.photoapi.service;

import java.util.List;

import com.org.concordia.photoapi.dao.PhotographerDao;
import com.org.concordia.photoapi.dao.PhotographerDaoImpl;
import com.org.concordia.photoapi.model.Photo;

public class PhotographerServiceImpl implements PhotographerService {
	
	private PhotographerDao photographerDao = new PhotographerDaoImpl();
	
	public List<Photo> getPhotosByPhotographerName(String name){
		try {
			return photographerDao.getPhotosByPhotographerName(name);
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		return null; //todo update here later
		
	}
}
