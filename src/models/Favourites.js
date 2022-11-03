const Favourites = {
  fav_id,
  user_id,
  photo_id,

  get favId() {
    return this.fav_id;
  },

  set favId(favId) {
    this.fav_id = favId;
  },

  get userId() {
    return this.user_id;
  },

  set userId(userId) {
    this.user_id = userId;
  },

  get photoId() {
    return this.photo_id;
  },

  set photoId(photoId) {
    this.photo_id = photoId;
  },
};
