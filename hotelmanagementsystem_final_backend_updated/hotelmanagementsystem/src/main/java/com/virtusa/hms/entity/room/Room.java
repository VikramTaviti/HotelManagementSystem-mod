package com.virtusa.hms.entity.room;
     

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.virtusa.hms.entity.booking.Booking;
import com.virtusa.hms.entity.hotel.Hotel;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Room {

	@Id
	@CustomPrimaryKeyId
	@Column(name = "room_id")
	private String roomId;

	@Column(name = "room_no")
	private int roomNo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "room_status")
	private RoomStatus roomStatus;
	
	@Column(name="room_type")
	private String roomType;
	
	@Column(name="room_amenities")
	private String amenities;
	
	@Column(name="room_description")
	private String description;
	
	@Column(name="room_photo_url")
	private String photoUrl;
	
	@Column(name="room_price")
	private double price;
	
	@Column(name="room_maxoccupancy")
	private int maxOccupancy;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	@JsonBackReference
	private Hotel hotel;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;


	public Room() {
		super();
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}




	public String getRoomId() {
		return roomId;
	}


	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}


	public int getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}


	public RoomStatus getRoomStatus() {
		return roomStatus;
	}


	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public String getAmenities() {
		return amenities;
	}


	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getMaxOccupancy() {
		return maxOccupancy;
	}


	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public List<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNo=" + roomNo + ", roomStatus=" + roomStatus + ", roomType=" + roomType
				+ ", amenities=" + amenities + ", description=" + description + ", photoUrl=" + photoUrl + ", price="
				+ price + ", maxOccupancy=" + maxOccupancy + ", hotel=" + hotel + ", bookings=" + bookings + "]";
	}
	

}
