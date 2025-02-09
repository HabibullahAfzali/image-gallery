import React, { useState, useEffect } from "react";
import {
  fetchImages,
  addImage,
  deleteImage,
  updateImage,
} from "../../services/imageService";
import "./ImageGallery.css";

const ImageGallery = () => {
  const [images, setImages] = useState([]);
  const [newImage, setNewImage] = useState({ title: "", url: "" });
  const [editingImage, setEditingImage] = useState(null);

  useEffect(() => {
    fetchImages()
      .then((response) => setImages(response.data))
      .catch((error) => console.error("Error fetching images:", error));
  }, []);

  const handleInputChange = (e) => {
    setNewImage({ ...newImage, [e.target.name]: e.target.value });
  };

  const handleAddImage = () => {
    if (newImage.title && newImage.url) {
      addImage(newImage)
        .then((response) => {
          setImages([...images, response.data]);
          setNewImage({ title: "", url: "" });
        })
        .catch((error) => console.error("Error adding image:", error));
    }
  };

  const handleDeleteImage = (id) => {
    deleteImage(id)
      .then(() => setImages(images.filter((image) => image.id !== id)))
      .catch((error) => console.error("Error deleting image:", error));
  };

  const handleUpdateImage = () => {
    updateImage(editingImage.id, editingImage)
      .then((response) => {
        const updatedImages = images.map((img) =>
          img.id === editingImage.id ? response.data : img
        );
        setImages(updatedImages);
        setEditingImage(null);
      })
      .catch((error) => console.error("Error updating image:", error));
  };

  return (
    <div className="container">
      <h1>Image Gallery</h1>

      <div>
        <h2>Add New Image</h2>
        <input
          type="text"
          name="title"
          placeholder="Image Title"
          value={newImage.title}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="url"
          placeholder="Image URL"
          value={newImage.url}
          onChange={handleInputChange}
        />
        <button onClick={handleAddImage}>Add Image</button>
      </div>

      <h2>Image List</h2>
      <div className="image-list">
        {images.map((image) => (
          <div className="image-card" key={image.id}>
            <img src={image.url} alt={image.title} />
            <h3>{image.title}</h3>
            <button onClick={() => handleDeleteImage(image.id)}>Delete</button>
            <button onClick={() => setEditingImage(image)}>Edit</button>
          </div>
        ))}
      </div>

      {editingImage && (
        <div>
          <h2>Edit Image</h2>
          <input
            type="text"
            value={editingImage.title}
            onChange={(e) =>
              setEditingImage({ ...editingImage, title: e.target.value })
            }
          />
          <input
            type="text"
            value={editingImage.url}
            onChange={(e) =>
              setEditingImage({ ...editingImage, url: e.target.value })
            }
          />
          <button onClick={handleUpdateImage}>Update Image</button>
          <button onClick={() => setEditingImage(null)}>Cancel</button>
        </div>
      )}
    </div>
  );
};

export default ImageGallery;
