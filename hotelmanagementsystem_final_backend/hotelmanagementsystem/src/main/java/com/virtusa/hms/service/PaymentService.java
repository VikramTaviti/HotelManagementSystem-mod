package com.virtusa.hms.service;

import com.virtusa.hms.utility.PaymentDto;

public interface PaymentService {

	public PaymentDto addPaymentDetails(PaymentDto paymentDto);

	public PaymentDto getPaymentDetailsById(String paymentId);

}
