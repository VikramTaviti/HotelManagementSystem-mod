package com.virtusa.hms.entity.hotel;

import java.util.List; 

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.virtusa.hms.entity.room.Room;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;

@Entity
public class Hotel {

	@Id
	@CustomPrimaryKeyId
	@Column(name = "hotel_id")
	private String hotelId;
	
	@Column(name = "hotel_name")
	private String hotelName;
	
	@Column(name = "email", unique = true)
	private String hotelEmail;
	
	@Column(name = "phone")
	private String hotelPhone;
	
	@Column(name = "averageRating")
	private Double overAllRating;
	
	@Column(name = "hotel_image")
	private String hotelImage;
	
	
	@OneToOne
	@JoinColumn(name = "location_id")
	@JsonBackReference
	private Location location;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Review> review;
	
	@OneToMany(mappedBy="hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Room> rooms;
	
	@ManyToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Facility> services;

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Hotel() {
		super();
	}

	public Hotel(String hotelName) {
		super();
		this.hotelName = hotelName;
	}

	public String getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(String hotelImage) {
		this.hotelImage = hotelImage;
	}

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public List<Facility> getServices() {
		return services;
	}

	public void setServices(List<Facility> services) {
		this.services = services;
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

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelEmail=" + hotelEmail + ", hotelPhone="
				+ hotelPhone + ", location=" + location + ", review=" + review + ", rooms=" + rooms
				+ ", services=" + services + "]";
	}

}
