package com.org.concordia.photoapi.model;

public class Favorite {

  private int favoriteId;
  private int userId;
  private int photoId;

  public Favorite(int favoriteId, int photoId, int userId) {
    this.favoriteId = favoriteId;
    this.photoId = photoId;
    this.userId = userId;
  }

  public int getFavoriteId() {
    return favoriteId;
  }

  public int getPhotoId() {
    return photoId;
  }

  public int getUserId() {
    return userId;
  }

  public void setFavoriteId(int favoriteId) {
    this.favoriteId = favoriteId;
  }

  public void setPhotoId(int photoId) {
    this.photoId = photoId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
