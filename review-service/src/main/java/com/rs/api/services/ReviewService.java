package com.rs.api.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rs.api.models.Review;
import com.rs.api.repository.ReviewRepository;
import com.rs.api.repository.UserRepository;
import com.rs.api.util.CustomUtil;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	RestTemplate restTemplate;

	public Review saveReview(Review review) {

		Long id = ((Number) CustomUtil.getUser().get("id")).longValue();
		;

		review.setUser(userRepository.getOne(id));
		return reviewRepository.save(review);
	}

	public Map<String, ?> getReview(String productId) {
		RestTemplate restTemplate = new RestTemplate();

		String ROOT_URI = "http://localhost:7070/product/" + productId;
		
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> params = new HashMap<String, Object>();

		Object userStr = restTemplate.getForObject(ROOT_URI, Object.class);
		
		params.put("product",userStr);
		
		params.put("rating", reviewRepository.avg(productId).toString());
		params.put("ratingCount", reviewRepository.count(productId).toString());

		

		return params;
	}
	

}
