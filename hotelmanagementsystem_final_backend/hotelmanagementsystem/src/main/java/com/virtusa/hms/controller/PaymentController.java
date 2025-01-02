package com.virtusa.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.service.PaymentService;
import com.virtusa.hms.utility.PaymentDto;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/add")
	public ResponseEntity<PaymentDto> addPayment(@RequestBody PaymentDto paymentDto){
		PaymentDto responsePaymentDto = paymentService.addPaymentDetails(paymentDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(responsePaymentDto);
	}
	
	@GetMapping("{paymentId}")
	public ResponseEntity<PaymentDto> getPaymentDetailsById(@PathVariable("paymentId") String paymentId){
		PaymentDto responsePaymentDto = paymentService.getPaymentDetailsById(paymentId);
		return ResponseEntity.status(HttpStatus.CREATED).body(responsePaymentDto);
	}
	
}
