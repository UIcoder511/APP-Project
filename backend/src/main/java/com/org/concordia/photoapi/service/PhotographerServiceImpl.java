package com.org.concordia.photoapi.service;

import com.org.concordia.photoapi.dao.PhotographerDao;
import com.org.concordia.photoapi.dao.PhotographerDaoImpl;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.Photographer;
import java.util.List;

public class PhotographerServiceImpl implements PhotographerService {

  private PhotographerDao photographerDao = new PhotographerDaoImpl();

  public List<Photo> getPhotosByPhotographerId(int photographerId) {
    try {
      return photographerDao.getPhotosByPhotographerId(photographerId);
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
    return null; //todo update here later
  }

  @Override
  public List<Photographer> getPhotographers() {
    try {
      return photographerDao.getPhotographers();
    } catch (Exception ex) {
      //throw photo-api custom exception here
      //log
    }
    return null;
  }
}
