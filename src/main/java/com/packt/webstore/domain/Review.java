package com.packt.webstore.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
public class Review  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

    @Min(value = 0)
	private String reviewID;
	
	

	@NotEmpty(message="{String.empty}")
	private String firstName;
	
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@NotEmpty
	private String lastName;

	
	
	@Transient
    private MultipartFile roomImage;
	
	public MultipartFile getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(MultipartFile roomImage) {
		this.roomImage = roomImage;
	}

	@NotEmpty
	private String comment;
	
	@NotEmpty
	@Max(value=5, message= "{Max}")
	@Min(value=1, message="{Min}")
	private String rating;

	public Review(int id, String fname,String ltext, String rtext, String rscore) {
		super();
		this.id = id;
		this.firstName= fname;
		this.lastName = ltext;
		this.comment = rtext;
		this.rating = rscore;
	}

	public Review() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getReviewText() { return comment; }

	public void setReviewText(String text) {
		this.comment = text;
	}
	
	public String getReviewID() {
		return reviewID;
	}

	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}


	public String getReviewScore() { return rating; }

	public void setReviewScore(String score) { this.rating = score; }

}
