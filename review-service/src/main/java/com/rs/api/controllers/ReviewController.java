package com.rs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.api.models.Review;
import com.rs.api.services.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {
	
	
	@Autowired
	private ReviewService reviewService;
	
	
	@PostMapping("/review")
	public ResponseEntity<?> create(@RequestBody Review review){
		return ResponseEntity.ok(reviewService.saveReview(review));
	}
	
	@GetMapping("/review/{productId}")
	public ResponseEntity<?> create(@PathVariable("productId") String productId){
		return ResponseEntity.ok(reviewService.getReview(productId));
	}

}
