package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Review;
import com.packt.webstore.domain.Room;
import com.packt.webstore.repository.ReviewRepository;
import com.packt.webstore.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
 * @author  Sibtain Raza
 * @version 1.0
 * @since   2020-02-04
 *
 * */

@Service
@Transactional 
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public void save(Review review) {
		reviewRepository.save(review);
	}


	@Override
	public Review findRById(Long reviewId) {
		// TODO Auto-generated method stub
		return reviewRepository.findById(reviewId).get();

	}

	@Override
	public List<Review> findAll() {
		return (List<Review>) reviewRepository.findAll();
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteById(Long reviewId) {
		reviewRepository.deleteById(reviewId);
		
	}

	@Override
	public String generateReviewID() {
		
		Integer currentSize = this.findAll().size() + 1;
		String zeros = "00";
		if(currentSize > 9) zeros = "0";
		if(currentSize > 99) zeros = "";
		String reviewID = "RE" + zeros +currentSize;
		return reviewID;
		
		
		
		// TODO Auto-generated method stub
	}

	@Override
	public Review findByReviewID(String reviewID) {
		// TODO Auto-generated method stub
		return reviewRepository.findByReviewId(reviewID);
	}
}
