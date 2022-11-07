package com.org.concordia.photoapi.service;

import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.Photographer;
import java.util.List;

public interface PhotographerService {
  public List<Photographer> getPhotographers();

  public List<Photo> getPhotosByPhotographerId(int photographerId);
}
