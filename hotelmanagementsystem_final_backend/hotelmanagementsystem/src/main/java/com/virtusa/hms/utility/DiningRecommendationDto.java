package com.virtusa.hms.utility;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class DiningRecommendationDto {

	private String diningId;

	@NotNull
	private String diningname;

	@DecimalMin(value = "1.0", inclusive = true)
	@DecimalMax(value = "5.0", inclusive = true)
	@NotNull
	private Double diningOverallRating;

	@NotNull(message = "diningOption email can't be null")
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]{1,64}@(?:[a-zA-Z0-9-]{1,63}\\.){1,8}[a-zA-Z]{2,63}$", message = "Invalid email")
	private String diningRecommendationEmail;

	private List<ReviewDto> reviewDto;

	@Valid
	private LocationDto locationDto;

	public DiningRecommendationDto() {
		super();
	}

	public String getDiningId() {
		return diningId;
	}

	public void setDiningId(String diningId) {
		this.diningId = diningId;
	}

	public String getDiningname() {
		return diningname;
	}

	public void setDiningname(String diningname) {
		this.diningname = diningname;
	}

	public Double getDiningOverallRating() {
		return diningOverallRating;
	}

	public void setDiningOverallRating(Double diningOverallRating) {
		this.diningOverallRating = diningOverallRating;
	}

	public String getDiningRecommendationEmail() {
		return diningRecommendationEmail;
	}

	public void setDiningRecommendationEmail(String diningRecommendationEmail) {
		this.diningRecommendationEmail = diningRecommendationEmail;
	}

	public List<ReviewDto> getReviewDto() {
		return reviewDto;
	}

	public void setReviewDto(List<ReviewDto> reviewDto) {
		this.reviewDto = reviewDto;
	}

	public LocationDto getLocationDto() {
		return locationDto;
	}

	public void setLocationDto(LocationDto locationDto) {
		this.locationDto = locationDto;
	}

	@Override
	public String toString() {
		return "DiningRecommendationDto [diningId=" + diningId + ", diningname=" + diningname + ", diningOverallRating="
				+ diningOverallRating + ", diningRecommendationEmail=" + diningRecommendationEmail + ", reviewDto="
				+ reviewDto + ", locationDto=" + locationDto + "]";
	}


}
