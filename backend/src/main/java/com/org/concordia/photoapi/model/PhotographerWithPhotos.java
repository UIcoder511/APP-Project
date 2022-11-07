package com.org.concordia.photoapi.model;

import java.util.List;

public class PhotographerWithPhotos {

  private Photographer photographer;
  private List<Photo> photos;

  public PhotographerWithPhotos(Photographer photographer, List<Photo> photos) {
    this.photographer = photographer;
    this.photos = photos;
  }

  public Photographer getPhotographer() {
    return photographer;
  }

  public List<Photo> getPhotos() {
    return photos;
  }

  public void setPhotographer(Photographer photographer) {
    this.photographer = photographer;
  }

  public void setPhotos(List<Photo> photos) {
    this.photos = photos;
  }
}
