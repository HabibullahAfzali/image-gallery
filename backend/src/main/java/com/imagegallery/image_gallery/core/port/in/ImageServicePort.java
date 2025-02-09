package com.imagegallery.image_gallery.core.port.in;

import com.imagegallery.image_gallery.core.model.Image;
import java.util.List;

public interface ImageServicePort {
	List<Image> getAllImages();
	Image addImage(Image image);
	void deleteImage(Long id);
	Image updateImage(Long id, Image newImage);
}
