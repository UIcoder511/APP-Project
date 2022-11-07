import React, { useEffect, useState } from "react";
import ImageCard from "./ImageCard/ImageCard";
import photo from "../../assets/photo.jpeg";
import { Box } from "@mui/material";
import axios from "axios";
import { GlobalContext } from "./../../Init";

const ImageCards = ({ photos = [], user }) => {
  const handleLikeButton = (photoId, isAlreadyLiked) => {
    const url = isAlreadyLiked
      ? "/photo-api/remove-liked-photos?"
      : "/photo-api/add-liked-photos?";
    return axios
      .post(url + "username=" + user.username + "&photoId=" + photoId)
      .then((data) => {
        console.log(data);
      });
  };
  const handleBookmarkButton = (photoId, isAlreadyBookmarked) => {
    const url = isAlreadyBookmarked
      ? "/photo-api/remove-fav-photos?"
      : "/photo-api/add-fav-photos?";
    return axios
      .post(url + "username=" + user.username + "&photoId=" + photoId)
      .then((data) => {
        console.log(data);
      });
  };

  return (
    <Box
      sx={{
        display: "grid",
        gridTemplateColumns: "1fr 1fr 1fr",
        gap: "30px",
        overflow: "auto",
      }}
    >
      {photos.map(
        ({
          avgColor,
          imageMediumSize,
          photoId,
          photographer: { photographerName, photographerId },

          title,
        }) => (
          <ImageCard
            key={photoId}
            isLiked={user.like?.includes(photoId)}
            isBookmarked={user.favourite?.includes(photoId)}
            thumbnailSrc={imageMediumSize}
            noOfLikes={12}
            photographerName={photographerName}
            imageBgColor={avgColor}
            title={title}
            photoId={photoId}
            handleLikeButton={handleLikeButton}
            handleBookmarkButton={handleBookmarkButton}
          />
        )
      )}
    </Box>
  );
};

export default ImageCards;
