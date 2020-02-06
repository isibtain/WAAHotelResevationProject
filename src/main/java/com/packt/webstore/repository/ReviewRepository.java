package com.packt.webstore.repository;

import com.packt.webstore.domain.Review;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>  {
	
	@Query("select re from Review re where re.reviewID= :id")
	public Review findByReviewId(@Param("id") String reviewID);
}
