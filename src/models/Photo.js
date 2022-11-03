class Photo {
  photo_id;
  width;
  height;
  photographer_id;

  getPhotoId() {
    return this.photo_id;
  }

  setPhotoId(photoId) {
    this.photo_id = photoId;
  }

  getWidth() {
    return this.width;
  }

  setWidth(width) {
    this.width = width;
  }

  getHeight() {
    return this.height;
  }

  setHeight(height) {
    this.height = height;
  }

  getPhotographerId() {
    return this.photographer_id;
  }

  setPhotographerId(photographerId) {
    this.photographer_id = photographerId;
  }
}

module.exports = Photo;
