package com.org.concordia.photoapi.model;

public class Like {

  private int likeId;
  private int photoId;
  private int userId;

  public Like(int likeId, int photoId, int userId) {
    this.likeId = likeId;
    this.photoId = photoId;
    this.userId = userId;
  }

  public int getLikeId() {
    return likeId;
  }

  public int getPhotoId() {
    return photoId;
  }

  public int getUserId() {
    return userId;
  }

  public void setLikeId(int likeId) {
    this.likeId = likeId;
  }

  public void setPhotoId(int photoId) {
    this.photoId = photoId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
