import { Avatar, Box, Tooltip } from "@mui/material";
import React from "react";
import Card from "../../../ui/Card/Card";
import FavoriteIcon from "@mui/icons-material/Favorite";

const ImageCard = ({
  imageSrc = "",
  isLiked = false,
  noOfLikes = 0,
  photographerName = "",
  imageBgColor = "#444",
  showOnlyImage = false,
  sxCard = {},
}) => {
  return (
    <Card
      sx={{
        display: "flex",
        flexDirection: "column",
        width: "100%",
        height: "250px",
        // padding: "5px",
        gap: "5px",
        ...sxCard,
      }}
    >
      <Box
        sx={{
          flex: 1,
          minHeight: "0px",
          width: "auto",
          backgroundColor: imageBgColor,
          borderRadius: "10px",
        }}
      >
        <Box
          component="img"
          src={imageSrc}
          sx={{ height: "100%", width: "100%", objectFit: "contain" }}
        ></Box>
      </Box>
      {!showOnlyImage && (
        <Box
          sx={{
            display: "flex",
            justifyContent: "space-between",
            height: "auto",
            backgroundColor: "transparent",
            // color: "#fff",
          }}
        >
          <Box
            sx={{
              display: "flex",
              alignItems: "center",
              gap: "5px",
            }}
          >
            <Avatar sx={{ width: 24, height: 24, fontSize: "0.8rem" }}>
              {photographerName.charAt(0)}
            </Avatar>
            <Box sx={{ fontSize: "1rem" }}>{photographerName}</Box>
          </Box>
          <Box
            sx={{
              display: "flex",
              alignItems: "center",
              gap: "5px",
            }}
          >
            <Tooltip title="No of Likes">
              <FavoriteIcon
                fontSize="small"
                sx={{ color: isLiked && "#ea4c89" }}
              />
            </Tooltip>
            <div>{noOfLikes}</div>
          </Box>
        </Box>
      )}
    </Card>
  );
};

export default ImageCard;
