import React, { useEffect, useState } from "react";
import ImageCard from "./ImageCard/ImageCard";
import photo from "../../assets/photo.jpeg";
import { Box } from "@mui/material";
import axios from "axios";

const ImageCards = () => {
  const [photosData, setPhotosData] = useState([]);

  useEffect(() => {
    axios.get("/photo-api/getAllPhotos").then(({ data }) => {
      // console.log(data);
      setPhotosData(data);
    });
  }, []);

  return (
    <Box
      sx={{
        display: "grid",
        gridTemplateColumns: "1fr 1fr 1fr",
        gap: "30px",
        overflow: "auto",
      }}
    >
      {photosData.map(
        ({
          avgColor,
          imageMediumSize,
          photoId,
          photographer: { photographerName, photographerId },

          title,
        }) => (
          <ImageCard
            key={photoId}
            thumbnailSrc={imageMediumSize}
            noOfLikes={12}
            photographerName={photographerName}
            imageBgColor={avgColor}
            title={title}
          />
        )
      )}
    </Box>
  );
};

export default ImageCards;
