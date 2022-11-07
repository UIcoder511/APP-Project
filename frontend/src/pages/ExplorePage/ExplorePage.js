import React from "react";
import { GlobalContext } from "../../Init";
import ImageCards from "./../../components/ImageCards/ImageCards";

const ExplorePage = () => {
  const {
    state: { photos, user },
    getAllPhotos,
  } = React.useContext(GlobalContext);

  return <ImageCards photos={photos} user={user} />;
};

export default ExplorePage;
