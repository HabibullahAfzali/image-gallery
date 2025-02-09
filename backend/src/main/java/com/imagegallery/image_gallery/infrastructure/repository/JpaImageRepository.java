package com.imagegallery.image_gallery.infrastructure.repository;

import com.imagegallery.image_gallery.core.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaImageRepository extends JpaRepository<Image, Long> {

}
