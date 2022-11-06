import React from "react";
import { pageToSectionMap } from "./../../pages/Pages";
import AsideLink from "./AsideLink/AsideLink";
import { Box, Button } from "@mui/material";
import Logo from "./../../ui/Logo/Logo";
import User from "../User/User";

const Aside = ({ activeLink = "", setActiveLink }) => {
  return (
    <Box
      component="aside"
      sx={{
        display: "flex",
        flexDirection: "column",
        backgroundColor: (theme) => theme.palette.primary.main,
        color: (theme) => theme.palette.colors.textWhite,
        height: "100%",
        width: "200px",
        borderRadius: (theme) => theme.shape.borderRadius,
      }}
    >
      <Logo />
      <User />
      <Box
        sx={{
          flex: 1,
          display: "flex",
          flexDirection: "column",
          //   justifyContent: "center",
        }}
      >
        {Object.values(pageToSectionMap).map(({ title, key, icon }) => (
          <AsideLink
            key={key}
            Icon={icon}
            title={title}
            isActive={activeLink === key}
            onClick={() => setActiveLink(key)}
          />
        ))}
      </Box>
      <Button>Signout</Button>
    </Box>
  );
};

export default Aside;
