import React from "react";
import { Box } from "@mui/material";
import PhotographerCard from "./PhotographerCard/PhotographerCard";

const PhotographerCards = () => {
  return (
    <Box
      sx={{
        display: "grid",
        gridTemplateColumns: "1fr 1fr 1fr",
        gap: "30px",
      }}
    >
      <PhotographerCard photographerName="Umang" />
      <PhotographerCard photographerName="Umang" />
      <PhotographerCard photographerName="Umang" />
    </Box>
  );
};

export default PhotographerCards;
