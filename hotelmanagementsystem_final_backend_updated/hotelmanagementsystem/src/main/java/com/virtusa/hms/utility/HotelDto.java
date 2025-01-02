package com.virtusa.hms.utility;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class HotelDto {
	
	private String hotelId;
	
	@NotNull
	private String hotelName;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]{1,64}@(?:[a-zA-Z0-9-]{1,63}\\.){1,8}[a-zA-Z]{2,63}$")
	private String hotelEmail;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{10}$")
	private String hotelPhone;
	
	@DecimalMin(value = "1.0", inclusive = true)
	@DecimalMax(value = "5.0", inclusive = true)
	@NotNull
	private Double overAllRating;
	
	@NotNull
	private String hotelImage;
	
	@Valid
	private LocationDto locationDto;

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public Double getOverAllRating() {
		return overAllRating;
	}

	public void setOverAllRating(Double overAllRating) {
		this.overAllRating = overAllRating;
	}

	public LocationDto getLocationDto() {
		return locationDto;
	}

	public void setLocationDto(LocationDto locationDto) {
		this.locationDto = locationDto;
	}
	

	public String getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(String hotelImage) {
		this.hotelImage = hotelImage;
	}

	@Override
	public String toString() {
		return "HotelDto [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelEmail=" + hotelEmail
				+ ", hotelPhone=" + hotelPhone + ", overAllRating=" + overAllRating + ", locationDto=" + locationDto
				+ "]";
	}

	
}
