# Image Gallery Application

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


## API Endpoints

- **GET /api/images**: Retrieve all images
- **POST /api/images**: Add a new image
- **PUT /api/images/{id}**: Update an existing image by ID
- **DELETE /api/images/{id}**: Delete an image by ID

## Technologies
- Java
- Spring Boot
- JPA (Hibernate)
- H2 Database (or any other database)

## Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd image-gallery
## Run the Project:
- mvn spring-boot:run
