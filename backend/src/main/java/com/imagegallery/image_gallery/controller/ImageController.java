package com.imagegallery.image_gallery.controller;

import com.imagegallery.image_gallery.entity.Image;
import com.imagegallery.image_gallery.repository.ImageRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

	@Autowired
	private ImageRepository imageRepository;

	@GetMapping
	public List<Image> getAllImages(){

		return  imageRepository.findAll();
	}

	@PostMapping
	public Image addImage(@RequestBody Image image){

		return imageRepository .save(image);

	}
	@DeleteMapping("/{id}")

	public void deleteImage(@PathVariable Long id){
		imageRepository.deleteById(id);
	}

	@PutMapping("/{id}")

	public  Image updateImage(@PathVariable Long id, @RequestBody Image newImage){


		return imageRepository.findById(id).map(image -> {
			image.setTitle(newImage.getTitle());
			image.setUrl(newImage.getUrl());
			return imageRepository.save(image);
		}).orElseGet(() ->{
			newImage.setId(id);
			return imageRepository.save(newImage);
		});
	}
}
