import React, { useState, useEffect } from "react";
import axios from "axios";

const ImageGallery = () => {
  const [images, setImages] = useState([]);
  const [newImage, setNewImage] = useState({ title: "", url: "" });
  const [editingImage, setEditingImage] = useState(null);

  // Fetch all images when component mounts
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/images")
      .then((response) => setImages(response.data))
      .catch((error) => console.error("Error fetching images:", error));
  }, []);

  // Handle input changes
  const handleInputChange = (e) => {
    setNewImage({ ...newImage, [e.target.name]: e.target.value });
  };

  // Add a new image
  const addImage = () => {
    if (newImage.title && newImage.url) {
      axios
        .post("http://localhost:8080/api/images", newImage)
        .then((response) => {
          setImages([...images, response.data]);
          setNewImage({ title: "", url: "" });
        })
        .catch((error) => console.error("Error adding image:", error));
    }
  };

  // Delete an image
  const deleteImage = (id) => {
    axios
      .delete(`http://localhost:8080/api/images/${id}`)
      .then(() => setImages(images.filter((image) => image.id !== id)))
      .catch((error) => console.error("Error deleting image:", error));
  };

  // Prepare to edit an image
  const startEdit = (image) => {
    setEditingImage(image);
  };

  // Update an image
  const updateImage = () => {
    axios
      .put(`http://localhost:8080/api/images/${editingImage.id}`, editingImage)
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

      {/* Form to Add New Image */}
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
        <button onClick={addImage}>Add Image</button>
      </div>

      {/* List of Images */}
      <h2>Image List</h2>
      <div className="image-list">
        {images.map((image) => (
          <div key={image.id} className="image-card">
            <h3>{image.title}</h3>
            <img src={image.url} alt={image.title} />
            <button onClick={() => deleteImage(image.id)}>Delete</button>
            <button onClick={() => startEdit(image)}>Edit</button>
          </div>
        ))}
      </div>

      {/* Edit Image */}
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
          <button onClick={updateImage}>Update Image</button>
          <button onClick={() => setEditingImage(null)}>Cancel</button>
        </div>
      )}
    </div>
  );
};

export default ImageGallery;
