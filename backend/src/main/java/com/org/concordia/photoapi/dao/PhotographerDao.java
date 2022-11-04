package com.org.concordia.photoapi.dao;

import java.util.List;

import com.org.concordia.photoapi.model.Photo;

public interface PhotographerDao {
	public List<Photo> getPhotosByPhotographerName(String name);
}
