package com.imagegallery.image_gallery.adapter.out;

import com.imagegallery.image_gallery.core.model.Image;
import com.imagegallery.image_gallery.core.port.out.ImageRepositoryPort;
import com.imagegallery.image_gallery.infrastructure.repository.JpaImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaImageRepositoryAdapter implements ImageRepositoryPort {

	private final JpaImageRepository jpaImageRepository;

	@Autowired
	public JpaImageRepositoryAdapter(JpaImageRepository jpaImageRepository) {
		this.jpaImageRepository = jpaImageRepository;
	}

	@Override
	public List<Image> findAll() {
		return jpaImageRepository.findAll();
	}

	@Override
	public Optional<Image> findById(Long id) {
		return jpaImageRepository.findById(id);
	}

	@Override
	public Image save(Image image) {
		return jpaImageRepository.save(image);
	}

	@Override
	public void deleteById(Long id) {
		jpaImageRepository.deleteById(id);
	}
}
