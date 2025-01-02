package com.virtusa.hms.utility;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import com.virtusa.hms.entity.Status;
import com.virtusa.hms.entity.payment.PaymentMethod;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PaymentDto {

	private String paymentId;
	
	
	private double amount;
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime paymentDateTime;
	 
    private BookingDto bookingDto;
    
	private PaymentMethod paymentMethod;
    
	@NotNull
	private Status paymentStatus;

	public PaymentDto() {
		super();
	}

	public PaymentDto(String paymentId, @Min(100) @NotNull double amount, @NotNull LocalDateTime paymentDateTime,
			BookingDto bookingDto, PaymentMethod paymentMethod, @NotNull Status paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDateTime = paymentDateTime;
		this.bookingDto = bookingDto;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
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

	public BookingDto getBookingDto() {
		return bookingDto;
	}

	public void setBookingDto(BookingDto bookingDto) {
		this.bookingDto = bookingDto;
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
		return "PaymentDto [paymentId=" + paymentId + ", amount=" + amount + ", paymentDateTime=" + paymentDateTime
				+ ", bookingDto=" + bookingDto + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus
				+ "]";
	}
		
}
