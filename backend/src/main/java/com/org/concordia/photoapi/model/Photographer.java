package com.org.concordia.photoapi.model;

public class Photographer {

  private Integer photographerId;
  private String photographerName;
  private String photographerUrl;
  
  public Photographer() {}

  public Photographer() {}

  public Photographer(
    Integer photographerId,
    String photographerName,
    String photographerUrl
  ) {
    this.photographerId = photographerId;
    this.photographerName = photographerName;
    this.photographerUrl = photographerUrl;
  }

  public Integer getphotographerId() {
    return photographerId;
  }

  public void setPhotographerId(Integer photographerId) {
    this.photographerId = photographerId;
  }

  public String getphotographerName() {
    return photographerName;
  }

  public void setphotographerName(String photographerName) {
    this.photographerName = photographerName;
  }

  public String getphotographerUrl() {
    return photographerUrl;
  }

  public void setphotographerUrl(String photographerUrl) {
    this.photographerUrl = photographerUrl;
  }
}
