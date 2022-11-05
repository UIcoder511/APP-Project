package com.org.concordia.photoapi.model;

public class Photographer {

  private Integer photographerId;
  private String photographer_name;
  private String photographer_url;

  public Integer getphotographerId() {
    return photographerId;
  }

  public void setphotographerId(Integer photographerId) {
    this.photographerId = photographerId;
  }

  public String getPhotographer_name() {
    return photographer_name;
  }

  public void setPhotographer_name(String photographer_name) {
    this.photographer_name = photographer_name;
  }

  public String getPhotographer_url() {
    return photographer_url;
  }

  public void setPhotographer_url(String photographer_url) {
    this.photographer_url = photographer_url;
  }
}
