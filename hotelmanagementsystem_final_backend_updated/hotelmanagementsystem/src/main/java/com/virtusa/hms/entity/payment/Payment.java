package com.virtusa.hms.entity.payment;

import java.time.LocalDateTime;  

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.virtusa.hms.entity.Status;
import com.virtusa.hms.entity.booking.Booking;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;
 
@Entity
public class Payment {
	
	@Id
	@CustomPrimaryKeyId
	@Column(name = "payment_id")
	private String paymentId;
	
	private double amount;
	
	@Column(name = "payment_datetime")
	private LocalDateTime paymentDateTime;
	 
    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonBackReference
    private Booking booking;
    
    @Enumerated(EnumType.STRING)
    @Column(name="payment_method")
	private PaymentMethod paymentMethod;
    
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private Status paymentStatus;
 
	public Payment() {
 
	}
 
	public Payment( double amount, LocalDateTime paymentDateTime) {
		super();
		
		this.amount = amount;
		this.paymentDateTime = paymentDateTime;
	
		
	}
 
	public String getPaymentId() {
		return paymentId;
	}
 
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
 
	public double getAmount() {
		return amount;
	}
 
	public void setAmount(double amount) {
		this.amount = amount;
	}
 
	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}
 
	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}
 
	public Booking getBooking() {
		return booking;
	}
 
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
 
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
 
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
 
	public Status getPaymentStatus() {
		return paymentStatus;
	}
 
	public void setPaymentStatus(Status paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", paymentDateTime=" + paymentDateTime
				+ ", booking=" + booking + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus
				+ "]";
	}
 
}

