package com.project.cs545.miu.service;

import java.util.List;

import com.project.cs545.miu.domain.Review;


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
	public double findAvg();
	public int findSum();
	public int findTotalReviews();
	
	public Review findByReviewID(String reviewID);
	
}
