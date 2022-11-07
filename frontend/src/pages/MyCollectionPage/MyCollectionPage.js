import React, { useEffect, useState } from "react";
import { GlobalContext } from "./../../Init";
import ImageCards from "./../../components/ImageCards/ImageCards";

const MyCollectionPage = () => {
  const {
    state: { photos, user },
    getAllPhotos,
  } = React.useContext(GlobalContext);

  const [likeDataArray, setLikeDataArray] = useState([]);

  useEffect(() => {
    if (user?.favourite) {
      setLikeDataArray(
        photos.filter(({ photoId }) =>
          user?.favourite.some((d) => d === photoId)
        )
      );
    }
  }, [user?.favourite]);

  return <ImageCards photos={likeDataArray} user={user} />;
};

export default MyCollectionPage;
