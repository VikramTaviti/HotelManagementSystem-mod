package com.virtusa.hms.utility;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AttractionDto {
	
	private String attractionId;
	
	@NotNull
	private String attractionName;
	
	@NotNull(message = "Attraction email can't be null")
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]{1,64}@(?:[a-zA-Z0-9-]{1,63}\\.){1,8}[a-zA-Z]{2,63}$", message="Invalid email")
	private String attractionEmail;
	
	@Valid
	private LocationDto locationDto;

	public AttractionDto() {
		super();
	}

	public String getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(String attractionId) {
		this.attractionId = attractionId;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}

	public String getAttractionEmail() {
		return attractionEmail;
	}

	public void setAttractionEmail(String attractionEmail) {
		this.attractionEmail = attractionEmail;
	}

	public LocationDto getLocationDto() {
		return locationDto;
	}

	public void setLocationDto(LocationDto locationDto) {
		this.locationDto = locationDto;
	}

	@Override
	public String toString() {
		return "AttractionDto [attractionId=" + attractionId + ", attractionName=" + attractionName
				+ ", attractionEmail=" + attractionEmail + ", locationDto=" + locationDto + "]";
	}

}
