const Likes = {
  like_id,
  user_id,
  photo_id,

  get likeId() {
    return this.like_id;
  },

  set likeId(likeId) {
    this.like_id = likeId;
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
