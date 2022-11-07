import React, { useEffect, useState } from "react";
import PhotographerCards from "./../../components/PhotographerCards/PhotographerCards";
import axios from "axios";

const PhotographerPage = () => {
  const [photographersData, setPhotographersData] = useState([]);

  const getAllPhotographers = () => {
    axios.get("/photo-api/get-photographers-with-photos").then(({ data }) => {
      // console.log(data);
      setPhotographersData(data);
    });
  };

  useEffect(() => {
    getAllPhotographers();
  }, []);

  return (
    <>
      <PhotographerCards photographers={photographersData} />
    </>
  );
};

export default PhotographerPage;
