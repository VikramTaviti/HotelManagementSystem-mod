package com.virtusa.hms.entity.booking;

import java.time.LocalDate;     
import java.util.List;

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
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.virtusa.hms.entity.Status;
import com.virtusa.hms.entity.payment.Payment;
import com.virtusa.hms.entity.room.Room;
import com.virtusa.hms.entity.room.UpgradeRoom;
import com.virtusa.hms.entity.user.User;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;
 
 
@Entity
public class Booking {
 
	@Id
	@CustomPrimaryKeyId
	@Column(name="booking_id")
	private String bookingId;
	
	@Column(name="check_in")
	private LocalDate checkIn;
	
	@Column(name="check_out")
	private LocalDate checkOut;
	
	@Enumerated(EnumType.STRING)
	@Column(name="booking_status")
	private Status bookingStatus;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "room_id")
	@JsonBackReference
    private Room room;
	
	@OneToOne
	@JoinColumn(name="upgrade_room_id")
	@JsonBackReference
	private UpgradeRoom upgradeRoom;
	
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Payment> payments;
	
	public Booking() {
		super();
	}

	public Booking(String bookingId, LocalDate checkIn, LocalDate checkOut, Status bookingStatus, User user,
			Room room) {
		super();
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.bookingStatus = bookingStatus;
		this.user = user;
		this.room = room;
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

	public Status getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Status bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UpgradeRoom getUpgradeRoom() {
		return upgradeRoom;
	}

	public void setUpgradeRoom(UpgradeRoom upgradeRoom) {
		this.upgradeRoom = upgradeRoom;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", user=" + user.getUserId()
				+ ", bookingStatus=" + bookingStatus + ", upgradeRoom="
				+ upgradeRoom + "]";
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}

