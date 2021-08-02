package com.rs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rs.api.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	
	@Query(value = "SELECT avg(rating) FROM Review where productId = ?1")
	public Double avg(String productId);
	
	@Query(value = "SELECT count(rating) FROM Review where productId = ?1")
	public Double count(String productId);

}
