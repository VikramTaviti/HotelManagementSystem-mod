package com.virtusa.hms.utility;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.virtusa.hms.entity.Status;
import jakarta.validation.constraints.NotNull;


public class BookingDto {
	
	private String bookingId;
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkIn;
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkOut;
	
	private UserDto userDto;
	
	@NotNull
	private Status bookingStatus;
	
    private RoomDto roomDto;
	
	private UpgradeRoomDto upgradeRoomDto;

	public BookingDto() {
		super();
	}

	public BookingDto(String bookingId, @NotNull LocalDate checkIn, @NotNull LocalDate checkOut, UserDto userDto,
			@NotNull Status bookingStatus, RoomDto roomDto,
			UpgradeRoomDto upgradeRoomDto) {
		super();
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.userDto = userDto;
		this.bookingStatus = bookingStatus;
		this.roomDto = roomDto;
		this.upgradeRoomDto = upgradeRoomDto;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public Status getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Status bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public RoomDto getRoomDto() {
		return roomDto;
	}

	public void setRoomDto(RoomDto roomDto) {
		this.roomDto = roomDto;
	}

	public UpgradeRoomDto getUpgradeRoomDto() {
		return upgradeRoomDto;
	}

	public void setUpgradeRoomDto(UpgradeRoomDto upgradeRoomDto) {
		this.upgradeRoomDto = upgradeRoomDto;
	}

	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", userDto="
				+ userDto + ", bookingStatus=" + bookingStatus + ", roomDto=" + roomDto + ", upgradeRoomDto=" + upgradeRoomDto + "]";
	}
	
}
