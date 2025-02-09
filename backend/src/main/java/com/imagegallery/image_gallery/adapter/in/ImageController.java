package com.imagegallery.image_gallery.adapter.in;

import com.imagegallery.image_gallery.core.model.Image;
import com.imagegallery.image_gallery.core.port.in.ImageServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

	private final ImageServicePort imageServicePort;

	@Autowired
	public ImageController(ImageServicePort imageServicePort) {
		this.imageServicePort = imageServicePort;
	}

	@GetMapping
	public ResponseEntity<List<Image>> getAllImages() {
		return ResponseEntity.ok(imageServicePort.getAllImages());
	}

	@PostMapping
	public ResponseEntity<Image> addImage(@RequestBody Image image) {
		return ResponseEntity.ok(imageServicePort.addImage(image));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image newImage) {
		return ResponseEntity.ok(imageServicePort.updateImage(id, newImage));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
		imageServicePort.deleteImage(id);
		return ResponseEntity.noContent().build();
	}
}
