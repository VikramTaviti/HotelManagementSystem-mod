package com.virtusa.hms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.payment.Payment;
import com.virtusa.hms.repository.PaymentRepository;
import com.virtusa.hms.utility.PaymentDto;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ListDtoEntityConverter listDtoEntityConverter;

	@Override
	public PaymentDto addPaymentDetails(PaymentDto paymentDto) {
		Payment payment = listDtoEntityConverter.convertPaymentDtoToEntity(paymentDto);
		Payment savedPayment = paymentRepository.save(payment);
		return listDtoEntityConverter.convertPaymentEntityToDto(savedPayment);
	}

	@Override
	public PaymentDto getPaymentDetailsById(String paymentId) {
		Optional<Payment> paymentDetails = paymentRepository.findById(paymentId);
		return listDtoEntityConverter.convertPaymentEntityToDto(paymentDetails.get());
	}

}
