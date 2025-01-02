package com.virtusa.hms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.service.BookingService;
import com.virtusa.hms.utility.Message;
import com.virtusa.hms.utility.PaymentDto;



@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private Message message;
	
	@PostMapping("/add/{userId}")
	public ResponseEntity<PaymentDto> addBookingsAndPayments(@PathVariable("userId") String userId,@RequestBody PaymentDto paymentDto){
		PaymentDto responsePaymentDto = bookingService.addBookings(userId,paymentDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(responsePaymentDto);
	}
	
	@GetMapping("/payments/{userId}")
	public ResponseEntity<List<PaymentDto>> getAllPaymentsByUserId(@PathVariable("userId") String userId){
		List<PaymentDto> paymentDtoList = bookingService.getAllPaymentsByUserId(userId);
		System.out.println("controller --------"+paymentDtoList);
		return ResponseEntity.ok().body(paymentDtoList);
	}
	
	@PutMapping("/cancel/{userId}/{bookingId}")
	public ResponseEntity<Message> cancelBookingDetails(@PathVariable("userId") String userId,@PathVariable("bookingId") String bookingId){
		String response = bookingService.cancelBookingDetails(userId,bookingId);
		message.setMessage(response);
		return ResponseEntity.ok().body(message);
	}
	
	@PostMapping("/upgarde/{userId}/{roomId}")
	public ResponseEntity<Message> upgradeBooking(@PathVariable("userId") String userId,@PathVariable("roomId") String newRoomId,@RequestBody PaymentDto paymentDto){
		String response = bookingService.upgradeBooking(userId,newRoomId,paymentDto);
		message.setMessage(response);
		return ResponseEntity.ok().body(message);
	}
	
}
