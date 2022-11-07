import React, { useEffect, useState } from "react";
import { GlobalContext } from "./../../Init";
import ImageCards from "./../../components/ImageCards/ImageCards";

const LikedPage = () => {
  const {
    state: { photos, user },
    getAllPhotos,
  } = React.useContext(GlobalContext);

  const [likeDataArray, setLikeDataArray] = useState([]);

  useEffect(() => {
    if (user?.like) {
      setLikeDataArray(
        photos.filter(({ photoId }) => user?.like.some((d) => d === photoId))
      );
    }
  }, [user?.like]);

  return <ImageCards photos={likeDataArray} user={user} />;
};

export default LikedPage;
