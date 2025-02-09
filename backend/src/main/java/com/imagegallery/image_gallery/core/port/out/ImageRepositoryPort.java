package com.imagegallery.image_gallery.core.port.out;

import com.imagegallery.image_gallery.core.model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageRepositoryPort {
	List<Image> findAll();
	Optional<Image> findById(Long id);
	Image save(Image image);
	void deleteById(Long id);
}
