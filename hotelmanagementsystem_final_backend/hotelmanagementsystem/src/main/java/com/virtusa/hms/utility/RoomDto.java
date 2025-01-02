package com.virtusa.hms.utility;
  
import com.virtusa.hms.entity.room.RoomStatus;

import jakarta.validation.constraints.NotNull;

public class RoomDto {

	private String roomId;

	@NotNull
	private int roomNo;

	@NotNull
	private RoomStatus roomStatus;
	
	@NotNull
	private String roomType;
	
	@NotNull
	private String amenities;
	
	@NotNull
	private String description;
	
	@NotNull
	private String photoUrl;
	
	@NotNull
	private double price;
	
	@NotNull
	private int maxOccupancy;
	
	private HotelDto hotelDto;

	public RoomDto() {
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

	public HotelDto getHotelDto() {
		return hotelDto;
	}

	public void setHotelDto(HotelDto hotelDto) {
		this.hotelDto = hotelDto;
	}

	@Override
	public String toString() {
		return "RoomDto [roomId=" + roomId + ", roomNo=" + roomNo + ", roomStatus=" + roomStatus + ", roomType="
				+ roomType + ", amenities=" + amenities + ", description=" + description + ", photoUrl=" + photoUrl
				+ ", price=" + price + ", maxOccupancy=" + maxOccupancy + ", hotelDto=" + hotelDto + "]";
	}

	

	
}
