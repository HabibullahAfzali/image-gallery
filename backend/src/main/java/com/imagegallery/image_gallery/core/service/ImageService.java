package com.imagegallery.image_gallery.core.service;

import com.imagegallery.image_gallery.core.model.Image;
import com.imagegallery.image_gallery.core.port.in.ImageServicePort;
import com.imagegallery.image_gallery.core.port.out.ImageRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements ImageServicePort {

	private final ImageRepositoryPort imageRepositoryPort;

	@Autowired
	public ImageService(ImageRepositoryPort imageRepositoryPort) {
		this.imageRepositoryPort = imageRepositoryPort;
	}

	@Override
	public List<Image> getAllImages() {
		return imageRepositoryPort.findAll();
	}

	@Override
	public Image addImage(Image image) {
		return imageRepositoryPort.save(image);
	}

	@Override
	public void deleteImage(Long id) {
		imageRepositoryPort.deleteById(id);
	}

	@Override
	public Image updateImage(Long id, Image newImage) {
		return imageRepositoryPort.findById(id).map(image -> {
			image.setTitle(newImage.getTitle());
			image.setUrl(newImage.getUrl());
			return imageRepositoryPort.save(image);
		}).orElseGet(() -> {
			newImage.setId(id);
			return imageRepositoryPort.save(newImage);
		});
	}
}
