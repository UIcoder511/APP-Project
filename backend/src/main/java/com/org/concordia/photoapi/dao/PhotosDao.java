package com.org.concordia.photoapi.dao;

import java.util.List;

import com.org.concordia.photoapi.model.Photo;

public interface PhotosDao {
	public List<Photo> getPhotos();
}
