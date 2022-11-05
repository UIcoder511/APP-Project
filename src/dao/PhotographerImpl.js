const db = require("D:\\Masters\\SOEN-6441\\APP-Project-Javascript\\APP-Project\\src\\util\\DBConnect");
const photoPOJO = require("D:\\Masters\\SOEN-6441\\APP-Project-Javascript\\APP-Project\\src\\models\\Photo.js");
const Photo = require("D:\\Masters\\SOEN-6441\\APP-Project-Javascript\\APP-Project\\src\\models\\Photo.js");

class PhotographerImpl {
  //to get all photos by photographer name
  getAllPhotosByPhotographerName(pname) {
    let photo = [];
    let p_photos = new photoPOJO();
    if (db != null) {
      let photoSql =
        "SELECT p.photo_id, pg.photographer_id FROM Photos p,Photographer pg where p.photographer_id = pg.photographer_id and pg.p_name = '" +
        pname +
        "'";

      db.each(photoSql, [], (err, row) => {
        if (err) {
          throw err;
        }
        console.log(row.photo_id);
        console.log(row.photographer_id);

        p_photos.setPhotoId(row.photo_id);
        p_photos.setPhotographerId(row.photographer_id);
        console.log(p_photos.getPhotoId());

        photo.push(p_photos.getPhotoId());
        console.log(photo);
      });
      return this.photo;
    }
  }
}

module.exports = PhotographerImpl;
