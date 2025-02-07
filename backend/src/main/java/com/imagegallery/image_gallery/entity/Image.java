package com.imagegallery.image_gallery.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String url;
}
