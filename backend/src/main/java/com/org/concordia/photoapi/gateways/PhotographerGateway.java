package com.org.concordia.photoapi.gateways;

import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.Photographer;
import java.util.List;

public interface PhotographerGateway {
  public List<Photo> getPhotosByPhotographerId(int photographerId);

  public List<Photographer> getPhotographers();
}
