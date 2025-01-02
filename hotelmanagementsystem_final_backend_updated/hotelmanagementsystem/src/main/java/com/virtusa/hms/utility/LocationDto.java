package com.virtusa.hms.utility;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LocationDto {
	
	private String locationId;
	
	@Column(name="street_number", unique = true)
	@Pattern(regexp = "^\\d+[\\w\\s]*$", message = "Street Number must start with digits and may include letters and spaces.")
    private String streetNumber;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@Min(value = 100000)
    @Max(value = 999999)
	@NotNull
	private int pincode;
	
	@NotBlank
	private String country;

	public LocationDto() {
		super();
	}

	public LocationDto(String locationId,String street,String city,String state,
		int pincode,String country) {
		super();
		this.locationId = locationId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
	}
	

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "LocationDto [locationId=" + locationId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", country=" + country + "]";
	}

}
