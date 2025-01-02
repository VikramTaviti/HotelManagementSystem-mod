package com.virtusa.hms.utility;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;

public class SearchFields {
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkinDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;
    @NotNull
    private String roomType;
    @NotNull
    private String location;
	public SearchFields() {
		super();
	}

	public SearchFields(LocalDate checkinDate, LocalDate checkoutDate, String roomType) {
		super();
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.roomType = roomType;
	}

	public LocalDate getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(LocalDate checkinDate) {
		this.checkinDate = checkinDate;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
