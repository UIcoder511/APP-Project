export const getPhotoPath = (photoId) => `/photo-api/assets/${photoId}`;

export const getUserObjectFromLocalStorage = () => {
  const user = localStorage.getItem("user");
  if (user) {
    return JSON.parse(user);
  }

  return null;
};

export const setUserObjectFromLocalStorage = (user) => {
  localStorage.setItem("user", JSON.stringify(user));
};
