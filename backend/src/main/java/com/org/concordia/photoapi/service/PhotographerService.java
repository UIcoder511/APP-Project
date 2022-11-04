package com.org.concordia.photoapi.service;

import java.util.List;

import com.org.concordia.photoapi.model.Photo;

public interface PhotographerService {
	
	public List<Photo> getPhotosByPhotographerName(String name);

}
