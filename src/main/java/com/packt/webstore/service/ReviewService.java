package com.packt.webstore.service;

import com.packt.webstore.domain.Review;
import com.packt.webstore.domain.Room;

import java.util.List;


/*
* @author  Sibtain Raza
* @version 1.0
* @since   2020-02-04
*
* */

public interface ReviewService {
	public void save(Review review);
	public Review findRById(Long reviewId);
	public List<Review> findAll();
	public void deleteById (Long reviewId);
	public String generateReviewID();
	
	public Review findByReviewID(String reviewID);
	
}
