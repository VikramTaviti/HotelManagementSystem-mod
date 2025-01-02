package com.virtusa.hms.service;


import java.util.List;

import com.virtusa.hms.utility.PaymentDto;


public interface BookingService {

	public PaymentDto addBookings(String userId,PaymentDto paymentDto);

	public List<PaymentDto> getAllPaymentsByUserId(String userId);

	public String cancelBookingDetails(String userId, String bookingId);

	public String upgradeBooking(String userId, String newRoomId, PaymentDto paymentDto);

}
