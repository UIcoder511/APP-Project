package com.org.concordia.photoapi.gateways;

import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.Photographer;

import java.sql.ResultSet;
import java.util.List;

public interface PhotographerGateway {
  public List<Photo> getPhotosByPhotographerId(int photographerId);

  public List<Photographer> getPhotographers();
  
  public ResultSet getPhotosByPhotographerId1(int photographerId);

  public ResultSet getPhotographers1();
}
