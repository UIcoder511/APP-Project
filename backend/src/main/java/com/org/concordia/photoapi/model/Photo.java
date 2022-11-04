package com.org.concordia.photoapi.model;

public class Photo {

	private Integer photo_id;
	private Integer photographer_id;
	private String avg_color;
	private String title;
	private String imageMediumSize;
	private String imageLargeSize;
	private String imageOrignalSize;
	
	public Integer getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(Integer photo_id) {
		this.photo_id = photo_id;
	}
	public Integer getPhotographer_id() {
		return photographer_id;
	}
	public void setPhotographer_id(Integer photographer_id) {
		this.photographer_id = photographer_id;
	}
	public String getAvg_color() {
		return avg_color;
	}
	public void setAvg_color(String avg_color) {
		this.avg_color = avg_color;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageMediumSize() {
		return imageMediumSize;
	}
	public void setImageMediumSize(String imageMediumSize) {
		this.imageMediumSize = imageMediumSize;
	}
	public String getImageLargeSize() {
		return imageLargeSize;
	}
	public void setImageLargeSize(String imageLargeSize) {
		this.imageLargeSize = imageLargeSize;
	}
	public String getImageOrignalSize() {
		return imageOrignalSize;
	}
	public void setImageOrignalSize(String imageOrignalSize) {
		this.imageOrignalSize = imageOrignalSize;
	}
}
