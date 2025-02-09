import axios from "axios";

const API_URL = "http://localhost:8080/api/images";

// Fetch all images
export const fetchImages = () => {
  return axios.get(API_URL);
};

// Add a new image
export const addImage = (newImage) => {
  return axios.post(API_URL, newImage);
};

// Delete an image
export const deleteImage = (id) => {
  return axios.delete(`${API_URL}/${id}`);
};

// Update an image
export const updateImage = (id, updatedImage) => {
  return axios.put(`${API_URL}/${id}`, updatedImage);
};
