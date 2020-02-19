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

import java.util.ArrayList;
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
	
	
	public List<Review> list = new ArrayList<>();
	public int sumRating=0;
	public int listSize=0;
	private double avgRating=0;
    

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
		
		list = (List<Review>) reviewRepository.findAll();
		return list;
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


	@Override
	public double findAvg() {    //Seperating Business Logic from controller to Service as advised 
		int lsiz = this.findAll().size();
		int sum=0;
		List<Review> l = new ArrayList<Review>();
		for (Review r : list)
			sum+= Integer.parseInt(r.getRating());
		
		if (sum>0) {
		double avg= (double)sum/lsiz;
		return avg;
		}
		else
		return 0.0;
	}


	@Override
	public int findSum() {
		
		return 0;
	}


	@Override
	public int findTotalReviews() {
		listSize= list.size();
		return listSize;

	}
}
