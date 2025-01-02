package com.virtusa.hms.entity.hotel;

import java.util.List;

import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;    
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Location {

	@Id
	@CustomPrimaryKeyId
	@Column(name = "location_id")
	private String locationId; 
	
	@Column(name="street_number", unique = true)
	private String streetNumber;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private int pincode;
	
	@Column(name = "country")
	private String country;
	
	@OneToMany(mappedBy = "location" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Attraction> attractions;
	
	@OneToMany(mappedBy = "location" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DiningRecommendation> diningRecommendation;
	
	@OneToOne(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Hotel hotel;

	public Location() {

	}
	
	public Location(String streetNumber, String street, String city, String state, int pincode, String country) {
		super();
		this.streetNumber = streetNumber;
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

	public List<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(List<Attraction> attractions) {
		this.attractions = attractions;
	}

	public List<DiningRecommendation> getDiningRecommendation() {
		return diningRecommendation;
	}

	public void setDiningRecommendation(List<DiningRecommendation> diningRecommendation) {
		this.diningRecommendation = diningRecommendation;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
		return "Location [locationId=" + locationId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", country=" + country + "]";
	}

}