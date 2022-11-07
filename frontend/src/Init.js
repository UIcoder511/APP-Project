import React, { useEffect } from "react";
import App from "./App";
import axios from "axios";

import {
  getUserObjectFromLocalStorage,
  setUserObjectFromLocalStorage,
} from "./utils/Util";

export const GlobalContext = React.createContext();

export const storeActions = {
  SET_USER: "SET_USER",
  SET_PHOTOS: "SET_PHOTOS",
  LOGOUT: "LOGOUT",
};

function store(state, action) {
  switch (action.type) {
    case storeActions.SET_USER: {
      setUserObjectFromLocalStorage(action.payload);
      return { ...state, user: action.payload };
    }
    case storeActions.SET_PHOTOS: {
      return { ...state, photos: action.payload || [] };
    }
    case storeActions.LOGOUT: {
      setUserObjectFromLocalStorage(null);
      return { ...state, user: null };
    }

    default: {
      throw new Error(`Unhandled action type: ${action.type}`);
    }
  }
}

const Init = () => {
  const [state, dispatch] = React.useReducer(store, {
    user: getUserObjectFromLocalStorage(),
    photos: [],
  });

  const getAllPhotos = () => {
    axios.get("/photo-api/getAllPhotos").then(({ data }) => {
      // console.log(data);
      dispatch({ type: storeActions.SET_PHOTOS, payload: data });
    });
  };

  useEffect(() => {
    if (state.user) getAllPhotos();
  }, [state.user]);

  return (
    <>
      <GlobalContext.Provider value={{ state, dispatch, getAllPhotos }}>
        <App />
      </GlobalContext.Provider>
    </>
  );
};

export default Init;
