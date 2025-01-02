package com.virtusa.hms.entity.hotel;

import jakarta.persistence.Column;   
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.virtusa.hms.entity.user.User;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;
 
@Entity
public class Review {
	
	@Id
	@CustomPrimaryKeyId
	@Column(name="review_id")
	private String reviewId;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "dining_id")
	@JsonBackReference
	private DiningRecommendation diningRecommendation;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	@JsonBackReference
	private Hotel hotel;
	
	public Review() {
 
	}
 
	public Review(int rating, String comment) {
		this.rating = rating;
		this.comment = comment;
	}
 
	public String getReviewId() {
		return reviewId;
	}
 
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
 
	public int getRating() {
		return rating;
	}
 
	public void setRating(int rating) {
		this.rating = rating;
	}
 
	public String getComment() {
		return comment;
	}
 
	public void setComment(String comment) {
		this.comment = comment;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public DiningRecommendation getDiningRecommendation() {
		return diningRecommendation;
	}

	public void setDiningRecommendation(DiningRecommendation diningRecommendation) {
		this.diningRecommendation = diningRecommendation;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", rating=" + rating + ", comment=" + comment + ", user=" + user.getUserId() + "]";
	}
	
	
	
}