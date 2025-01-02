package com.virtusa.hms.utility;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class ReviewDto {

	private String reviewId;
	
	@DecimalMin(value = "1.0", inclusive = true)
	@DecimalMax(value = "5.0", inclusive = true)
	@NotNull
	private int rating;
	
	@NotNull
	private String comment;
	
	private UserDto userDto;
	
	private HotelDto hotelDto;
	
	private DiningRecommendationDto diningRecommendationDto;

	public ReviewDto() {
		super();
	}

	public ReviewDto(String reviewId,int rating,String comment, UserDto userDto) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.comment = comment;
		this.userDto = userDto;
	}

	public HotelDto getHotelDto() {
		return hotelDto;
	}

	public void setHotelDto(HotelDto hotelDto) {
		this.hotelDto = hotelDto;
	}

	public DiningRecommendationDto getDiningRecommendationDto() {
		return diningRecommendationDto;
	}

	public void setDiningRecommendationDto(DiningRecommendationDto diningRecommendationDto) {
		this.diningRecommendationDto = diningRecommendationDto;
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

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	@Override
	public String toString() {
		return "ReviewDto [reviewId=" + reviewId + ", rating=" + rating + ", comment=" + comment + ", userDto="
				+ userDto + "]";
	}
	
}
