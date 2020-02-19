package com.packt.webstore.domain;

import javax.validation.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Review  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rvid;
	
    @Min(value = 0)
	private String reviewID;
    

	public void setSumRating(int sumRating) {
		sumRating+=(Integer.parseInt(rating));
	}
	
	@NotEmpty(message="{NotEmpty.validation}")
	private String firstName;
	
	@NotEmpty(message="{NotEmpty.validation}")
	private String lastName;
	
	@Transient
    private MultipartFile roomImage;
	
	@NotEmpty(message="{NotEmpty.validation}")
	@Size(min = 8, max = 100, message="{Size.validation}")
	private String comment;
	
	@NotEmpty(message="{NotEmpty.validation}")
	private String rating;

	public Review(int id, String fname,String ltext, String rtext, String rscore) {
		super();
		this.rvid = id;
		this.firstName= fname;
		this.lastName = ltext;
		this.comment = rtext;
		this.rating = rscore;
	}

	public Review() {

	}

	public int getId() {
		return rvid;
	}

	public void setId(int id) {
		this.rvid = id;
	}

	
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
	
	public MultipartFile getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(MultipartFile roomImage) {
		this.roomImage = roomImage;
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

	public String getReviewScore() { 
		return rating; 
		
	}

	public void setReviewScore(String score) { 
		this.rating = score; 	
	}

}
