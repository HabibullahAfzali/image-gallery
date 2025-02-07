package com.imagegallery.image_gallery.repository;

import com.imagegallery.image_gallery.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
