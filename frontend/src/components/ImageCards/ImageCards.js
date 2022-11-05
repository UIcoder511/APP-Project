import React from "react";
import ImageCard from "./ImageCard/ImageCard";
import photo from "../../assets/photo.jpeg";
import { Box } from "@mui/material";

const ImageCards = () => {
  return (
    <Box
      sx={{
        display: "grid",
        gridTemplateColumns: "1fr 1fr 1fr",
        gap: "30px",
      }}
    >
      <ImageCard
        thumbnailSrc={photo}
        noOfLikes={12}
        photographerName="Umang"
      ></ImageCard>
      <ImageCard
        thumbnailSrc={photo}
        noOfLikes={12}
        photographerName="Umang"
      ></ImageCard>
      <ImageCard
        thumbnailSrc={photo}
        noOfLikes={12}
        photographerName="Umang"
        isLiked
      ></ImageCard>
      <ImageCard
        thumbnailSrc={photo}
        noOfLikes={12}
        photographerName="Umang"
        isLiked
        isBookmarked
      ></ImageCard>
      <ImageCard
        thumbnailSrc={photo}
        noOfLikes={12}
        isBookmarked
        photographerName="Umang"
      ></ImageCard>
    </Box>
  );
};

export default ImageCards;
