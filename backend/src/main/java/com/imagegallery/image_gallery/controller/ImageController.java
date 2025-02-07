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


}
