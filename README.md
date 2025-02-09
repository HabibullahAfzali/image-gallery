# Image Gallery Application (backend)

This project is an **Image Gallery API** built with **Spring Boot** following the **Hexagonal Architecture (Ports and Adapters)** design pattern. It provides RESTful endpoints for managing images with a flexible and maintainable structure.

## Features
- Retrieve all images
- Add new images
- Update existing images
- Delete images

## Architecture Overview

The project is organized using **Hexagonal Architecture** to maintain a clean separation between the business logic and external systems. It consists of the following layers:

- **Core (Business Logic)**: Contains the domain model (`Image`), business logic, and ports (interfaces).
- **Adapters**: Implements the ports, including the input adapter (REST controller) and output adapter (JPA repository).
- **Infrastructure**: Handles database access and configuration.

### Project Structure
src/main/java/com/imagegallery/image_gallery ├── core # Business logic │    ├── model # Domain model (Image entity) │    ├── port # Ports (interfaces) for input and output │    └── service # Business service implementation    ├── adapter # Input and output adapters │    ├── in # Input adapter (REST Controller) │    └── out # Output adapter (JPA Repository Adapter)    └── infrastructure # Infrastructure (DB repository and configurations)

## API Endpoints

- **GET /api/images**: Retrieve all images
- **POST /api/images**: Add a new image
- **PUT /api/images/{id}**: Update an existing image by ID
- **DELETE /api/images/{id}**: Delete an image by ID

## Technologies
- Java
- Spring Boot
- JPA (Hibernate)
- MYSQL DATABASE

## Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd image-gallery
## Run the Project:
    ```bash
    mvn spring-boot:run
## Image Gallery Frontend

This is the frontend for an **Image Gallery Application** built with **React.js**. The application allows users to view, add, update, and delete images. It interacts with a Spring Boot backend via RESTful APIs.

## Features
- Display a list of images from the backend.
- Add a new image by specifying a title and URL.
- Edit the title and URL of existing images.
- Delete images from the gallery.

## Folder Structure

- `src/components/ImageGallery/`
  - `ImageGallery.js` (Main component for displaying images)
  - `ImageGallery.css` (Styles for the ImageGallery component)
- `src/services/`
  - `imageService.js` (API calls for interacting with the backend)
- `src/style/`
  - `App.css` (Global styles for the application)
- `src/App.js` (Main application component)
- `src/index.js` (Entry point of the React app)
- `src/reportWebVitals.js` (Performance measurement script)




## API Integration
The application interacts with the following backend API endpoints:
- **GET /api/images**: Retrieve all images
- **POST /api/images**: Add a new image
- **PUT /api/images/{id}**: Update an image by ID
- **DELETE /api/images/{id}**: Delete an image by ID

The API base URL can be configured in the `services/imageService.js` file.

## Getting Started

### Prerequisites
- Node.js (version 14.x or higher)
- npm or yarn

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd frontend/image-gallery
   npm install
