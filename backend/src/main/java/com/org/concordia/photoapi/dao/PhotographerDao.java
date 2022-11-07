package com.org.concordia.photoapi.dao;

import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.Photographer;
import java.util.List;

public interface PhotographerDao {
  public List<Photo> getPhotosByPhotographerId(int photographerId);

  public List<Photographer> getPhotographers();
}
